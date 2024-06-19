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

    @OneToOne
    @JoinColumn(name = "id_jadwal", referencedColumnName = "id_jadwal")
    private Jadwal jadwal;

    @OneToMany(mappedBy = "matakuliah", cascade = CascadeType.PERSIST)
    private List<MatkulMahasiswa> matkulMahasiswaList;

}
