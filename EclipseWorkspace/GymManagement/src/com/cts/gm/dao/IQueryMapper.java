package com.cts.gm.dao;

public interface IQueryMapper {

	public static final String ADD_MEMBER_QRY = 
			"INSERT INTO gym_members(member_id,  name, fees, joining_date) VALUES(?,?,?,?)";
	public static final String MODIFY_MEMBER_QRY = 
			"UPDATE gym_members SET title=?,price=?,pdate=? WHERE bcode=?";
	public static final String DEL_MEMBER_QRY = 
			"DELETE FROM gym_members WHERE member_id=?";
	public static final String GET_ALL_MEMBERS_QRY = 
			"SELECT * FROM gym_members";
	public static final String GET_MEMBER_QRY = 
			"SELECT * FROM gym_members WHERE member_id=?";
}