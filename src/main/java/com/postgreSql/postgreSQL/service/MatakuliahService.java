package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Matakuliah;

import java.util.List;

public interface MatakuliahService {
    Matakuliah create(Matakuliah matakuliah);
    List<Matakuliah> getAll();
    Matakuliah update(Matakuliah matakuliah);
    String delete(String id);
}
