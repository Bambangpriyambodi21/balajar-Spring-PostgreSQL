package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Mahasiswa;
import com.postgreSql.postgreSQL.repository.MahasiswaRepository;
import com.postgreSql.postgreSQL.service.MahasiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MahasiswaServiceImpl implements MahasiswaService {
    private final MahasiswaRepository mahasiswaRepository;

    @Override
    public Mahasiswa create(Mahasiswa mahasiswa) {
        Mahasiswa mahasiswa1 = Mahasiswa.builder()
                .nim(mahasiswa.getNim())
                .nama(mahasiswa.getNama())
                .jenis_kelamin(mahasiswa.getJenis_kelamin())
                .build();
        Mahasiswa save = mahasiswaRepository.save(mahasiswa1);
        return save;
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> all = mahasiswaRepository.findAll();
        return all;
    }

    @Override
    public Mahasiswa update(Mahasiswa mahasiswa) {
        Mahasiswa mahasiswa1 = Mahasiswa.builder()
                .id(mahasiswa.getId())
                .jenis_kelamin(mahasiswa.getJenis_kelamin())
                .nama(mahasiswa.getNama())
                .nim(mahasiswa.getNim())
                .build();
        Mahasiswa save = mahasiswaRepository.save(mahasiswa1);
        return save;
    }

    @Override
    public String delete(String id) {
        mahasiswaRepository.deleteById(id);
        return "Data terhapus";
    }
}
