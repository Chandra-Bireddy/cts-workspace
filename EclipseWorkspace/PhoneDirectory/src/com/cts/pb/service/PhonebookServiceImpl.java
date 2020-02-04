package com.cts.pb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.pb.dao.IPhonebookDAO;
import com.cts.pb.dao.PhonebookDAOCollectionImpl;
import com.cts.pb.exception.PhonebookException;
import com.cts.pb.model.Phonebook;

public class PhonebookServiceImpl implements IPhonebookService {
	public IPhonebookDAO phonebookDao;
	
	public IPhonebookDAO getDAO() {
		return phonebookDao;
	}
	
	public PhonebookServiceImpl() throws PhonebookException{
		phonebookDao = new PhonebookDAOCollectionImpl();
	}
	
	public boolean isValidPhoneNumber(String phoneNumber) {
		Pattern pnumberPattern = Pattern.compile("d{10}");
		Matcher pnumberMatcher = pnumberPattern.matcher(phoneNumber);
		return pnumberMatcher.matches();
	}
	
	public boolean isValidName(String name) {
		Pattern pnamePattern = Pattern.compile("[a-zA-Z]\\w{20}");
		Matcher pnameMatcher = pnamePattern.matcher(name);
		return pnameMatcher.matches();
	}
	
	public boolean isValidData(Phonebook data) throws PhonebookException{
		boolean isValid=false;
		
		List<String> errMsgs = new ArrayList<>();
		if(!isValidPhoneNumber(data.getPhoneNumber()))
			errMsgs.add("The phone number should only be of 10 digits");
		
		if(!isValidName(data.getName()))
			errMsgs.add("The name should contain less than 20 alphabets only");
		
		if(errMsgs.size()==0)
			isValid=true;
		else
			throw new PhonebookException(errMsgs.toString());
		return isValid;
	}

	@Override
	public String add(Phonebook phonebook) throws PhonebookException {
		String number=null;
		if(phonebook!=null && isValidData(phonebook)) {
			number=phonebookDao.add(phonebook);
		}
		return number;
	}

	@Override
	public boolean delete(String pno) throws PhonebookException {
		boolean isDone=false;
		if(pno!=null && isValidPhoneNumber(pno)) {
			phonebookDao.delete(pno);
			isDone=true;
		}else {
			throw new PhonebookException("phone number should only contain 10 digits");
		}
		return isDone;
	}

	@Override
	public Phonebook get(String pno) throws PhonebookException {
		 return phonebookDao.get(pno);
	}

	@Override
	public List<Phonebook> getAll() throws PhonebookException {
		// TODO Auto-generated method stub
		return phonebookDao.getAll();
	}

	@Override
	public boolean update(Phonebook phonebook) throws PhonebookException {
		
		boolean isDone= false;
		if(phonebook!=null && isValidData(phonebook)) {
			isDone=phonebookDao.update(phonebook);
		}
		return isDone;
	}
}
