package com.example.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.web.shared.dto.AlumniDto;

public interface AlumniService extends UserDetailsService{

	AlumniDto createAlumni(AlumniDto alumni);
	AlumniDto getAlumni(String email);
	AlumniDto getAlumniByUserId(String userId);
}
