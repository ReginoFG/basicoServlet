<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
<h1>Resultado operación seleccionada request: ${resultadoOperacion}</h1>
<h1>Resultado operación seleccionada session: ${resultadoOperacionS}</h1>
<h1>Resultado operación seleccionada context: ${resultadoOperacionC}</h1>
<br>
<br>
<%
String uno = request.getParameter("textUno");
String dos = request.getParameter("textDos");
int nUno = Integer.parseInt(uno);
int nDos = Integer.parseInt(dos);
out.print(nUno+nDos);
%>
<br>
<br>
<%=request.getAttribute("resultadoOperacion")%>
<%=request.getSession().getAttribute("resultadoOperacionS")%>
<%=getServletContext().getAttribute("resultadoOperacionC")%>
<br>
<br>
<a href="index.jsp">Volver al inicio.</a>
</body>
</html>