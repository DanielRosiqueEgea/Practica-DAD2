package edu.ucam.acciones.accionesProducto;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.acciones.Accion;
import edu.ucam.pojos.Producto;
import edu.ucam.pojos.Usuario;
/**
 * Clase que permite añadir un producto a la tabla hash y que posteriormente sera volcado a la base de datos
 * @author Alejandro
 *
 */
public class AccionAñadirProducto extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre= (String)request.getParameter("NAME");
		float precio= Float.parseFloat(request.getParameter("PRICE"));
		Producto producto= new Producto(nombre,precio); //instancia de objeto de la clase producto
		
		Hashtable<String, Producto> productos= (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		//vamos a suponer que hay una unidad por producto, esto de momento es as, mas adelante se intentará tener en cuenta las unidades
		if (!productos.containsKey(producto.getNombre())) {
			productos.put(producto.getNombre(), producto);
			System.out.println(producto.getNombre()+" "+producto.getPrecio());
			request.getSession().setAttribute("MENSAJE", "Producto añadido"); 
		}else {
			request.getSession().setAttribute("MENSAJE", "Producto ya existente"); 
		}
		return "menuProductos.jsp";
	}

}
