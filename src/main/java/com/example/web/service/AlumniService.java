package com.example.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.web.shared.dto.AlumniDto;

public interface AlumniService extends UserDetailsService{

	AlumniDto createUser(AlumniDto alumni);
	AlumniDto getUser(String email);
}
