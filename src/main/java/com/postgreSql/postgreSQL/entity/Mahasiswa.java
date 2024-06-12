package com.postgreSql.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nim;
    private String nama;
    private String jenis_kelamin;
}
