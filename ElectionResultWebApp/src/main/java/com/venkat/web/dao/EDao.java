package com.venkat.web.dao;

import com.venkat.web.model.Election;


public interface EDao {
	
	Election fetchGenderCount();
	Election fetchCandidateDetails(String Candidate);
	Election fetchWinnerDetails(int Year, String State, String Constituency);
	Election fetchContestantDetails(int Year, String State, String PartyAbbr);

}
