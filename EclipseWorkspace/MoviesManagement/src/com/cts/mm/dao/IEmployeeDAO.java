package com.cts.mm.dao;

import java.util.List;

import com.cts.mm.exception.MovieException;
import com.cts.mm.model.Employee;

public interface IEmployeeDAO {
	String add(Employee movie) throws MovieException;
	boolean remove(String movieId) throws MovieException;
	Employee get(String movieId) throws MovieException;
	List<Employee> getAll() throws MovieException;
	boolean update(Employee movie) throws MovieException;
	public void persist() throws MovieException;
}
