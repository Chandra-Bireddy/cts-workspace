package com.cts.gm.dao;

import java.util.List;

import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;

public interface IGymMembersDAO {
	String add(GymMembers member) throws GymMembersException;
	boolean delete(String mId)throws GymMembersException;
	GymMembers get(String mId) throws GymMembersException;;
	List<GymMembers> getAll() throws GymMembersException;
	boolean update(GymMembers member) throws GymMembersException;
	void persist() throws GymMembersException;
}
