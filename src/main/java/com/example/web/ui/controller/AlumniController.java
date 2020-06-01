package com.example.web.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.service.AlumniService;
import com.example.web.shared.dto.AlumniDto;
import com.example.web.ui.model.request.AlumniDetailsRequestModel;
import com.example.web.ui.model.response.AlumniRest;

@RestController
@RequestMapping("alumnus") // http://localhost:8080/alumnus
public class AlumniController {
	
	@Autowired
	AlumniService alumniService;
	 
	@GetMapping(path = "/{id}")
	public AlumniRest getAlumni(@PathVariable String id) {
		AlumniRest returnValue = new AlumniRest();
		
		AlumniDto alumniDto = alumniService.getAlumniByUserId(id);
		BeanUtils.copyProperties(alumniDto, returnValue);
		
		return returnValue;
	}
	
	@PostMapping 
	public AlumniRest createAlumni(@RequestBody AlumniDetailsRequestModel alumniDetails) {
		AlumniRest returnValue = new AlumniRest();
		
		AlumniDto alumniDto = new AlumniDto();
		BeanUtils.copyProperties(alumniDetails, alumniDto);
		
		AlumniDto createAlumni = alumniService.createAlumni(alumniDto);
		BeanUtils.copyProperties(createAlumni, returnValue);
		
		return returnValue;
	}
	
	@PutMapping 
	public String updateAlumni() {
		return "update alumni was called";
	}
	
	@DeleteMapping 
	public String deleteAlumni() {
		return "delete alumni was called";
	}
}
