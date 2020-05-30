package com.example.web;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.web.io.entity.AlumniEntity;

@Repository
public interface AlumniRepository extends CrudRepository<AlumniEntity, Long> {
	AlumniEntity findByEmail(String email);
}
