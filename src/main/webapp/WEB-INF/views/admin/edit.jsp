<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="${ media == null ? 'Ajouter' : 'Editer' }">
	<form method="POST">
		<div class="container"
    style="
    width: 300px;
    display: flex;
    flex-direction: column;
    margin-top: 50px;
    ">
        <label for="type">Type</label>
				<input type="text" name="type" value="${ media.media }" placeholder="Type : (IMAGE, VIDEO, TEXTE)" />
        <div style="height: 30px"></div>
        <label for="url">Url</label>
        <input type="text" name="url" value="${ media.url }" placeholder="Url" />
        <div style="height: 30px"></div>
        <input class="paper-btn btn-success" type="submit" value="Valider" />
		</div>
	</form>
</t:base>