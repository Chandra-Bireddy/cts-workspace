package com.cts.gm.dao;

import java.util.ArrayList;

import java.util.List;

import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;
import com.cts.gm.util.ConnectionProvider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymMembersJDBCImpl implements IGymMembersDAO{
	
	ConnectionProvider conProvider;
	
	public GymMembersJDBCImpl() throws GymMembersException{
		try {
			conProvider = ConnectionProvider.getInstance();
		}catch(ClassNotFoundException | IOException exp) {
			throw new GymMembersException("Database not reachable");
		}
	}
	@Override
	public String add(GymMembers member) throws GymMembersException {
		String mId= null;
		if(member!= null) {
			try(Connection con = conProvider.getConnection();
				PreparedStatement pInsert = con.prepareStatement(IQueryMapper.ADD_MEMBER_QRY)){
					pInsert.setString(1, member.getMId());
					pInsert.setString(2, member.getName());
					pInsert.setDouble(3, member.getFees());
					pInsert.setDate(4, Date.valueOf(member.getJoiningDate()));

					int rowCount = pInsert.executeUpdate();

					if (rowCount == 1) {
						mId = member.getMId();
					}
				}
				catch (SQLException exp) {
					//log.error(exp);
					throw new GymMembersException("Member credentials not inserted");
				}
		}
		return mId;
	}

	@Override
	public boolean delete(String mId) throws GymMembersException {
		boolean isDone = false;

		try (Connection con = conProvider.getConnection();
				PreparedStatement pDelete = con
						.prepareStatement(IQueryMapper.DEL_MEMBER_QRY)) {

			pDelete.setString(1, mId);

			int rowCount = pDelete.executeUpdate();

			if (rowCount == 1) {
				isDone = true;
			}
		} catch (SQLException exp) {
			//log.error(exp);
			throw new GymMembersException("Member credential not found");
		}

		return isDone;
	}

	@Override
	public GymMembers get(String mId) throws GymMembersException {
		GymMembers member=null;
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_MEMBER_QRY)) {

			pSelect.setString(1, mId);

			ResultSet rs = pSelect.executeQuery();
			
			if(rs.next()){
				member = new GymMembers();
				member.setMId(rs.getString("member_id"));
				member.setName(rs.getString("name"));
				member.setFees(rs.getDouble("fees"));
				member.setJoiningDate(rs.getDate("joining_date").toLocalDate());
			}
			
		} catch (SQLException exp) {
			//log.error(exp);
			throw new GymMembersException("Member detail is not available");
		}		
		return member;
	}

	@Override
	public List<GymMembers> getAll() throws GymMembersException {
		
		List<GymMembers> members=null;
		
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_ALL_MEMBERS_QRY)) {

			ResultSet rs = pSelect.executeQuery();
			
			members = new ArrayList<GymMembers>();
			
			while(rs.next()){
				GymMembers member=new GymMembers();
				member.setMId(rs.getString("member_id"));
				member.setName(rs.getString("name"));
				member.setFees(rs.getDouble("fees"));
				member.setJoiningDate(rs.getDate("joining_date").toLocalDate());
				members.add(member);
			}
			
		} catch (SQLException exp) {
			//log.error(exp);
			throw new GymMembersException("No data available.");
		}		
		return members;
	}

	@Override
	public boolean update(GymMembers member) throws GymMembersException {
		// TODO Auto-generated method stub
		boolean isDone = false;
		if (member != null) {
			try (Connection con = conProvider.getConnection();
					PreparedStatement pUpdate = con
							.prepareStatement(IQueryMapper.MODIFY_MEMBER_QRY)) {

				
				pUpdate.setString(1, member.getName());
				pUpdate.setDouble(2, member.getFees());
				pUpdate.setDate(3, Date.valueOf(member.getJoiningDate()));
				pUpdate.setString(4, member.getMId());
				

				int rowCount = pUpdate.executeUpdate();

				if (rowCount == 1) {
					isDone = true;
				}
			} catch (SQLException exp) {
				//log.error(exp);
				throw new GymMembersException("Member details not updated.");
			}
		}
		return isDone;
	}

	@Override
	public void persist() throws GymMembersException {
		// TODO Auto-generated method stub
		
	}
}
