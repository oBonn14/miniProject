package com.mini.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "reservasi")
@NoArgsConstructor
@AllArgsConstructor
public class Resevarsi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservasi")
    private Long idResevarsi;

    @Column(name = "hari_reservasi")
    private int hariReservasi;

    @Column(name = "status_reservasi")
    private boolean statusResevarsi;
}
