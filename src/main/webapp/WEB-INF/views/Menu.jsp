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
			<h1 class="animate__animated pulse animate__repeat-infinite">Use
				Your Words</h1>
			<div class="row">
				<div class="col-6 col">
					<a href="/use_your_words/game">
						<button class="btn-block">Jouer</button>
					</a>
				</div>
				<div class="col-6 col">
					<button class="btn-block">Paramètres</button>
				</div>
			</div>
		</div>
	</t:base>
</body>
</html>