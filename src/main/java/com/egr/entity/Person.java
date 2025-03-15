package com.egr.entity;

import java.io.Serializable;
import java.util.Set;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;




@Entity
public class Person 
{
	@Id
	@GeneratedValue
	private Long personId;
	
	@NonNull
	@Column(length = 20)
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String address;
	
	
	@OneToMany(targetEntity = PhoneNumbers.class, fetch = FetchType.LAZY, mappedBy = "personInfo",cascade = CascadeType.ALL)
	private Set<PhoneNumbers> contacts;


	public Person()
	{
		System.out.println("0 - arg constuctor");
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", address=" + address + ", contacts=" + contacts
				+ "]";
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<PhoneNumbers> getContacts() {
		return contacts;
	}

	public void setContacts(Set<PhoneNumbers> contacts) {
		this.contacts = contacts;
	}
	
	
	
}
