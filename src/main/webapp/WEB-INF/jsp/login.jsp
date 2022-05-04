<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAGINA DE LOGIN</title>
</head>
<body>
PAGINA LOGIN
<form action="control" method="post">
<input type="hidden" name="IDACCION" value="LOGIN">
Nickname: <input type="text" name="NICKNAME" value="admin" required>
Contraseña:  <input type="text" name="PASS" value="admin" required>
 <input type="submit" value="Aceptar">
</form>
<p style="color:red">POR FAVOR USE EL NICKNAME GENERADO PARA INICIAR SESION </p>
</body>
</html>