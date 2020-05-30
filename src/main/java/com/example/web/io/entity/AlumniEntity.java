package com.example.web.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "alumnus") // name of the DB table
public class AlumniEntity implements Serializable {

	private static final long serialVersionUID = -8643852385886850961L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 20)
	private String alumni_id;

	@Column(nullable = false, length = 50)
	private String department;

	@Column(nullable = false, length = 10)
	private String batch_no;

	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(nullable = false, length = 100)
	private String university_email;

	@Column(nullable = false, length = 15)
	private String contact_no;

	@Column(nullable = false, length = 20)
	private String current_country;

	@Column(nullable = false, length = 50)
	private String currently_studying;

	@Column(nullable = false, length = 100)
	private String current_job_organization;

	@Column(nullable = false, length = 50)
	private String current_job_position;

	@Column(nullable = false)
	private String encryptedPassword;

	private String emailVerificationToken;

	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlumni_id() {
		return alumni_id;
	}

	public void setAlumni_id(String alumni_id) {
		this.alumni_id = alumni_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity_email() {
		return university_email;
	}

	public void setUniversity_email(String university_email) {
		this.university_email = university_email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getCurrent_country() {
		return current_country;
	}

	public void setCurrent_country(String current_country) {
		this.current_country = current_country;
	}

	public String getCurrently_studying() {
		return currently_studying;
	}

	public void setCurrently_studying(String currently_studying) {
		this.currently_studying = currently_studying;
	}

	public String getCurrent_job_organization() {
		return current_job_organization;
	}

	public void setCurrent_job_organization(String current_job_organization) {
		this.current_job_organization = current_job_organization;
	}

	public String getCurrent_job_position() {
		return current_job_position;
	}

	public void setCurrent_job_position(String current_job_position) {
		this.current_job_position = current_job_position;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
}
