	package com.venkat.web.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Election {
	
	 private String State;	 private int Year;
	 private String Constituency;
	 private String CType;
	 private String Candidate;
	 private String Gender;
	 private String Party;
	 private String PartyAbbr;
	 private int VotePolled;
	 private int Electors;
	 private int TotalVotes;
	 private float VoteShare;
	 private String DepositStatus;	 private String Result;
	 private ArrayList<ArrayList<String>> counter;
	 private ArrayList<ArrayList<String>> x;
	 private ArrayList<ArrayList<String>> w;
	 private ArrayList<ArrayList<String>> c;
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getConstituency() {
		return Constituency;
	}
	public void setConstituency(String constituency) {
		Constituency = constituency;
	}
	public String getCType() {
		return CType;
	}
	public void setCType(String cType) {
		CType = cType;
	}
	public String getCandidate() {
		return Candidate;
	}
	public void setCandidate(String candidate) {
		Candidate = candidate;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getParty() {
		return Party;
	}
	public void setParty(String party) {
		Party = party;
	}
	public String getPartyAbbr() {
		return PartyAbbr;
	}
	public void setPartyAbbr(String partyAbbr) {
		PartyAbbr = partyAbbr;
	}
	public int getVotePolled() {
		return VotePolled;
	}
	public void setVotePolled(int votePolled) {
		VotePolled = votePolled;
	}
	public int getElectors() {
		return Electors;
	}
	public void setElectors(int electors) {
		Electors = electors;
	}
	public int getTotalVotes() {
		return TotalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		TotalVotes = totalVotes;
	}
	public float getVoteShare() {
		return VoteShare;
	}
	public void setVoteShare(float voteShare) {
		VoteShare = voteShare;
	}
	public String getDepositStatus() {
		return DepositStatus;
	}
	public void setDepositStatus(String depositStatus) {
		DepositStatus = depositStatus;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	
	/* Set,Get methods for count of contestants in all terms of elections */
	
	public ArrayList<ArrayList<String>> getCount() {
		
		return counter;
		
	}
	
	public void setCount(ArrayList<ArrayList<String>> rows) {
			
			counter = rows;
			
		}
	
	
	public void setDetails(ArrayList<ArrayList<String>> rc) {
		
		x = rc;
		
	}
	
	public ArrayList<ArrayList<String>> getDetails() {
		
		return x;
	}
	
	
	public void setWinner(ArrayList<ArrayList<String>> wins) {
		w = wins;
	}
	
	public ArrayList<ArrayList<String>> getWinner() {
		return w;
	}
	
	public void setContestant(ArrayList<ArrayList<String>> cons) {
		c = cons;
	}
	
	public ArrayList<ArrayList<String>> getContestant() {
		return c;
	}
	
		
	@Override
	public String toString() {
		return "Election [State=" + State + ", Year=" + Year + ", Constituency=" + Constituency + ", CType=" + CType
				+ ", Candidate=" + Candidate + ", Gender=" + Gender + ", Party=" + Party + ", PartyAbbr=" + PartyAbbr
				+ ", VotePolled=" + VotePolled + ", Electors=" + Electors + ", TotalVotes=" + TotalVotes
				+ ", VoteShare=" + VoteShare + ", DepositStatus=" + DepositStatus + ", Result=" + Result + "]";
	}
}
