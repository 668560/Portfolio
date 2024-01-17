<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>



</head>


<body>

<style>

input:invalid {
  background-color: #ffdddd;
}
/*form:invalid { border: 5px solid #ffdddd }*/

input:valid {
  background-color: #ddffdd;
}
/* form:valid { border: 5px solid #ddffdd; }*/
input:required {
  border-color: #800000;
  border-width: 3px;
}


</style>
	<h2>Logg inn</h2>
	
	<c:if test="${error_message != null}">

   		 <p style="color: red">${error_message}</p>
    
	</c:if>
	
	<form method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" minlength="8" maxlength="8" required />
			<label for="passord">Passord:</label> <input type="password" name="passord" required />
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>


<a href="start">Opprett ny konto</a>
</body>
</html>