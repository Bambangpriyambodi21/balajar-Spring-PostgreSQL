package com.postgreSql.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "matkul_mahasiswa")
@Builder
public class MatkulMahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @ManyToOne
    @JoinColumn(name = "id_mahasiswa")
    private Mahasiswa mahasiswa;
    @ManyToOne
    @JoinColumn(name = "id_matakuliah")
    private Matakuliah matakuliah;
}
