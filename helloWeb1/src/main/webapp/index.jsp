<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>
        Benvenuto Utente Curioso, questo e' la mia prima JSP. Oggi e' il giorno <%= LocalDate.now() %>
    </h2>
    <h2>Autore: <a href="author.jsp">link</a></h2>
</body>
</html>
