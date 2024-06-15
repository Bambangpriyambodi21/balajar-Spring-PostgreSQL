package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Jurusan;
import com.postgreSql.postgreSQL.repository.JurusanRepository;
import com.postgreSql.postgreSQL.service.JurusanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JurusanServiceImpl implements JurusanService {
    private final JurusanRepository jurusanRepository;
    @Override
    public Jurusan creat(Jurusan jurusan) {
        Jurusan jurusan1 = Jurusan.builder()
                .nama_jurusan(jurusan.getNama_jurusan())
                .build();
        Jurusan save = jurusanRepository.save(jurusan1);
        return save;
    }

    @Override
    public List<Jurusan> getAll() {
        List<Jurusan> all = jurusanRepository.findAll();
        return all;
    }

    @Override
    public Jurusan update(Jurusan jurusan) {
        Jurusan jurusan1 = Jurusan.builder()
                .id_jurusan(jurusan.getId_jurusan())
                .nama_jurusan(jurusan.getNama_jurusan())
                .build();
        Jurusan save = jurusanRepository.save(jurusan1);
        return save;
    }

    @Override
    public String delete(Long id) {
        jurusanRepository.deleteById(id);
        return "Jurusan delete";
    }
}
