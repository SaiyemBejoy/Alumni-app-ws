package com.example.web.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.web.io.entity.AlumniEntity;
import com.example.web.io.repositories.AlumniRepository;
import com.example.web.service.AlumniService;
import com.example.web.shared.Utils;
import com.example.web.shared.dto.AlumniDto;

@Service
public class AlumniServiceImpl implements AlumniService {

	@Autowired
	AlumniRepository alumniRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AlumniDto createAlumni(AlumniDto alumni) {
		if (alumniRepository.findByEmail(alumni.getEmail()) != null)
			throw new RuntimeException("Record already exists!");

		AlumniEntity alumniEntity = new AlumniEntity();
		BeanUtils.copyProperties(alumni, alumniEntity);

		String publicUserId = utils.generateUserId(30);
		
		alumniEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(alumni.getPassword()));
		alumniEntity.setUserId(publicUserId);

		AlumniEntity storedAlumniDetails = alumniRepository.save(alumniEntity);

		AlumniDto returnValue = new AlumniDto();
		BeanUtils.copyProperties(storedAlumniDetails, returnValue);

		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AlumniEntity alumniEntity = alumniRepository.findByEmail(email);
		
		if(alumniEntity == null) throw new UsernameNotFoundException(email);
		
		return new User(alumniEntity.getEmail(), alumniEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public AlumniDto getAlumni(String email) {
		AlumniEntity alumniEntity = alumniRepository.findByEmail(email);
		
		if(alumniEntity == null) throw new UsernameNotFoundException(email);
		
		AlumniDto returnValue = new AlumniDto();
		BeanUtils.copyProperties(alumniEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public AlumniDto getAlumniByUserId(String userId) {
		AlumniDto returnValue = new AlumniDto();
		AlumniEntity alumniEntity = alumniRepository.findByUserId(userId);
		
		if(alumniEntity == null) throw new UsernameNotFoundException(userId);
		
		BeanUtils.copyProperties(alumniEntity, returnValue);
		
		return returnValue;
	}

}
