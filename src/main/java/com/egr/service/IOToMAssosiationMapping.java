package com.egr.service;



public interface IOToMAssosiationMapping
{
	public void saveDataUsingParent();
	
	
	public void saveDataUsingChild();
	
	public void loadDataUsingParent();
	
	public void loadDataUsingChild();
	
	public String deleteByPerson(Long id);
	
	

}
