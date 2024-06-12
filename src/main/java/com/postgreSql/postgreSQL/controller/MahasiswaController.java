package com.postgreSql.postgreSQL.controller;

import com.postgreSql.postgreSQL.entity.Mahasiswa;
import com.postgreSql.postgreSQL.service.MahasiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mahasiswa")
public class MahasiswaController {
    private final MahasiswaService mahasiswaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Mahasiswa mahasiswa){
        Mahasiswa mahasiswa1 = mahasiswaService.create(mahasiswa);
        return ResponseEntity.ok(mahasiswa1);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Mahasiswa> all = mahasiswaService.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Mahasiswa mahasiswa){
        Mahasiswa update = mahasiswaService.update(mahasiswa);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        String delete = mahasiswaService.delete(id);
        return ResponseEntity.ok(delete);
    }
}
