package com.egr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egr.entity.PhoneNumbers;


@Repository
public interface IPhoneNumberRepo extends JpaRepository<PhoneNumbers, Long> 
{
	
}
