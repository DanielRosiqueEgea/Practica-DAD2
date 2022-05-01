<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELIMINAR PRODUCTOS</title>
</head>
<body>
ELIMINAR PRODUCTO

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="ELIMINARPRODUCTO">
Nombre:  <input type="text" name="NAME" >
<br>
<input type="submit" value="Eliminar">
</form>
</body>
</html>