<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACTUALIZAR USUARIOS</title>
</head>
<body>
ACTUALIZACION DE USUARIOS

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="UPDATEUSUARIO">
Nombre:  <input type="text" name="NEWNAME" value="nuevo" >
Contraseña: <input type="text" name="NEWPASS" value="nuevo">
<input type="submit" value="Actualizar usuario">
</form>
</body>
</html>