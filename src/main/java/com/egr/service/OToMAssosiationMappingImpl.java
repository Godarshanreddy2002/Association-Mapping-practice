package com.egr.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
		
		ph1.setPhnoNumber(9128455676L);
		ph1.setProvider("idea");
		
				
		PhoneNumbers ph2 = new PhoneNumbers();
		ph2.setPhnoNumber(9520459600L);
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

	@Override
	public void loadDataUsingChild() {
		
		List<PhoneNumbers> childs=contact.findAll();
		
		childs.forEach(ph->{
			System.out.println("child ------- "+ph);
			Person per=ph.getPersonInfo();
			System.out.println("Parent ------- "+per);
		});
				
	}

	@Override
	public String deleteByPerson(Long id) 
	{
		Optional<Person> per=person.findById(id);
		if(per.isPresent())
		{
			person.delete(per.get());
		
			return "Person deleted successfully";
		}
		
		return "Person is not found to delete";
	}

	@Override
	public String deleteALlPhoneNumbersOfAPeron(Long id) {
		
		
		Optional<Person> opt=person.findById(id);
		
		if(opt.isPresent())
		{
			Set<PhoneNumbers> childs=opt.get().getContacts();
			
			childs.forEach(ph->{
				ph.setPersonInfo(null);
			});
			
			contact.deleteAll(childs);
			
			return childs.size()+" Phone number are deleted "+id+" Person are deleted";	
			
		}
		return id+" Person not found";
	}

	@Override
	public void addNewChildToParentById(Long id) 
	{
		Optional<Person> opt=person.findById(id);
		
		if(opt.isPresent())
		{
			
			Person per=opt.get();			
			PhoneNumbers phn=new PhoneNumbers();
			
			phn.setProvider("jio");
			phn.setPhnoNumber(6305917434L);
			phn.setPersonInfo(per);			
			Set<PhoneNumbers> ph=per.getContacts();
			ph.add(phn);
			per.setContacts(ph);			
			person.save(per);			
			System.out.println("New child Object is added to the existing parent");
		}
		else {
			System.out.println(id+" not found");
		}		
	}

}
