package com.egr.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.egr.service.IOToMAssosiationMapping;

@Component
public class OToMAssosiationMappingRunner implements CommandLineRunner
{
	@Autowired
	private IOToMAssosiationMapping service;

	@Override
	public void run(String... args) throws Exception
	{
//		service.saveDataUsingParent();
//		service.saveDataUsingChild();
//		service.loadDataUsingParent();		
//		service.loadDataUsingChild();
		
//		System.out.println(service.deleteByPerson(52L));
//		System.out.println(service.deleteALlPhoneNumbersOfAPeron(152L));
		service.addNewChildToParentById(152L);
		
		
	}
	
}
