<%@ tag pageEncoding="ISO-8859-1"%>

<%@ attribute name="title"%>

<!DOCTYPE html>
<html>
<head>
<title>${ title }</title>
  <link rel="stylesheet" href="https://unpkg.com/papercss@1.8.3/dist/paper.min.css">
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<body>
	<!-- doBody insière le contenu défini dans l'utilisation du tag -->
	<jsp:doBody />
</body>
</html>