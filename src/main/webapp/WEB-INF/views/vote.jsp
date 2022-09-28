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
				<img src="https://unsplash.it/600" />
			</div>
            <div style="padding-top:5px">
			    <c:forEach var="rep" items="${ reponse }">
                    <div class="card" style="width: 20rem;margin-bottom:15px">
                        <div class="card-body">
                            <span class="card-text">${ rep.reponse }</span>

                            <c:if test="${ vote != true }">
								<div style="padding-top:15px">
									<a href="addVote?id=${ rep.id }">
										<button>Voter pour lui !</button>
									</a>
								</div>
							</c:if>
                        </div>
                    </div>
			    </c:forEach>
            </div>
		</div>
	</t:base>
</body>
</html>