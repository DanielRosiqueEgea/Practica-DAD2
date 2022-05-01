<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACTUALIZAR PRODUCTO</title>
</head>
<body>
ACTUALIZACION PRODUCTOS

<form action="control" method="post">
<input type="hidden" name="IDACCION" value="UPDATEPRODUCTO">
Nombre:  <input type="text" name="NAME" value="tomate frito" >
Nuevo Precio= <input type="number" name="PRICE" value="2.30">
<input type="submit" value="Actualizar producto">
</form>

</body>
</html>