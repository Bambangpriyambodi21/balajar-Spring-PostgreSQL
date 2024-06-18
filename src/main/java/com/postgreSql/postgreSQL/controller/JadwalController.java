package com.postgreSql.postgreSQL.controller;

import com.postgreSql.postgreSQL.entity.Jadwal;
import com.postgreSql.postgreSQL.service.JadwalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/jadwal")
public class JadwalController {
    private final JadwalService jadwalService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Jadwal jadwal){
        Jadwal jadwal1 = jadwalService.create(jadwal);
        return ResponseEntity.ok(jadwal1);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Jadwal> all = jadwalService.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Jadwal jadwal){
        Jadwal update = jadwalService.update(jadwal);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id_jadwal}")
    public ResponseEntity<?> delete(@PathVariable Long id_jadwal){
        String delete = jadwalService.delete(id_jadwal);
        return ResponseEntity.ok(delete);
    }
}
