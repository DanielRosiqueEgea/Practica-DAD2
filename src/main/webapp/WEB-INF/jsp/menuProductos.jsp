<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENU DE PRODUCTOS</title>
</head>
<body>
MENU GESTION DE PRODUCTOS

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRAÑADIRPRODUCTO">
Añadir un nuevo producto:<input type="submit" value="Añadir">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRELIMINARPRODUCTO">
Eliminar un producto:<input type="submit" value="Eliminar">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRUPDATEPRODUCTO">
Actualizar los productos existentes:<input type="submit" value="Actualizar">
</form>

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="IRMOSTRARPRODUCTO">
Mostrar los productos existentes:<input type="submit" value="Mostrar">
</form>

Mensaje: <% out.println(request.getSession().getAttribute("MENSAJE")); %>
</body>
</html>