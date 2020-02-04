package com.cts.gm.dao;

//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;

public class GymMembersDAOImpl implements IGymMembersDAO {
	
	private Map<String, GymMembers> member;
	
	public GymMembersDAOImpl() {
		member = new TreeMap<>();
	}
	
	@Override
	public String add(GymMembers members) throws GymMembersException {
		String mId = null;
		if (members != null) {
			mId = members.getMId();
			member.put(mId, members);	
		}
		return mId;
	}
	
	@Override
	public boolean delete(String mId) throws GymMembersException {
		boolean isDone = false;
		if (mId != null) {
			member.remove(mId);
			isDone = true;
		}
		return isDone;
	}
	
	@Override
	public GymMembers get(String mId) throws GymMembersException {
		return member.get(mId);
	}
	

	@Override
	public List<GymMembers> getAll() throws GymMembersException {
		return new ArrayList<>(member.values());
	}
	
	@Override
	public boolean update(GymMembers members) throws GymMembersException {
		boolean isDone = false;
		if (members != null) {
			String mId = members.getMId();
			member.replace(mId, members);
			
		}
		return isDone;
	}

	@Override
	public void persist() throws GymMembersException {
		
	}
	
	
}