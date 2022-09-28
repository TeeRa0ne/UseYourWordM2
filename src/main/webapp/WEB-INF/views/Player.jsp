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
				<a href="/" class="paper-btn margin">Retour</a>
			</div>
		</div>
		<div class="row flex-center">
			<form method="POST" class="form-group row">
        <div class="sm-8 col">
        <p>Les joueurs : </p>
				<ul class="inline">
					<c:forEach items="${players}" var="player">
						<li>${player.username}</li>
					</c:forEach>
				</ul>
          <div class="form-group row">
            <label for="paperInputs3">Entrée les noms des joueurs : </label>
            <input class="input-block" type="text" id="paperInputs3" name="name">
						<c:if test="${error}">
							<p style="color: red, font-weight:bold">${error}</p>
						</c:if>
					</div>
				    <button style="margin-top: 20px" class="btn-block border border-4 border-primary" type="submit">Ajouter</button>
          </div>
					<a href="/game">
					  <button style="margin-top: 20px" class="btn-block border border-4 border-primary">Lancer la partie</button>
					</a>
        </div>
			</form>
		</div>
	</t:base>
</body>
</html>