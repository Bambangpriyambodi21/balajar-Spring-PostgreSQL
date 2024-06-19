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
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nim;
    private String nama;
    private String jenis_kelamin;

    @ManyToOne
    @JoinColumn(name = "id_jurusan")
    private Jurusan jurusan;

    @OneToMany(mappedBy = "mahasiswa", cascade = CascadeType.PERSIST)
    private List<MatkulMahasiswa> matkulMahasiswaList;
}
