package com.cts.gm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.gm.dao.GymMembersIOStreamDAO;
//import com.cts.gm.dao.GymMembersDAOImpl;
//import com.cts.gm.dao.GymMembersIOStreamDAO;
import com.cts.gm.dao.GymMembersJDBCImpl;
import com.cts.gm.dao.IGymMembersDAO;
import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;

public class GymMembersServiceImpl implements IGymMembersService {
	
	private IGymMembersDAO memberDao;

	public IGymMembersDAO getDAO(){
		return memberDao;
	}
	
	public GymMembersServiceImpl() throws GymMembersException {
		//memberDao = new GymMembersIOStreamDAO();
		memberDao = new GymMembersJDBCImpl();
		
	}
	
	public boolean isValidMId(String mId){
		
		/*
		 * First letter must be capital
		 * Followed by three digits
		 */
		Pattern mIdPattern = Pattern.compile("[A-Z]\\d{3}");
		Matcher mIdMatcher = mIdPattern.matcher(mId);
		
		return mIdMatcher.matches();
	}
	
	public boolean isValidName(String name){
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 20 chars.		
		 */
		Pattern namePattern = Pattern.compile("[A-Za-z]\\w{2,19}");
		Matcher nameMatcher = namePattern.matcher(name);
		
		return nameMatcher.matches();
	}
	
	public boolean isValidFees(double fees){
		/*
		 * Price is between 5 and 5000
		 */
		return fees>=500 && fees<=20000;
	}
	
	public boolean isValidJoiningDate(LocalDate joiningDate){
		/*
		 * publish date should not be greater than the current day.
		 */
		LocalDate today = LocalDate.now();
		//return publishDate.isBefore(today) || publishDate.equals(today);
		return today.isAfter(joiningDate) || joiningDate.equals(today);
	}
	
	public boolean isValidMember(GymMembers member) throws GymMembersException{
		boolean isValid=false;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(!isValidMId(member.getMId()))
			errMsgs.add("Member Id should start with a capital alphabet followed by 3 digits");
		
		if(!isValidName(member.getName()))
			errMsgs.add("Name must start with capital and must be in between 4 to 20 chars in length");
		
		if(!isValidFees(member.getFees()))
			errMsgs.add("Fees must be between INR.5 and INR.5000");
		
		if(!isValidJoiningDate(member.getJoiningDate()))
			errMsgs.add("Publish Date should not be a future date");
		
		if(errMsgs.size()==0)
			isValid=true;
		else
			throw new GymMembersException(errMsgs.toString());
		
		return isValid;
	}


	@Override
	public String add(GymMembers member) throws GymMembersException {
		String mId=null;
		if(member!=null && isValidMember(member)){
			mId=memberDao.add(member);
		}
		return mId;
	}

	@Override
	public boolean delete(String mId) throws GymMembersException {
		boolean isDone=false;
		if(mId!=null && isValidMId(mId)){
			memberDao.delete(mId);
			isDone = true;
		}else{
			throw new GymMembersException("mId should be a capital letter followed by 3 digits");
		}
		return isDone;
	}

	@Override
	public GymMembers get(String mId) throws GymMembersException {
		return memberDao.get(mId);
	}

	@Override
	public List<GymMembers> getAll() throws GymMembersException {
		return memberDao.getAll();
	}

	@Override
	public boolean update(GymMembers member) throws GymMembersException {
		boolean isDone = false;
		
		if(member!=null && isValidMember(member)){
			isDone = memberDao.update(member);
		}
		
		return isDone;
	}


	@Override
	public void persist() throws GymMembersException {
		memberDao.persist();
	}
}