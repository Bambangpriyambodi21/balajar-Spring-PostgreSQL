package com.postgreSql.postgreSQL.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatkulMahasiswaResponse {
    private String nama_matkul;
    private int sks;
    private String dosen;
    private String ruangan;
}
