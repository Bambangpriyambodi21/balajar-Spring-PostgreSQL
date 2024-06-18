package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Matakuliah;
import com.postgreSql.postgreSQL.repository.MatakuliahRepository;
import com.postgreSql.postgreSQL.service.MatakuliahService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatakuliahServiceImpl implements MatakuliahService {
    private final MatakuliahRepository matakuliahRepository;

    @Override
    public Matakuliah create(Matakuliah matakuliah) {
        Matakuliah matakuliah1 = Matakuliah.builder()
                .sks(matakuliah.getSks())
                .nama_matkul(matakuliah.getNama_matkul())
                .build();
        Matakuliah save = matakuliahRepository.save(matakuliah1);
        return save;
    }

    @Override
    public List<Matakuliah> getAll() {
        List<Matakuliah> all = matakuliahRepository.findAll();
        return all;
    }

    @Override
    public Matakuliah update(Matakuliah matakuliah) {
        Matakuliah matakuliah1 = Matakuliah.builder()
                .id_matakuliah(matakuliah.getId_matakuliah())
                .sks(matakuliah.getSks())
                .nama_matkul(matakuliah.getNama_matkul())
                .build();
        Matakuliah save = matakuliahRepository.save(matakuliah1);
        return save;
    }

    @Override
    public String delete(String id) {
        matakuliahRepository.deleteById(id);
        return "Mata kuliah deleted";
    }
}
