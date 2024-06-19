package com.postgreSql.postgreSQL.model.request;

import com.postgreSql.postgreSQL.entity.Jurusan;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

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
}
