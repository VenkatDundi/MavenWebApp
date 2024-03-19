<!DOCTYPE html>
<html>

<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>

body {background-color: powderblue;margin:10%;}

.custom{

	margin-left: 25%;
	border: 2px solid #1F1F1F;
	max-width: 50%;
	text-align: center;

}

</style>

</head>

<body style="text-align: center;">

	<div class="custom">

	<div class="ui container center aligned"> 
	<h2 class="ui green header" style="margin-top: 2%"> LokSabha Election Result Analysis </h2>   
	     
	</div>
	    
	<div class="ui two column centered grid" style="margin-top:3px; margin-bottom:3px"> 
	    <form class="ui form" action="getGenderResult" style="margin-top:2%;margin-bottom:2%">
	  		<button class="ui button" type="submit">Gender Count</button>
		</form>
		<form class="ui form" action="./CandidateDetails.jsp" style="margin-top:2%;margin-bottom:2%">
	  		<button class="ui button" type="submit">Candidate Details</button>
		</form>
	</div>
	
	<div class="ui two column centered grid" style="margin-top: 3px; margin-bottom:3px"> 
	    <form class="ui form" action="getGenderResult" style="margin-top:2%;margin-bottom:2%">
	  		<button class="ui button" type="submit">Gender Count</button>
		</form>
		<form class="ui form" action="./CandidateDetails.jsp" style="margin-top:2%;margin-bottom:2%">
	  		<button class="ui button" type="submit">Candidate Details</button>
		</form>
	</div>
	
	</div>
	<!-- <form action="getGenderResult">
		<input type="text" name="gender">
		<input type="submit">
	</form>
	
	<form action="getCandidate">
		<input type="text" name="candidate">
		<input type="submit">
	</form>-->
</body>
</html>
