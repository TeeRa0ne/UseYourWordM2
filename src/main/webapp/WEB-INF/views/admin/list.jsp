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
	<t:base title="UYW - Admin">
		<div class="container flex-middle">
			<h1>Use Your Words - Admin</h1>
      <a href="/admin/add"><button style="margin-bottom: 20px" class="btn-success">Ajouter</button></a>
        <table class="table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>Type</th>
              <th>Url</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${medias}" var="media">
            <tr>
					    <td>${ media.id }</td>
					    <td>${ media.media }</td>
					    <td>${ media.url }</td>
              <td>
                <a href="/admin/edit?id=${ media.id }"><button class="btn-secondary">Editer</button></a>
                <a href="/admin/delete?id=${ media.id }"><button class="btn-danger">Supprimer</button></a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
	  </div>
	</t:base>
</body>
</html>