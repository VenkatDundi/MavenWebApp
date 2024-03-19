package com.venkat.web.dao;

import java.sql.*;
import java.util.ArrayList;

import com.venkat.web.model.Election;

public class EDaoImpl implements EDao {
	
	
	public String s = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Election;integratedSecurity=true;encrypt=true;trustServerCertificate=true"; 
	
	public Election fetchGenderCount() {
		
		Election e = new Election();
		
		try {
			
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName(s);
			Connection con = DriverManager.getConnection(connectionUrl);
			PreparedStatement statement = con.prepareStatement("Select Gender, ElectionDepositEligibility, Count(Candidate) as 'Number of Candidates' \r\n"
					+ "from NationalElection\r\n"
					+ "GROUP BY Gender,ElectionDepositEligibility order by Count(Candidate) desc;");    
			//statement.setString(1, gender);    
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ArrayList<String>> row_collection = new ArrayList<ArrayList<String>>();
			
			while(rs.next()) {
				
				ArrayList<String> record = new ArrayList<String>();
				
				String Gender = rs.getString("Gender");
				String Deposit = rs.getString("ElectionDepositEligibility");
				int Candidates = rs.getInt("Number of Candidates");
				
				record.add(Gender);
				record.add(Deposit);
				record.add(Integer.toString(Candidates));
				
				row_collection.add(record);
				
				e.setCount(row_collection);
			}
			
			//System.out.println(row_collection);
			
			rs.close();
			statement.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		return e;
	}

	public Election fetchCandidateDetails(String Candidate_Name) {

		Election e = new Election();
		
		
		try {
			
			Class.forName(s);
			Connection con = DriverManager.getConnection(connectionUrl);
			PreparedStatement statement = con.prepareStatement("select Year, State, PC_Name, Candidate, Gender, Party, VotePoll, Result from NationalElection where Candidate= ?");    
			statement.setString(1, Candidate_Name);    
			ResultSet rs = statement.executeQuery();
			
			/*rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();*/
			
			ArrayList<ArrayList<String>> rc = new ArrayList<ArrayList<String>>();
			
			while(rs.next()) {
				
				ArrayList<String> recordlist = new ArrayList<String>();
				
				int Year = rs.getInt("Year");
				String State = rs.getString("State");
				String PC_Name = rs.getString("PC_Name");
				String Candidate = rs.getString("Candidate");
				String Gender = rs.getString("Gender");
				String Party = rs.getString("Party");
				int VotePoll = rs.getInt("VotePoll");
				String Result = rs.getString("Result");
				
				
				
				recordlist.add(Integer.toString(Year));
				recordlist.add(State);
				recordlist.add(PC_Name);
				recordlist.add(Candidate);
				recordlist.add(Gender);
				recordlist.add(Party);
				recordlist.add(Integer.toString(VotePoll));
				recordlist.add(Result);
				
				rc.add(recordlist);
			
				e.setDetails(rc);	
				
			}
			rs.close();
			statement.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		return e;

	}

}
