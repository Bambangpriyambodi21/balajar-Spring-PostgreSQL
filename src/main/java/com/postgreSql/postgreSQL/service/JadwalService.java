package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Jadwal;

import java.util.List;

public interface JadwalService {
    Jadwal create(Jadwal jadwal);
    List<Jadwal> getAll();
    Jadwal update(Jadwal jadwal);
    String delete(Long id);
}
