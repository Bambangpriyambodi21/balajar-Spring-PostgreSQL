package com.postgreSql.postgreSQL.model.request;

import com.postgreSql.postgreSQL.entity.Jurusan;
import com.postgreSql.postgreSQL.entity.MatkulMahasiswa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MahasiswaRequest {
    private String id;
    private String nim;
    private String nama;
    private String jenis_kelamin;
    private Long jurusan;
    private List<MatkulMahasiswaRequest> id_matkul_mahasiswa;
}
