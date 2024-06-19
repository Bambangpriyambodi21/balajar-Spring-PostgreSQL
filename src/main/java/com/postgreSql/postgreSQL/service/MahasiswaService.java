package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Mahasiswa;
import com.postgreSql.postgreSQL.model.request.MahasiswaRequest;
import com.postgreSql.postgreSQL.model.response.MahasiswaResponse;

import java.util.List;

public interface MahasiswaService {
    MahasiswaResponse create(MahasiswaRequest mahasiswa);
    List<Mahasiswa> getAll();
    Mahasiswa update(MahasiswaRequest mahasiswa);
    String delete(String id);
}
