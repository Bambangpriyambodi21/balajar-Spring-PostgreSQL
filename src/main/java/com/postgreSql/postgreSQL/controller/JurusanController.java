package com.postgreSql.postgreSQL.controller;

import com.postgreSql.postgreSQL.entity.Jurusan;
import com.postgreSql.postgreSQL.service.JurusanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/jurusan")
public class JurusanController {
    private final JurusanService jurusanService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Jurusan jurusan){
        Jurusan creat = jurusanService.creat(jurusan);
        return ResponseEntity.ok(creat);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Jurusan> all = jurusanService.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Jurusan jurusan){
        Jurusan update = jurusanService.update(jurusan);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        String delete = jurusanService.delete(id);
        return ResponseEntity.ok(delete);
    }
}
