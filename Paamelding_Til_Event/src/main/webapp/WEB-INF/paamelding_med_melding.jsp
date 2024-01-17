<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




    <html>
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/myscript.js" defer></script>  -->
	<title>Påmelding</title>
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
	<h2>Påmelding</h2>
	<p style="color:red;">${feilmeldinger}</p>
	
	<p style="color:red;">${feil}</p>
	<form  method="post">
		<fieldset>

			<label>Fornavn</label>
			<input type="text" id="fornavn" name="fornavn" placeholder="obligatorisk" pattern="^[A-ZÆØÅ][a-zæøå]+$"  value="${deltager.fornavn}" required/>

			<label>Etternavn</label>
			<input type="text" name="etternavn" id="etternavn" placeholder="obligatorisk" pattern="^[A-ZÆØÅ][a-zæøå]+$" value="${deltager.etternavn}" required/>

			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" id="mobil" placeholder="obligatorisk"  minlength="8" maxlength="8" value="${deltager.mobil}" required/>

			<label>Passord</label>
			<input type="password" id="passord" minlength="4" name= "hash" required/>
			<label>Passord repetert</label>
			<input type="password" id="passordRepetert" minlength="4" required name="salt" />

			<label>Kjønn</label>
			<input type="radio" name="kjonn"  value="mann" checked="checked" />mann
			<input type="radio" name="kjonn" value="kvinne" />kvinne

			<br><br><button type="submit">Meld meg på</button>
		</fieldset>
	</form>
</body>
</html>
