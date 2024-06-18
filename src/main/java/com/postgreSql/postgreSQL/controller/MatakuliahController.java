package com.postgreSql.postgreSQL.controller;

import com.postgreSql.postgreSQL.entity.Matakuliah;
import com.postgreSql.postgreSQL.service.MatakuliahService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/matakuliah")
@RequiredArgsConstructor
public class MatakuliahController {
    private final MatakuliahService matakuliahService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Matakuliah matakuliah){
        Matakuliah matakuliah1 = matakuliahService.create(matakuliah);
        return ResponseEntity.ok(matakuliah1);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Matakuliah> all = matakuliahService.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Matakuliah matakuliah){
        Matakuliah update = matakuliahService.update(matakuliah);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id_matkul}")
    public ResponseEntity<?> delete(@PathVariable String id_matkul){
        String delete = matakuliahService.delete(id_matkul);
        return ResponseEntity.ok(delete);
    }
}
