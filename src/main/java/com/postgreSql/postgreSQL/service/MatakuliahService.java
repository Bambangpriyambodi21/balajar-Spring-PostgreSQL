package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Matakuliah;
import com.postgreSql.postgreSQL.model.request.MatakuliahRequest;

import java.util.List;

public interface MatakuliahService {
    Matakuliah create(MatakuliahRequest matakuliah);
    List<Matakuliah> getAll();
    Matakuliah update(MatakuliahRequest matakuliah);
    String delete(String id);
}
