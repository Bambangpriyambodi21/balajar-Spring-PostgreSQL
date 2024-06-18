package com.postgreSql.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "mata_kuliah")
public class Matakuliah {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_matakuliah;
    private int sks;
    private String nama_matkul;
}
