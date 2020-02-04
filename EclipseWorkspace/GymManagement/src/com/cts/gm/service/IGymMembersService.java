package com.cts.gm.service;

import java.util.List;

import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;

public interface IGymMembersService {
	String add(GymMembers member) throws GymMembersException;
	boolean delete(String mId)throws GymMembersException;
	GymMembers get(String mId) throws GymMembersException;;
	List<GymMembers> getAll() throws GymMembersException;
	boolean update(GymMembers member) throws GymMembersException;
	public void persist() throws GymMembersException;
}
