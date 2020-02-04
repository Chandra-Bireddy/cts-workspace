package com.cts.pb.service;

import java.util.List;

import com.cts.pb.exception.PhonebookException;
import com.cts.pb.model.Phonebook;

public interface IPhonebookService {
	public String add(Phonebook phonebook) throws PhonebookException;
	public boolean delete(String pno) throws PhonebookException;
	public Phonebook get(String pno) throws PhonebookException;
	public List<Phonebook> getAll() throws PhonebookException;
	public boolean update(Phonebook phonebook) throws PhonebookException;
}
