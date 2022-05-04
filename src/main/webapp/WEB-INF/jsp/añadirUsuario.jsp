<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AÑADIR USUARIO</title>
</head>
<body>
AÑADIR USUARIO

<form action="control" method="post">

<input type="hidden" name="IDACCION" value="AÑADIRUSUARIO">
Nombre:  <input type="text" name="NAME" value="alejandro" required>
Apellido:  <input type="text" name="SURNAME" value="alejandro" required>
Nickname:  <input type="text" name="NICKNAME" value="alejandro">
Contraseña: <input type="text" name="PASS" value="alejandro" required>
<input type="submit" value="Añadir">
</form>
</body>
</html>