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
		<div class="row flex-center col-3 flex-wrap flex-column">
			<div>
				<p>Les joueurs : </p>
				<ul class="playerList">
					<c:forEach items="${players}" var="player">
						<li>${player.username}</li>
					</c:forEach>
				</ul>
				<div class="formulaire">
					<c:if test="${error != null}">
						<p style="color: red; font-weight:bold">${error}</p>
					</c:if>
					<div class="form-group row">
						<label for="username">Entre ton pseudo : </label>
						<input class="input-block" type="text" id="username" name="name">
					</div>
					<button style="margin-top: 20px" class="btn-block border border-4 border-primary addUserButton" type="submit">Ajouter</button>
				</div>
			</div>
			<div class="col">
				<button style="margin-top: 20px" class="btn-block border border-4 border-primary startGame">Lancer la partie</button>
			</div>
			<div>
				<h3 class="text-center">Code session : ${gameId}</h3>
			</div>
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
		<script  src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>


		<script>
			'use strict';

			var socket = new SockJS('/ws');
			var stompClient = Stomp.over(socket);
			var gameId = "${gameId}";

			function connect() {          

				stompClient.connect({}, onConnected, onError);
			}
			connect();

			function onConnected() {
				stompClient.subscribe('/topic/player/' + gameId, onMessageReceived);
			}

			function onError(error) {
				alert('Could not connect to WebSocket server. Please refresh this page to try again!');
			}

			$(".addUserButton").click(function() {
				var username = $("#username").val();
				stompClient.send("/app/player/addUser", {}, JSON.stringify({ 'content': username, 'sender' : gameId, 'type' : 'MESSAGE' }));
				$('.formulaire').remove();
			});

			$(".startGame").click(function() {
				stompClient.send("/app/player/startGame", {}, JSON.stringify({ 'content': 'startGame', 'sender' : gameId, 'type' : 'ACTION' }));
			});

			function onMessageReceived(payload) {
				var message = JSON.parse(payload.body);
				if (message.type === 'MESSAGE') {
					$('.playerList').append('<li>' + message.content + '</li>');
				} else if (message.type === 'ACTION') {
					if (message.content === 'startGame') {
						window.location.href = "/game?shortcode=" + gameId;
					}
				}
			}			
      </script>
	</t:base>
</body>
</html>