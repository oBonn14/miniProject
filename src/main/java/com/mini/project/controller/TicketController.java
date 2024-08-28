package com.mini.project.controller;

import com.mini.project.constans.Response;
import com.mini.project.model.Ticket;
import com.mini.project.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<Object> getAllTicket(@RequestParam int status, Pageable pageable) {
        Page<Ticket> tickets = ticketService.getAllTicket(status, pageable);
        List<Ticket> ticketList = ticketService.getListTickets(tickets);
        return ResponseEntity.ok(PagedModel.of(ticketList,
                new PagedModel.PageMetadata(tickets.getSize(), tickets.getNumber() ,tickets.getTotalElements()) ));
    }

    @PostMapping("/addTicket")
    public Response creteTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public Response buyTicket(@PathVariable Long id) {
        return ticketService.buyTicket(id);
    }
}
