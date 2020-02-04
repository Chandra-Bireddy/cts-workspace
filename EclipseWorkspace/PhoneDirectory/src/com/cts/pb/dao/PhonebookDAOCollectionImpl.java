package com.cts.pb.dao;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.pb.exception.PhonebookException;
import com.cts.pb.model.Phonebook;

public class PhonebookDAOCollectionImpl implements IPhonebookDAO{
	
	Map<String, Phonebook> phonebook;
	
	public PhonebookDAOCollectionImpl() {
		phonebook = new TreeMap<>();
		
		
	}

	@Override
	public String add(Phonebook number) throws PhonebookException {
		String phoneNumber = null;
		if(number != null ) {
			phoneNumber = ((Phonebook) phonebook).getPhoneNumber();
			phonebook.put(phoneNumber, (Phonebook) phonebook);
		}
		return null;
	}

	@Override
	public boolean delete(String pno) throws PhonebookException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Phonebook get(String pno) throws PhonebookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phonebook> getAll() throws PhonebookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Phonebook phonebook) throws PhonebookException {
		// TODO Auto-generated method stub
		return false;
	}
}
