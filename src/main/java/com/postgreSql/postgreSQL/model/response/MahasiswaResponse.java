package com.postgreSql.postgreSQL.model.response;

import com.postgreSql.postgreSQL.model.request.MatkulMahasiswaRequest;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MahasiswaResponse {
    private String id;
    private String nim;
    private String nama;
    private String jenis_kelamin;
    private String jurusan;
    private List<MatkulMahasiswaResponse> id_matkul_mahasiswa;
}
