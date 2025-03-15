package com.egr.entity;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;


@Entity

public class PhoneNumbers 
{
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "reg_seq",initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Long regId;
	
	@NonNull
	@Column(length = 20)
	private Long phnoNumber;
	
	
	@NonNull
	@Column(length = 20)
	private String provider;
	
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private Person personInfo;

	public PhoneNumbers() {
		super();
		System.out.println("0- arg constuctor of Phone numbers");
	}

	@Override
	public String toString() {
		return "PhoneNumbers [regId=" + regId + ", phnoNumber=" + phnoNumber + ", provider=" + provider
				+ ", personInfo=" + personInfo + "]";
	}

	public Long getRegId() {
		return regId;
	}

	public Long getPhnoNumber() {
		return phnoNumber;
	}

	public String getProvider() {
		return provider;
	}

	public Person getPersonInfo() {
		return personInfo;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public void setPhnoNumber(Long phnoNumber) {
		this.phnoNumber = phnoNumber;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setPersonInfo(Person personInfo) {
		this.personInfo = personInfo;
	}
	
	
	
}
