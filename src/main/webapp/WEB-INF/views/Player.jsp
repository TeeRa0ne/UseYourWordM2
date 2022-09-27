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
	<t:base title="UYW - Choisir les joueurs">
		<div class="container row flex-edges">
			<div class="sm-6 col">
				<h3>Use Your Words</h3>
			</div>
			<div class="sm-6 col">
				<a href="/use_your_words/" class="paper-btn margin">Retour</a>
			</div>
		</div>
		<div class="row flex-center">
			<form method="POST" class="form-group row">
        <div class="col sm-8">
        <p>Les joueurs : $"{playerList}"</p>
          <div class="form-group">
            <label for="paperInputs3">Entrée les joueurs</label>
            <input class="input-block" type="text" id="paperInputs3">
          </div>
        </div>
        <div>
				  <button class="btn-block border border-4 border-primary">Envoyer</button>
        </div>
			</form>
		</div>
	</t:base>
</body>
</html>