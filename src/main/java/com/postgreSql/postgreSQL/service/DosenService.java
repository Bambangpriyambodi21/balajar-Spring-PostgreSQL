package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.entity.Dosen;

import java.util.List;

public interface DosenService {
    Dosen create(Dosen dosen);
    List<Dosen> getAll();
    Dosen update(Dosen dosen);
    String delete(Long id);
}
