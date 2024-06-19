package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Dosen;
import com.postgreSql.postgreSQL.entity.Jadwal;
import com.postgreSql.postgreSQL.entity.Matakuliah;
import com.postgreSql.postgreSQL.model.request.MatakuliahRequest;
import com.postgreSql.postgreSQL.repository.DosenRepository;
import com.postgreSql.postgreSQL.repository.JadwalRepository;
import com.postgreSql.postgreSQL.repository.JurusanRepository;
import com.postgreSql.postgreSQL.repository.MatakuliahRepository;
import com.postgreSql.postgreSQL.service.MatakuliahService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatakuliahServiceImpl implements MatakuliahService {
    private final MatakuliahRepository matakuliahRepository;
    private final DosenRepository dosenRepository;
    private final JadwalRepository jadwalRepository;

    @Override
    public Matakuliah create(MatakuliahRequest matakuliah) {
        Optional<Dosen> byId = dosenRepository.findById(matakuliah.getDosen());
        Optional<Jadwal> byId1 = jadwalRepository.findById(matakuliah.getJadwal());
        Matakuliah matakuliah1 = Matakuliah.builder()
                .sks(matakuliah.getSks())
                .nama_matkul(matakuliah.getNama_matkul())
                .dosen(byId.get())
                .jadwal(byId1.get())
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
    public Matakuliah update(MatakuliahRequest matakuliah) {
        Optional<Dosen> byId = dosenRepository.findById(matakuliah.getDosen());
        Optional<Jadwal> byId1 = jadwalRepository.findById(matakuliah.getJadwal());
        Matakuliah matakuliah1 = Matakuliah.builder()
                .id_matakuliah(matakuliah.getId_matakuliah())
                .sks(matakuliah.getSks())
                .nama_matkul(matakuliah.getNama_matkul())
                .dosen(byId.get())
                .jadwal(byId1.get())
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
