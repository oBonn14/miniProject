package com.mini.project.service;

import com.mini.project.constans.Response;
import com.mini.project.model.Ticket;
import com.mini.project.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketService {

    private final TicketRepository ticketRepository;

    public Page<Ticket> getAllTicket(int status, Pageable pageable){
        return ticketRepository.findAllTicket(status,pageable);
    }

    public List<Ticket> getListTickets(Page<Ticket> page){
        return page.stream().map(this::mapperTicket).collect(Collectors.toList());
    }

    private Ticket mapperTicket(Ticket ticket){
        return Ticket.builder()
                .idTicket(ticket.getIdTicket())
                .jenisTicket(ticket.getJenisTicket())
                .hargaTicket(ticket.getHargaTicket())
                .statusTicket(ticket.getStatusTicket())
                .build();
    }

    public Response createTicket(Ticket ticket) {

       Ticket data = ticketRepository.saveAndFlush(ticket);

        if(data.getIdTicket() != null) {

        return Response.SUCCESS;

        }else {
            return Response.FAILLED;
        }
    }

    public Response buyTicket(Long ticket) {
        Optional<Ticket> data = ticketRepository.findById(ticket);
        if(data.isPresent()) {
            Ticket dataTicket = data.get();
            dataTicket.setStatusTicket(1);
            ticketRepository.saveAndFlush(dataTicket);
            return Response.SUCCESS;
        }
        else {
            return Response.FAILLED;
        }
    }

}
