package com.postgreSql.postgreSQL.service.IMPL;

import com.postgreSql.postgreSQL.entity.Jurusan;
import com.postgreSql.postgreSQL.entity.Mahasiswa;
import com.postgreSql.postgreSQL.entity.Matakuliah;
import com.postgreSql.postgreSQL.entity.MatkulMahasiswa;
import com.postgreSql.postgreSQL.model.request.MahasiswaRequest;
import com.postgreSql.postgreSQL.model.response.MahasiswaResponse;
import com.postgreSql.postgreSQL.model.response.MatkulMahasiswaResponse;
import com.postgreSql.postgreSQL.repository.JurusanRepository;
import com.postgreSql.postgreSQL.repository.MahasiswaRepository;
import com.postgreSql.postgreSQL.repository.MatakuliahRepository;
import com.postgreSql.postgreSQL.repository.MatkulMahasiswaRepository;
import com.postgreSql.postgreSQL.service.MahasiswaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MahasiswaServiceImpl implements MahasiswaService {
    private final MahasiswaRepository mahasiswaRepository;
    private final JurusanRepository jurusanRepository;
    private final MatakuliahRepository matakuliahRepository;
    private final MatkulMahasiswaRepository matkulMahasiswaRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MahasiswaResponse create(MahasiswaRequest mahasiswa) {
        Optional<Jurusan> byId = jurusanRepository.findById(mahasiswa.getJurusan());
        Mahasiswa mahasiswa1 = Mahasiswa.builder()
                .nim(mahasiswa.getNim())
                .nama(mahasiswa.getNama())
                .jenis_kelamin(mahasiswa.getJenis_kelamin())
                .jurusan(byId.get())
                .build();
        Mahasiswa save = mahasiswaRepository.save(mahasiswa1);

        Optional<Mahasiswa> byId1 = mahasiswaRepository.findById(save.getId());

        List<MatkulMahasiswa> matkulMahasiswaList= new ArrayList<>();
        for (int i=0;i<mahasiswa.getId_matkul_mahasiswa().size();i++){
            Optional<Matakuliah> byId2 = matakuliahRepository.findById(mahasiswa.getId_matkul_mahasiswa().get(i).getId_matkul());
            MatkulMahasiswa matkulMahasiswa= MatkulMahasiswa.builder()
                .mahasiswa(byId1.get())
                .matakuliah(byId2.get())
                .build();
            matkulMahasiswaRepository.save(matkulMahasiswa);
            matkulMahasiswaList.add(matkulMahasiswa);
        }

        Mahasiswa mahasiswa2 = Mahasiswa.builder()
                .id(save.getId())
                .jurusan(save.getJurusan())
                .nim(save.getNim())
                .nama(save.getNama())
                .jenis_kelamin(save.getJenis_kelamin())
                .matkulMahasiswaList(matkulMahasiswaList)
                .build();
        Mahasiswa save1 = mahasiswaRepository.save(mahasiswa2);

        List<MatkulMahasiswaResponse> matkulMahasiswaResponses = new ArrayList<>();
        for (int i=0;i<matkulMahasiswaList.size();i++){
            Optional<MatkulMahasiswa> byId2 = matkulMahasiswaRepository.findById(save1.getMatkulMahasiswaList().get(i).getId());
            MatkulMahasiswa matkulMahasiswa = byId2.get();

            MatkulMahasiswaResponse matkulMahasiswaResponse = MatkulMahasiswaResponse.builder()
                    .id_matkul(matkulMahasiswa.getMatakuliah().getNama_matkul())
                    .build();
            matkulMahasiswaResponses.add(matkulMahasiswaResponse);
        }
        MahasiswaResponse mahasiswaResponse = MahasiswaResponse.builder()
                .id(save1.getId())
                .nim(save1.getNim())
                .nama(save.getNama())
                .jenis_kelamin(save1.getJenis_kelamin())
                .jurusan(byId.get().getNama_jurusan())
                .id_matkul_mahasiswa(matkulMahasiswaResponses)
                .build();
        return mahasiswaResponse;
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> all = mahasiswaRepository.findAll();
        return all;
    }

    @Override
    public Mahasiswa update(MahasiswaRequest mahasiswa) {
        Optional<Jurusan> byId = jurusanRepository.findById(mahasiswa.getJurusan());
        Mahasiswa mahasiswa1 = Mahasiswa.builder()
                .id(mahasiswa.getId())
                .jenis_kelamin(mahasiswa.getJenis_kelamin())
                .nama(mahasiswa.getNama())
                .nim(mahasiswa.getNim())
                .jurusan(byId.get())
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
