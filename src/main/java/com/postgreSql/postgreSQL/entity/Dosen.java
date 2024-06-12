package com.postgreSql.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "dosen")
public class Dosen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dosen;
    private String nama;
    private String no_telp;
    private String alamat;
}
