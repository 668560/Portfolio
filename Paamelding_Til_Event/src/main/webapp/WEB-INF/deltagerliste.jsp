<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
   
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
	<p>Innlogget som: ${innloggetBruker.mobil} / ${innloggetBruker.fornavn }
		${innloggetBruker.etternavn }</p>
	<h2>Deltagerliste</h2>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>


		<tbody>
			<c:forEach items="${deltagere}" var="deltager">
				<c:choose>
					<c:when test="${innloggetBruker.mobil == deltager.mobil }">
						<tr style="background-color: #aaffaa">

							<c:choose>
								<c:when test="${deltager.kjonn == 'mann'}">
									<td>&#x2642;</td>
								</c:when>
								<c:otherwise>
									<td>&#x2640;</td>
								</c:otherwise>
							</c:choose>


							<td>${deltager.fornavn} ${deltager.etternavn}</td>
							<td>${deltager.mobil}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>


							<c:choose>
								<c:when test="${deltager.kjonn == 'mann'}">
									<td>&#x2642;</td>
								</c:when>
								<c:otherwise>
									<td>&#x2640;</td>
								</c:otherwise>
							</c:choose>


							<td>${deltager.fornavn}${deltager.etternavn}</td>
							<td>${deltager.mobil}</td>
						</tr>


					</c:otherwise>
				</c:choose>
			</c:forEach>


		</tbody>




	</table>
	<br>
	<form action="utlogging" method="post">
		<button type="submit">Logg ut</button>
	</form>
</body>
</html>