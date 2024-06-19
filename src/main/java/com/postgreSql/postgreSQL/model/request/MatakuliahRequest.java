package com.postgreSql.postgreSQL.model.request;

import com.postgreSql.postgreSQL.entity.Dosen;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatakuliahRequest {
    private String id_matakuliah;
    private int sks;
    private String nama_matkul;
    private Long dosen;
}
