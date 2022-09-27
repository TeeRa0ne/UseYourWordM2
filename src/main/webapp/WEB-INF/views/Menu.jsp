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
	<t:base title="UYW - Menu">
		<div class="container flex-middle">
			<h1>Use Your Words</h1>
			<div class="row">
				<div class="col-4 col">
					<a href="/game">
						<button class="btn-block">Jouer</button>
					</a>
				</div>
				<div class="col-4 col">
					<div class="row flex-spaces child-borders">
						<button class="btn-block">Règles</button>
					</div>
					<input class="modal-state" id="modal-1" type="checkbox">
					<div class="modal">
						<label class="modal-bg" for="modal-1"></label>
						<div class="modal-body">
							<label class="btn-close" for="modal-1">X</label>
							<h4 class="modal-title">Règles du jeux</h4>
							<p class="modal-text">Le jeu se déroule sous cette forme :</p>
							<ol>
								<li>Vous devez utilisé vos propres mots pour décrire ce que
									vous voyez.</li>
								<li>Voté pour la meilleur explications d'un médias.</li>
							</ol>
							<label class="paper-btn" for="modal-1">Compris !</label>
						</div>
					</div>
				</div>
				<div class="col-4 col">
					<button class="btn-block">Paramètres</button>
				</div>
			</div>
		</div>
	</t:base>
</body>
</html>