<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELIMINAR USUARIO</title>
</head>
<body>
ELIMINAR USUARIO

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="ELIMINARUSUARIO">
Nickname:  <input type="text" name="NICKNAME" required>
Contraseña: <input type="text" name="PASS" required>
<br>
<input type="submit" value="Eliminar">
</form>
</body>
</html>