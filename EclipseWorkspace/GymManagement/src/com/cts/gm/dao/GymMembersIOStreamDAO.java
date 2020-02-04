package com.cts.gm.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;

public class GymMembersIOStreamDAO implements IGymMembersDAO {
	public static final String DATA_STORE_FILE_NAME = "members.dat";
	private Map<String, GymMembers> member;
	
	@SuppressWarnings("unchecked")
	public GymMembersIOStreamDAO() throws GymMembersException{
		
		File file = new File(DATA_STORE_FILE_NAME);

		if (!file.exists()) {
			member = new TreeMap<>();
		} else {
			try (ObjectInputStream fin = new ObjectInputStream(
					new FileInputStream(DATA_STORE_FILE_NAME))) {

				Object obj = fin.readObject();

				if (obj instanceof Map) {
					member = (Map<String, GymMembers>) obj;
				} else {
					throw new GymMembersException("Not a valid DataStore");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new GymMembersException("Loading Data Failed");
			}
		}
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
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(member);
		} catch (IOException exp) {
			throw new GymMembersException("Saving Data Failed");
		}
	}
	
	
}