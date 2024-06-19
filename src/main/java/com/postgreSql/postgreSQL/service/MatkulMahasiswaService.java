package com.postgreSql.postgreSQL.service;

import com.postgreSql.postgreSQL.model.response.MatkulMahasiswaResponse;

public interface MatkulMahasiswaService {
    MatkulMahasiswaResponse findById(Long id);
}
