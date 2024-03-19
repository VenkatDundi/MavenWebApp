package com.venkat.web.dao;

import com.venkat.web.model.Election;


public interface EDao {
	
	Election fetchGenderCount();
	Election fetchCandidateDetails(String Candidate);
	

}
