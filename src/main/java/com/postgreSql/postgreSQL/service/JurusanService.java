package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Jurusan;

import java.util.List;

public interface JurusanService {
    Jurusan creat(Jurusan jurusan);
    List<Jurusan> getAll();
    Jurusan update(Jurusan jurusan);
    String delete(Long id);
}
