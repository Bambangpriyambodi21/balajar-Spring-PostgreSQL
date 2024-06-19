package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Mahasiswa;
import com.postgreSql.postgreSQL.model.request.MahasiswaRequest;

import java.util.List;

public interface MahasiswaService {
    Mahasiswa create(MahasiswaRequest mahasiswa);
    List<Mahasiswa> getAll();
    Mahasiswa update(MahasiswaRequest mahasiswa);
    String delete(String id);
}
