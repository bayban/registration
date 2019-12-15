<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- ADD VALIDATE CLASS --%>
function isNumber() { 
	$("#registrationForm").addClass("was-validated");
} 

<%-- DATEPICKER --%>
$(document).ready(function() {
	$('#dob').datepicker({ format : "dd-mm-yyyy", autoclose : true, endDate:new Date() }) 
});

<%-- GREY OUT --%>
<c:if test="${!empty registerProcess and registerProcess == 'SUCCESS'}">	
function greyOut(){   
	  console.log('MASUK TEST 1');
	  document.getElementById('mobile').setAttribute("disabled","disabled");
	  document.getElementById('firstNameUser').setAttribute("disabled","disabled");
	  document.getElementById('lastNameUser').setAttribute("disabled","disabled");
	  document.getElementById('dateOf').setAttribute("disabled","disabled");
	  document.getElementById('radioMale').setAttribute("disabled","disabled");
	  document.getElementById('radioFemale').setAttribute("disabled","disabled");
	  document.getElementById('emailUser').setAttribute("disabled","disabled");
	  document.getElementById('regist').setAttribute("disabled","disabled");
	   
	   $('#registrationForm').children().prop("disabled", "disabled");	   
	   $('#registrationForm').addClass("grey-out");
}

window.onload = greyOut;	   
</c:if>

