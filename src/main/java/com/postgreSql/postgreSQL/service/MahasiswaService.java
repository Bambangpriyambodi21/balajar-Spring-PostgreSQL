package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    Mahasiswa create(Mahasiswa mahasiswa);
    List<Mahasiswa> getAll();
    Mahasiswa update(Mahasiswa mahasiswa);
    String delete(String id);
}
