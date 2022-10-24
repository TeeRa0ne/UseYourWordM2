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
				<div class="col-7 col">
					<a href="/players">
						<button class="btn-block">Jouer</button>
					</a>
				</div>
				<div class="col-3 col">
					<div class="row">
						<label class="paper-btn" for="modal-1">Règles</label>
					</div>
					<input class="modal-state" id="modal-1" type="checkbox">
					<div class="modal">
						<label class="modal-bg" for="modal-1"></label>
						<div class="modal-body">
							<label class="btn-close" for="modal-1">X</label>
							<h4 class="modal-title">Informations pour le joueur !</h4>
							<h5 class="modal-subtitle">Voici les règles</h5>
							<div class="">
								<p class="modal-text">
								Jeu à 6 joueurs maximum, qui propose plusieurs manches aux joueurs :
								<ol>
									<li>
										Video
									</li>
									<li>
										Texte
									</li>
									<li>
										Image
									</li>
								</ol>
								Chaque manche utilise au hasard, parmi une liste disponible, une vidéo, une image, ou un texte à trou.
								Chaque joueur doit compléter la manche avec des mots qu’il va proposer. Un temps limité de 60
								secondes est défini.
								Chaque joueur vote ensuite pour sa proposition préférée. Il ne peut pas voter pour lui-même.
								Le joueur avec le plus de points gagne la partie.</p>
							</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</t:base>
</body>
</html>