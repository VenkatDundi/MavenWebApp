<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Count by Gender Page</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>

body {background-color: #fffdd0;margin:10%;}

.custom{

	margin-left: 30%;
	margni-top:2%;
	border: 2px solid #4b3832;
	max-width: 40%;
	text-align: center;

}

</style>

</head>

<body>

	<div class="ui container center aligned" style="margin-bottom:2%"> 
	<h2 class="ui gold header" style="margin-top: 2%;"> Candidate Details by Name </h2>
	</div>
	
	<div align="center" class="custom">	
	<form action="getCandidate" style="margin-top:5%;margin-bottom:5%;">
		<div class="ui input focus">
		  <input type="text" placeholder="Search with Name.." name="candidate">
		</div>
		<button class="ui button" style="margin-left:5%;" type="submit">Submit</button>
	</form>
	</div>
		
</body>
</html>