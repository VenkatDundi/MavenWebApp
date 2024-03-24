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

	@Override
	public Election fetchWinnerDetails(int Year, String State, String Constituency) {

		Election e = new Election();
		
		String sp_winner = "CREATE PROCEDURE get_winner_details(\r\n"
				+ "\r\n"
				+ "	@year int,\r\n"
				+ "	@state nvarchar(50),\r\n"
				+ "	@pc_name nvarchar(50)\r\n"
				+ ")\r\n"
				+ "as\r\n"
				+ "with cte_win as(\r\n"
				+ "\r\n"
				+ "	select Year, State, PC_Name, Candidate, Party, VotePoll as VotesPolled, \r\n"
				+ "	(VotePoll-lead(VotePoll) over (partition by Year, PC_Name order by VotePoll desc)) as Margin, \r\n"
				+ "	rank() over(partition by Year, PC_Name order by VotePoll desc) as r from NationalElection\r\n"
				+ "	where state=@state and year=@year and PC_Name=@pc_name\r\n"
				+ ")\r\n"
				+ "select Year, State, PC_Name, Candidate, Party, VotesPolled, Margin from cte_win where r=1;";
		
		String sp_call = "{call get_winner_details(?,?,?)}";
		
		try {
			
			Class.forName(s);
			Connection con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();
			CallableStatement cs = con.prepareCall(sp_call);
			
			st.execute(sp_winner);
			
			cs.setInt(1, Year);
			cs.setString(2, State);
			cs.setString(3, Constituency);
			
			ResultSet rs = cs.executeQuery();
			
			/*rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();*/
			
			ArrayList<ArrayList<String>> rc = new ArrayList<ArrayList<String>>();
			
			while(rs.next()) {
				
				ArrayList<String> recordlist = new ArrayList<String>();
				
				int Y = rs.getInt("Year");
				String S = rs.getString("State");
				String PC_Name = rs.getString("PC_Name");
				String Candidate = rs.getString("Candidate");
				String Party = rs.getString("Party");
				int VotePoll = rs.getInt("VotesPolled");
				int Margin = rs.getInt("Margin");
				
				recordlist.add(Integer.toString(Y));
				recordlist.add(S);
				recordlist.add(PC_Name);
				recordlist.add(Candidate);
				recordlist.add(Party);
				recordlist.add(Integer.toString(VotePoll));
				recordlist.add(Integer.toString(Margin));
				
				rc.add(recordlist);
			
				e.setWinner(rc);	
				
			}
			
			//System.out.println(rc);
			
			rs.close();
			cs.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		return e;
		
	}

	@Override
	public Election fetchContestantDetails(int Year, String State, String PartyAbbr) {

		Election e = new Election();
		
		String sp_contestant = "create procedure get_Party_Contestants(\r\n"
				+ "\r\n"
				+ "	@partyabbr nvarchar(50),\r\n"
				+ "	@year int,\r\n"
				+ "	@state nvarchar(50)\r\n"
				+ ")\r\n"
				+ "as\r\n"
				+ "select Year,State,PC_Name,Candidate, Gender, Party, VotePoll, TotalVotesPolled, VoteShare, Result from NationalElection where Year=@year and PartyAbbr=@partyabbr and State=@state order by Year,State,Candidate,Result desc;";
		
		String sp_call = "{call get_Party_Contestants(?,?,?)}";
		
		try {
			
			Class.forName(s);
			Connection con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();
			//ResultSet rs1 = st.executeQuery("drop procedure IF EXISTS get_Party_Contestants;");
			st.execute(sp_contestant);
			CallableStatement cs = con.prepareCall(sp_call);

			cs.setString(1, PartyAbbr);
			cs.setInt(2, Year);
			cs.setString(3, State);
			
			
			ResultSet rs = cs.executeQuery();
			
			/*rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();*/
			
			ArrayList<ArrayList<String>> rc = new ArrayList<ArrayList<String>>();
			
			while(rs.next()) {
				
				ArrayList<String> recordlist = new ArrayList<String>();
				
				int Y = rs.getInt("Year");
				String S = rs.getString("State");
				String PC_Name = rs.getString("PC_Name");
				String Candidate = rs.getString("Candidate");
				String Gender = rs.getString("Gender");
				String Party = rs.getString("Party");
				int VotePoll = rs.getInt("VotePoll");
				int TotalVotesPolled = rs.getInt("TotalVotesPolled");
				float VoteShare = rs.getFloat("VoteShare");
				String Result = rs.getString("Result");
				
				
				recordlist.add(Integer.toString(Y));
				recordlist.add(S);
				recordlist.add(PC_Name);
				recordlist.add(Candidate);
				recordlist.add(Gender);
				recordlist.add(Party);
				recordlist.add(Integer.toString(VotePoll));
				recordlist.add(Integer.toString(TotalVotesPolled));
				recordlist.add(Float.toString(VoteShare));
				recordlist.add(Result);
				
				
				rc.add(recordlist);
			
				e.setContestant(rc);	
				
			}
			
			//System.out.println(rc);
			
			rs.close();
			cs.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		return e;
		
	}

}
