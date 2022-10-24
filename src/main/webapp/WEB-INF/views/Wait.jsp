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
				<h1>En attente des joueurs ...</h1>
			</div>
			<button style="margin-top: 20px" class="btn-block border border-4 border-primary nextBtn" type="submit">Etape suivante</button>
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
				stompClient.subscribe('/topic/wait/' + gameId, onMessageReceived);
			}

			function onError(error) {
				alert('Could not connect to WebSocket server. Please refresh this page to try again!');
			}

			$(".nextBtn").click(function() {
				stompClient.send("/app/wait/waitPlayer", {}, JSON.stringify({ 'type' : 'ACTION', 'sender' : gameId}));
			});

			function onMessageReceived(payload) {
				var message = JSON.parse(payload.body);
				if (message.type === 'ACTION') {
					//get action url parameter
					var url = new URL(window.location.href);
					var action = url.searchParams.get("action");
					if (action === "vote") {
						window.location.href = "/vote?shortcode=" + gameId + "&media=0";
					} else {
						window.location.href = "/leaderboard?shortcode=" + gameId;
					}
				}
			}			
      </script>
	</t:base>
</body>
</html>