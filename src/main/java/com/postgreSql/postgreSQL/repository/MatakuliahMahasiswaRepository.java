package com.postgreSql.postgreSQL.repository;

import com.postgreSql.postgreSQL.entity.MatkulMahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatakuliahMahasiswaRepository extends JpaRepository<MatkulMahasiswa, Long> {
}
