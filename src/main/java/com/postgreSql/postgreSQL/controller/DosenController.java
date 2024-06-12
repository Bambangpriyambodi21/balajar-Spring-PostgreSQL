package com.postgreSql.postgreSQL.controller;

import com.postgreSql.postgreSQL.entity.Dosen;
import com.postgreSql.postgreSQL.service.DosenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dosen")
@RequiredArgsConstructor
public class DosenController {
    private final DosenService dosenService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dosen dosen){
        Dosen dosen1 = dosenService.create(dosen);
        return ResponseEntity.status(HttpStatus.CREATED).body(dosen1);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Dosen dosen){
        Dosen dosen1 = dosenService.update(dosen);
        return ResponseEntity.status(HttpStatus.CREATED).body(dosen1);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Dosen> dosen1 = dosenService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(dosen1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        String dosen1 = dosenService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dosen1);
    }
}
