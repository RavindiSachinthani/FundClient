<%@page import = "com.Fund"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/fund.js"></script>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-8">

 		<h1 class="m-3">Funder details L10</h1>

 		<form id="formFund" name="formFund">
 				Funder Code:
				<input id="FunderCode" name="FunderCode" type="text"
 							class="form-control form-control-sm">
				<br> Company Name:
				<input id="CompanyName" name="CompanyName" type="text"
 							class="form-control form-control-sm">
				<br> Contact No:
				<input id="ContactNo" name="ContactNo" type="text"
 							class="form-control form-control-sm">
				<br> Company Description:
				<input id="CompanyDesc" name="CompanyDesc" type="text"
 						class="form-control form-control-sm">
				
				<br>
				<input id="btnSave" name="btnSave" type="button" value="Save"
 							class="btn btn-primary">
				<input type="hidden" id="hidfIDSave" name="hidfIDSave" value="">
		</form>
			
			<div id="alertSuccess" class="alert alert-success"></div>
 			<div id="alertError" class="alert alert-danger">
 					
 			<br>
 			<div id="divFundGrid">
					<% 
 						Fund fundObj = new Fund();
 						out.print(fundObj.readFunds());
 					%>
 			</div>
					
		</div>
	</div>
</div>
</body>
</html>