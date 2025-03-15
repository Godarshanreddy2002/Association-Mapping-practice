package com.egr.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egr.entity.Person;
import com.egr.entity.PhoneNumbers;
import com.egr.repository.IPersonRepo;
import com.egr.repository.IPhoneNumberRepo;

@Service("OToMMapping")
public class OToMAssosiationMappingImpl implements IOToMAssosiationMapping
{
	@Autowired
	private IPersonRepo person;
	
	@Autowired
	private IPhoneNumberRepo contact;
	
	@Override
	public void saveDataUsingParent()
	{
		Person per =new Person();
		per.setName("Godarshan");
		per.setAddress("kuppam");
		
		PhoneNumbers ph1=new PhoneNumbers();
		ph1.setPhnoNumber(6305917434L);
		
		ph1.setProvider("Jio");
		ph1.setPersonInfo(per);
		
		
		PhoneNumbers ph2=new PhoneNumbers();
		
		ph2.setPhnoNumber(7305907464L);
		
		ph2.setProvider("Jio");
		ph2.setPersonInfo(per);
		
		Set<PhoneNumbers> phno=new HashSet();
		phno.add(ph2);
		phno.add(ph1);
		
		per.setContacts(phno);
		
		person.save(per);
		
	}

	@Override
	public void saveDataUsingChild()
	{
		
		
		Person per=new Person();
		
		per.setName("reddy");
		per.setAddress("Sakala kuppam");
		
		
		PhoneNumbers ph1 = new PhoneNumbers();
		
		ph1.setPhnoNumber(9181492046L);
		ph1.setProvider("idea");
		
				
		PhoneNumbers ph2 = new PhoneNumbers();
		ph2.setPhnoNumber(9101092089L);
		ph2.setProvider("VI");
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		Set<PhoneNumbers> phno=new HashSet<>();
		phno.add(ph1);
		phno.add(ph2);
		per.setContacts(phno);		
		
		contact.save(ph1);
		contact.save(ph2);
		System.out.println("Pesssion and his assosiated detials are stored from chiled class");
		
		
		
		
	}

	@Override
	public void loadDataUsingParent() 
	{
		Iterable<Person> it=person.findAll();
		it.forEach(per->{System.out.println("Parent"+per.toString());
		
		Set<PhoneNumbers> childs=per.getContacts();
		
		System.out.println("Childs count"+childs.size());
		
		childs.forEach(child->{
			System.out.println("Child phone number"+child.getPhnoNumber());
		});
		
		});
		
	}
	
	

}
