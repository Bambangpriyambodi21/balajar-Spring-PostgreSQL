package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.MatkulMahasiswa;
import com.postgreSql.postgreSQL.model.response.MatkulMahasiswaResponse;
import com.postgreSql.postgreSQL.repository.MatkulMahasiswaRepository;
import com.postgreSql.postgreSQL.service.MatkulMahasiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatkulMahasiswaServiceImpl implements MatkulMahasiswaService {
    private final MatkulMahasiswaRepository matkulMahasiswaRepository;

    @Override
    public MatkulMahasiswaResponse findById(Long id) {
        Optional<MatkulMahasiswa> byId = matkulMahasiswaRepository.findById(id);
        MatkulMahasiswa MatkulMahasiswaResponse = byId.get();
        return null;
    }
}
