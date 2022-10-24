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
		<div class="container row flex-edges">
			<div class="sm-6 col">
				<h3>Use Your Words</h3>
			</div>
			<div class="sm-6 col">
				<a href="/" class="paper-btn margin">Retour</a>
			</div>
		</div>
		<div class="row flex-center">
			<div class="col-6 col fixed-scroll">
				<c:if test="${media.media == 'IMAGE'}">
					<img src="${media.url}" />
				</c:if>
				<c:if test="${media.media == 'VIDEO'}">
					<iframe width="560" height="315" src="${media.url}" class="border border-4 border-primary" title="Rick Roll" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>	
				</c:if>
				<c:if test="${media.media == 'TEXTE'}">
					<div class="border border-4 border-primary">
						<p>${media.url}</p>
					</div>
				</c:if>
			</div>
            <div style="padding-top:5px">
			    <c:forEach var="rep" items="${ reponse }">
                    <div class="card" style="width: 20rem;margin-bottom:15px">
                        <div class="card-body">
                            <span class="card-text">${ rep.reponse }</span>
							<div style="padding-top:15px">
								<a href="addVote?id=${ rep.id }&shortcode=${shortcode}&media=${tour}">
									<button>Voter pour lui !</button>
								</a>
							</div>
                        </div>
                    </div>
			    </c:forEach>
            </div>
		</div>
	</t:base>
</body>
</html>