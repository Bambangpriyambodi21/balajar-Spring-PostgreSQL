package com.postgreSql.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "id_dosen")
    private Dosen dosen;
//    @OneToMany(mappedBy = "mata_kuliah")
//    private List<MatkulMahasiswa> matkulMahasiswaList;

}
