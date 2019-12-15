<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Mitrais Registration Form</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no" />


<!-- <script src="https://code.jquery.com/jquery-3.4.1.js"
	type="text/javascript"></script> -->
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/16.0.8/js/intlTelInput.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/16.0.8/js/utils.js"
	type="text/javascript"></script> -->
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"
	type="text/javascript"></script> -->

<script src="./assets/js/jquery.js" type="text/javascript"></script>
<script src="./assets/js/bootstrap.js"></script>
<script src="./assets/dynamicJs/scriptsJS.jsp" type="text/javascript"></script>
<script src="./assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

<link href="./assets/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="./assets/css/style.css" rel="stylesheet" type="text/css" />
<link href="./assets/css/datepicker3.css" rel="stylesheet" />
<link href="./assets/css/datepicker3.css.map" rel="stylesheet" />
<link href="./assets/css/datepicker.css" rel="stylesheet" />
<!-- <link href="./assets/css/font-awesome.min.css" rel="stylesheet" /> -->
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/16.0.8/css/intlTelInput.css"> -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
	rel="stylesheet" />


</head>

<body>

	<div class="wrapper" id="pageOut">
		<!-- START Registration Container-->
		<div id="formContent">
			<form id="registrationForm" class="container" role="form"
				action="RegistrationAuthServlet" method="POST" role="form"
				data-toggle="validator">
				<!-- <div> -->
				<h1 class="semi-bold h1">Registration</h1>
				<!-- START Login Form -->
				<!-- START Form Control-->
				<c:if test="${!empty errorValidate}">
					<div class="form-group form-group-default">
						<div
							class="alert alert-danger alert-dismissible fade show controls">
							${errorValidate }
							<button type="button" class="close" data-dismiss="alert">&times;</button>
						</div>
					</div>
				</c:if>
				<div class="form-group form-group-default">
					<div class="controls">
						<input id="mobile" type="tel" name="mobileNumber"
							placeholder="Mobile Number"
							class="form-control is-valid  input-email-control"
							value="${mobileNumber}" autofocus="autofocus"
							pattern="^(^\+62\s?|^0)(\d{3,4}-?){2}\d{3,4}$"
							onclick="isNumber();" required>

						<div class="invalid-feedback">Please enter a valid
							indonesian mobile number in the required field.</div>
					</div>
				</div>
				<div class="form-group form-group-default">
					<div class="controls">
						<input type="text" name="firstName" placeholder="First Name"
							value="${firstName}" class="form-control" autofocus="autofocus" id="firstNameUser"
							required>
					</div>
				</div>
				<div class="form-group form-group-default">
					<div class="controls">
						<input type="text" name="lastName" placeholder="Last Name"
							value="${lastName}" class="form-control" autofocus="autofocus" id="lastNameUser"
							required>
					</div>
				</div>
				<div class="form-group form-group-default">
					<div id="dob" class="input-group date  form-date-control">
						<input type="text" id ="dateOf" name="dateOfBirth" placeholder="Date of Birth"
							value="${dob}" data-role="date" autofocus="autofocus"
							readonly="readonly" class="form-control input-margin-control">
						<span class="input-group-addon input-date-icon"><i
							class="fa fa-calendar"></i> </span>
					</div>
				</div>
				<div class="radio">
					<span> <input type="radio" value="male" name="gender"
						id="radioMale" ${gender == 'male'?'checked=\"checked\"' : ''}>
						<label for="radioMale">Male</label>
					</span> <span> <input type="radio" value="female" name="gender"
						id="radioFemale" ${gender == 'female'?'checked=\"checked\"' : ''}>
						<label class="radio" for="radioFemale">Female</label></span>

				</div>
				<div class="form-group form-group-default">
					<div class="controls">
						<input type="email" name="email" placeholder="email"
							value="${email}" id="emailUser"
							class="form-control is-valid  input-email-control"
							autofocus="autofocus" required>
						<div class="invalid-feedback">Please enter a valid email in
							the required field.</div>
					</div>
				</div>
				<div class="form-group form-group-default">
					<button class="btn btn-primary btn-cons m-t-10 col-xs-12 fourth"
						type="submit" id="regist">register</button>
				</div>
			</form>
			<c:if
				test="${!empty registerProcess and registerProcess == 'SUCCESS'}">
				<form class="container" role="form" action="LoginServlet"
					method="GET" role="form">
					<div class="form-group form-group-default">
						<button class="btn btn-primary btn-cons m-t-10 col-xs-12 fourth"
							type="submit">login</button>
					</div>
				</form>

			</c:if>

		</div>
	</div>





</body>
</html>
