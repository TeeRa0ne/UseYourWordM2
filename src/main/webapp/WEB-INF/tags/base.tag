<%@ tag pageEncoding="ISO-8859-1"%>

<%@ attribute name="title"%>

<!DOCTYPE html>
<html>
<head>
<title>${ title }</title>
<link rel="stylesheet"
	href="https://unpkg.com/papercss@1.8.3/dist/paper.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/css/style.css">
<body>
	<!-- doBody insi�re le contenu d�fini dans l'utilisation du tag -->
	<jsp:doBody />
</body>
</html>