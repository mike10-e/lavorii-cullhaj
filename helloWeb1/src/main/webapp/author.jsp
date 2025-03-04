<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>Autore</title>
</head>
<body>
<h2>Informazioni sull'autore</h2>
<ul>
    <li>Nome: Mikele</li>
    <li>Cognome: Cullhaj</li>
    <li>Classe: 5BI</li>
    <li>Data di oggi: 
        <%
            LocalDate data = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            out.print(data.format(formatter));
        %>
    </li>
</ul>
</body>
</html>
