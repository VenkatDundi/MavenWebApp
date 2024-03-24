<%@ page import="com.venkat.web.model.Election"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
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
    <body>
    	
    	<%
			
			ArrayList<ArrayList<String>> rc = (ArrayList<ArrayList<String>>)session.getAttribute("candidate_gender");
		
		%> 
     
        <div style="margin-top: 2%;"> 
            <div class="ui segment" style="width: 40%;margin: 0 auto;text-align: justify;"> 
                <h2 class="ui green header">Welcome to Election Results Analysis Application </h2>
            </div> 
        </div> 
        
        <div style="margin-top: 2%;margin-bottom:2%;">  
                <h2 class="ui blue header" style="text-align:center;"> Candidate Count By Gender, Election Deposit Eligibility </h2>
        </div>
     
		<form style="margin-left:85%;margin-bottom:2%;" action="index.jsp">
			<button class="ui icon button">
			  <i class="home icon"></i>
			</button>
		</form>
        
		<div class="ui padded segment" style="width: 80%;margin: 0 auto;text-align:justify;"> 
                <table class="ui yellow celled table"> 
                    <thead> 
                          <tr> 
                              	<th>Gender</th>
								<th>ElectionDeposit</th>
								<th>Candidates</th>
                          </tr> 
                    </thead> 
					<tbody> 
					
					<% for (int i=0;i<rc.size(); i++){
					%>
					<tr>
						<% for(int j=0;j<rc.get(i).size();j++){ %>
							<td><% out.println(rc.get(i).get(j));%></td>
						<% } %>
					</tr>
					<% } %>
					
                       </tbody> 
                 </table> 
        </div> 
    </body> 
</html>







