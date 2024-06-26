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

    private MahasiswaResponse conv(Mahasiswa mahasiswa){
        List<MatkulMahasiswaResponse> matkulMahasiswaResponses = new ArrayList<>();
        for (int i=0;i<mahasiswa.getMatkulMahasiswaList().size();i++){
            Optional<MatkulMahasiswa> byId2 = matkulMahasiswaRepository.findById(mahasiswa.getMatkulMahasiswaList().get(i).getId());
            MatkulMahasiswa matkulMahasiswa = byId2.get();

            MatkulMahasiswaResponse matkulMahasiswaResponse = MatkulMahasiswaResponse.builder()
                    .nama_matkul(matkulMahasiswa.getMatakuliah().getNama_matkul())
                    .dosen(matkulMahasiswa.getMatakuliah().getDosen().getNama())
                    .ruangan(matkulMahasiswa.getMatakuliah().getJadwal().getRuangan())
                    .sks(matkulMahasiswa.getMatakuliah().getSks())
                    .build();
            matkulMahasiswaResponses.add(matkulMahasiswaResponse);
        }
        MahasiswaResponse mahasiswaResponse = MahasiswaResponse.builder()
                .id(mahasiswa.getId())
                .nim(mahasiswa.getNim())
                .nama(mahasiswa.getNama())
                .jenis_kelamin(mahasiswa.getJenis_kelamin())
                .jurusan(mahasiswa.getJurusan().getNama_jurusan())
                .id_matkul_mahasiswa(matkulMahasiswaResponses)
                .build();
        return mahasiswaResponse;
    }

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

        MahasiswaResponse conv = conv(save1);
        return conv;
    }

    @Override
    public List<MahasiswaResponse> getAll() {
        List<Mahasiswa> all = mahasiswaRepository.findAll();
        List<MahasiswaResponse> mahasiswaResponses = new ArrayList<>();
        for (int i=0;i<all.size();i++){
            MahasiswaResponse conv = conv(all.get(i));
            mahasiswaResponses.add(conv);
        }
        return mahasiswaResponses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MahasiswaResponse update(MahasiswaRequest mahasiswa) {
        Optional<Mahasiswa> byId3 = mahasiswaRepository.findById(mahasiswa.getId());
        for (int i=0;i<byId3.get().getMatkulMahasiswaList().size();i++) {
            matkulMahasiswaRepository.deleteById(byId3.get().getMatkulMahasiswaList().get(i).getId());
        }

        Optional<Jurusan> byId = jurusanRepository.findById(mahasiswa.getJurusan());
        Mahasiswa mahasiswa1 = Mahasiswa.builder()
                .id(mahasiswa.getId())
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

        MahasiswaResponse conv = conv(save1);
        return conv;
    }

    @Override
    public String delete(String id) {
        mahasiswaRepository.deleteById(id);
        return "Data terhapus";
    }
}
