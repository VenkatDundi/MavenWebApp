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
    <body> 
     
        <div style="margin-top: 2%;"> 
            <div class="ui segment" style="width: 40%;margin: 0 auto;text-align: justify;"> 
                <h2 class="ui green header">Welcome to Election Results Analysis Application </h2>
            </div> 
        </div> 
        
        <div style="margin-top: 2%;">  
                <h2 class="ui black header" style="text-align:center;"> Participant Details </h2>
        </div>
         
        <form name="passcandidatedetails" action="getCandidate" style="margin-top: 2%;margin-bottom: 2%;"> 
             
            <div class="ui yellow padded segment" style="width: 50%;margin: 0 auto;text-align: justify;"> 

                <table class="ui basic table"> 
                    <tr> 
                      <td> 
                        <div class="ui labeled input"> 
                          <div class="ui label"> 
                            Enter Candidate Name 
                          </div>
                          <input type="text" placeholder="Search with Name.." name="candidate" required> 
                        </div> 
                      </td>
                      <td></td>
                      <td> <button class="medium ui orange button">Submit</button> </td>
                    </tr> 
                </table> 
            </div> 
        </form>      
    </body> 
</html>