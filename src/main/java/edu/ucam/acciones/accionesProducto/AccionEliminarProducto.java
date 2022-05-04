package edu.ucam.acciones.accionesProducto;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.acciones.Accion;
import edu.ucam.pojos.Producto;
/**
 * Clase que permite eliminar un producto de la tabla hash de productos y posteriormente de la base de datos
 * @author Alejandro
 *
 */
public class AccionEliminarProducto extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre= (String) request.getParameter("NAME");
		//float precio= Float.parseFloat(request.getParameter("PRICE"));
		//Producto producto= new Producto(nombre,precio);
		
		Hashtable<String, Producto> productos= (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		//si la tabla hash contiene el producto cuyos atributos hasn sido pasados por parametro, se elimina de la tabla hash
		if (productos.containsKey(nombre)) {
			productos.remove(nombre);
			request.getSession().setAttribute("MENSAJE", "Producto eliminado"); 
		}else {
			request.getSession().setAttribute("MENSAJE", "Producto no existente"); 
		}
		return "menuProductos.jsp";
		}
		
	}


