package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Dosen;
import com.postgreSql.postgreSQL.repository.DosenRepository;
import com.postgreSql.postgreSQL.service.DosenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DosenServiceImpl implements DosenService {
    private final DosenRepository dosenRepository;

    @Override
    public Dosen create(Dosen dosen) {
        Dosen dosen1 = Dosen.builder()
                .alamat(dosen.getAlamat())
                .nama(dosen.getNama())
                .no_telp(dosen.getNo_telp())
                .build();
        Dosen save = dosenRepository.save(dosen1);
        return save;
    }

    @Override
    public List<Dosen> getAll() {
        List<Dosen> all = dosenRepository.findAll();
        return all;
    }

    @Override
    public Dosen update(Dosen dosen) {
        Dosen dosen1 = Dosen.builder()
                .id_dosen(dosen.getId_dosen())
                .no_telp(dosen.getNo_telp())
                .nama(dosen.getNama())
                .alamat(dosen.getAlamat())
                .build();
        Dosen save = dosenRepository.save(dosen1);
        return save;
    }

    @Override
    public String delete(Long id) {
        dosenRepository.deleteById(id);
        return "Data Dosen Deleted";
    }
}
