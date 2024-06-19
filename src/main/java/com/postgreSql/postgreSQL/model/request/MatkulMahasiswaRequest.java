package com.postgreSql.postgreSQL.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatkulMahasiswaRequest {
    private String id_matkul;
    private String id_mahasiswa;
}
