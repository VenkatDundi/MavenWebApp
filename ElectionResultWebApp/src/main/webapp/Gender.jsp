<%@ page import="com.venkat.web.model.Election"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Count by Gender Page</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>

body {background-color: #958270;}

html, body {margin: 0; height: 100%; overflow: hidden}

.custom{

	margin-left: auto;
    margin-right: auto;
	margni-top:2%;
	border: 2px solid #4b3832;
	max-width: 40%;
	text-align: center;

}


.customtable{

	margin-top:5%;
	margin-bottom:5%;
	max-width: 25%;
	text-align: center;
	border: 1px solid;
	margin-left: auto;
    margin-right: auto;

}

.cells{

	border: 0.5px solid;

}

</style>

</head>

<body>

	<%
			
			ArrayList<ArrayList<String>> rc = (ArrayList<ArrayList<String>>)session.getAttribute("candidate_gender");
		
	%>
	
	<h3 class="ui header" style="text-align:center;color:#20283E;margin-top:10%">
	  Candidate Count By Gender, Election Deposit Eligibility
	</h3>
	
	<form style="margin-left:85%;" action="index.jsp">
		<button class="ui icon button">
		  <i class="home icon"></i>
		</button>
	</form>

	<div class="ui container center aligned" style="margin-bottom:2%;margin-top:2%;"> 
	
	<div class="custom">
	<form action="">
		
		<table class="customtable">
				<tr class="cells">
					<th>Gender</th><th></th>
					<th>ElectionDeposit</th><th></th>
					<th>Candidates</th><th></th>
				</tr>
				<% for (int i=0;i<rc.size(); i++){
				%>
				<tr class="cells">
					<% for(int j=0;j<rc.get(i).size();j++){ %>
						<td><% out.println(rc.get(i).get(j));%></td><td></td>
					<% } %>
				</tr>
				<% } %>
		</table>
		
	</form>
	</div>
	</div>
		
</body>
</html>




