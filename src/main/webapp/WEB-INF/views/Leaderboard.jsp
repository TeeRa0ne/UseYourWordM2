<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<t:base title="UYW - En jeu">
		<div class="container">
			<div class="col">
				<h3>Use Your Words</h3>
			</div>
			<div class="col text-center">
				<h1>${winner} gagne ! 🎉</h1>
			</div>

			<a href="/" class="paper-btn margin">
				Retour
			</a>
		</div>
	</t:base>
</body>
</html>