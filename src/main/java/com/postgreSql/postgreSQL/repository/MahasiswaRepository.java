package com.postgreSql.postgreSQL.repository;

import com.postgreSql.postgreSQL.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String> {
}
