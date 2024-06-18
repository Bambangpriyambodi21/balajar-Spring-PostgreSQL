package com.postgreSql.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "jadwal")
public class Jadwal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jadwal;
    private Date tanggal;
    private String ruangan;
}
