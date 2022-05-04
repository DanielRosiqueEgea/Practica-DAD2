<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="AÑADIRPRODUCTO">
Nombre:  <input type="text" name="NAME" value="tomate" >
Precio= <input type="number" name="PRICE" value="1.20">
<input type="submit" value="Añadir producto">
</form>

</body>
</html>