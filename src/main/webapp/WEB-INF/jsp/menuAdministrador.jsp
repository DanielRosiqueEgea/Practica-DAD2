<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENU ADMINISTRADOR</title>
</head>
<body>
MENU DEL ADMINISTRADOR

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRAÑADIRUSUARIO">
Añadir un usuario nuevo: <input type="submit" value="Añadir">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRELIMINARUSUARIO">
Eliminar un usuario:<input type="submit" value="Eliminar">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRMOSTRARUSUARIO">
Mostrar los usuarios existentes:<input type="submit" value="Mostrar">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRUPDATEUSUARIO">
Actualizar un usuario existente:<input type="text" name="NAME" value="alejandro" > <input type="submit" value="Actualizar">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRMENUPRODUCTO">
Ir a gestion de productos: <input type="submit" value="Acceder">
</form>




Mensaje: <% out.println(request.getSession().getAttribute("MENSAJE")); %>
</body>
</html>