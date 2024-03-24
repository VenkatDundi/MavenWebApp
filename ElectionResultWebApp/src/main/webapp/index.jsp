<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"> 
    <head> 
        <meta charset="UTF-8"> 
        <title> Election Result Analysis </title> 
        
        <link type="text/css" rel="stylesheet" href="css/owl.carousel.css" /> 
        <link type="text/css" rel="stylesheet" href="css/owl.theme.default.css" /> 
 
        <!-- Custom stlylesheet --> 
        <link type="text/css" rel="stylesheet" href="css/style.css" /> 
        <link rel="stylesheet" href="css/styles.css"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css"> 

		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
		<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.js"></script> 
        
    </head> 
    
    <body style="background-color: #e6e6fa;"> 
     
        <div style="margin-top: 5%;"> 
            <div class="ui grey segment" style="width: 60%;margin: 0 auto;text-align: justify;"> 
                <h2 class="ui green header" style="text-align:center;">Welcome to LokSabha Election Results Analysis Application </h2>
            </div> 
        </div> 
        
        <div style="margin-top: 4%;margin-bottom: 2%;">  
                <h2 class="ui brown header" style="text-align:center;"> User Menu </h2>
        </div>
        
        <div class="ui secondary segment" style="width: 45%;margin: 0 auto;text-align: justify;">
        <div class="ui three column centered grid" style="margin-top:3px; margin-bottom:3px"> 
		    <form class="ui form" action="getGenderResult" style="margin-top:2%;margin-bottom:2%">
		  		<button class="ui secondary button" type="submit">Gender Count   </button>
			</form>
			<form class="ui form" action="./CandidateDetails.jsp" style="margin-top:2%;margin-bottom:2%">
		  		<button class="ui secondary button" type="submit">Candidate Details</button>
			</form>
		</div>
		<div class="ui three column centered grid" style="margin-top: 3px; margin-bottom:3px"> 
		    <form class="ui form" action="./WinnerDetails.jsp" style="margin-top:2%;margin-bottom:2%">
		  		<button class="ui secondary button" type="submit">Winner Details</button>
			</form>
		    <form class="ui form" action="./ContestantDetails.jsp" style="margin-top:2%;margin-bottom:2%">
		  		<button class="ui secondary button" type="submit">Contestant Details</button>
			</form>
		</div>
		</div>
		
		<div class="ui blue message" style="width: 60%;margin: 0 auto;text-align: justify;margin-top:2%">
		  <div class="header">
		    Note
		  </div>
		  <p>Election Years: 1977, 1980, 1984, 1989, 1991, 1996, 1998, 1999, 2004, 2009, 2014</p>
		</div>
		
    </body> 
</html>
