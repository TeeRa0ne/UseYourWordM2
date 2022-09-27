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
			<h3>Use Your Words</h3>
		</div>
		<div class="row flex-center">
			<div class="col-6 col">
				<img src="https://unsplash.it/600" />
			</div>
			<div class="form-group col-4 col">
				<label for="large-input">Votre réponse :</label>
				<textarea style="margin-bottom: 20px" class="border border-5 border-primary" id="large-input" rows="4" cols="50" placeholder="Décrire l'image..."></textarea>
				<button class="btn-block border border-4 border-primary">Envoyer</button>
			</div>
		</div>
	</t:base>
</body>
</html>