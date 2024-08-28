package com.mini.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "telur")
@NoArgsConstructor
@AllArgsConstructor
public class Telur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telur")
    private Long idTelur;

    @Column(name = "status_telur")
    private boolean  statusTelur;
}
