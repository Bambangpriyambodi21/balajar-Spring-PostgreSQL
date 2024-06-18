package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Jadwal;
import com.postgreSql.postgreSQL.repository.JadwalRepository;
import com.postgreSql.postgreSQL.service.JadwalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JadwalServiceImpl implements JadwalService {
    private final JadwalRepository jadwalRepository;

    @Override
    public Jadwal create(Jadwal jadwal) {
        Jadwal jadwal1 = Jadwal.builder()
                .ruangan(jadwal.getRuangan())
                .tanggal(jadwal.getTanggal())
                .build();
        Jadwal save = jadwalRepository.save(jadwal1);
        return save;
    }

    @Override
    public List<Jadwal> getAll() {
        List<Jadwal> all = jadwalRepository.findAll();
        return all;
    }

    @Override
    public Jadwal update(Jadwal jadwal) {
        Jadwal jadwal1 = Jadwal.builder()
                .id_jadwal(jadwal.getId_jadwal())
                .ruangan(jadwal.getRuangan())
                .tanggal(jadwal.getTanggal())
                .build();
        Jadwal save = jadwalRepository.save(jadwal1);
        return save;
    }

    @Override
    public String delete(Long id) {
        jadwalRepository.deleteById(id);
        return "Jadwal deleted";
    }
}
