<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A�ADIR USUARIO</title>
</head>
<body>
A�ADIR USUARIO

<form action="control" method="post">

<input type="hidden" name="IDACCION" value="A�ADIRUSUARIO">
Nombre:  <input type="text" name="NAME" value="alejandro" required>
Apellido:  <input type="text" name="SURNAME" value="alejandro" required>
Nickname:  <input type="text" name="NICKNAME" value="alejandro">
Contrase�a: <input type="text" name="PASS" value="alejandro" required>
<input type="submit" value="A�adir">
</form>
</body>
</html>