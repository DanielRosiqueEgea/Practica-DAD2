package edu.ucam.acciones.accionesProducto;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.acciones.Accion;
import edu.ucam.pojos.Producto;
/**
 * Clase que permite realizar la actualizacion o modificacion de un producto
 * @author Alejandro
 *
 */
public class AccionUpdateProducto extends Accion{
/**
 * Metodo que se encargará de realizar la modificacion
 * @return ruta de la jsp "menuProductos"
 */
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre= (String)request.getParameter("NAME");
		float precio= Float.parseFloat(request.getParameter("PRICE"));
		Producto producto= new Producto(nombre,precio);
		
		Hashtable<String, Producto> productos= (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		if (productos.containsKey(producto.getNombre())) {
			productos.replace(producto.getNombre(), producto);
			
			
			System.out.println(producto.getNombre()+" "+producto.getPrecio());
			request.getSession().setAttribute("MENSAJE", "Producto actualizado"); 
		}else {
			request.getSession().setAttribute("MENSAJE", "Producto no existente"); 
		}
		
		return "menuProductos.jsp";
	}

}
