package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//optimizado import acciones
import edu.ucam.acciones.*;
import edu.ucam.acciones.accionesProducto.*;
import edu.ucam.acciones.accionesUsuario.*;
import edu.ucam.pojos.Producto;
import edu.ucam.pojos.Usuario;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Hashtable<String, Accion> acciones=null;
	 private Hashtable<String, Usuario> usuarios= null;
	 private Hashtable<String, Producto> productos=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	this.acciones= new Hashtable<String, Accion>();
    	this.usuarios= new Hashtable<String, Usuario>();
    	this.productos= new Hashtable<String, Producto>();
    	
    	this.acciones.put("IRLOGIN", new AccionIr("login.jsp"));
    	/**ACCIONES DE USUARIOS**/
    	this.acciones.put("AÑADIRUSUARIO", new AccionAñadirUsuario()) ;
    	this.acciones.put("ELIMINARUSUARIO", new AccionEliminarUsuario());
    	this.acciones.put("IRAÑADIRUSUARIO", new AccionIr("añadirUsuario.jsp"));
    	this.acciones.put("IRELIMINARUSUARIO", new AccionIr("eliminarUsuario.jsp"));
    	this.acciones.put("IRMOSTRARUSUARIO", new AccionIr("mostrarUsuario.jsp"));
    	this.acciones.put("IRUPDATEUSUARIO", new AccionIr("updateUsuario.jsp"));
    	this.acciones.put("UPDATEUSUARIO", new AccionUpdateUsuario());
    	
    	/**ACCIONES DE PRODUCTOS**/
    	this.acciones.put("IRAÑADIRPRODUCTO", new AccionIr("añadirProductos.jsp"));
    	this.acciones.put("AÑADIRPRODUCTO", new AccionAñadirProducto());
    	this.acciones.put("IRMENUPRODUCTO", new AccionIr("menuProductos.jsp"));
    	this.acciones.put("IRELIMINARPRODUCTO", new AccionIr("eliminarProducto.jsp"));
    	this.acciones.put("ELIMINARPRODUCTO", new AccionEliminarProducto());
    	this.acciones.put("IRUPDATEPRODUCTO", new AccionIr("actualizarProducto.jsp"));
    	this.acciones.put("UPDATEPRODUCTO", new AccionUpdateProducto());
    	
    	
    	Usuario temp = new Usuario("admin","admin","admin"); // 
		this.usuarios.put(temp.getPass(), temp); //SE USA LA CONTRASEÑA COMO CLAVE
		this.getServletContext().setAttribute("USUARIOS", this.usuarios);
		this.getServletContext().setAttribute("PRODUCTOS", this.productos);
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// Como vamos a hacerle foward a la request para dirirla a una jsp 
		String jsp="";
		
			
			String nombre= (String) request.getParameter("NAME");
			//este if es para que sea posible guardar el nombre del usuario antes de ser modificado, ya que 
			if (nombre!=null) {
				request.getServletContext().setAttribute("NAMEMOD", request.getParameter("NAME"));
			}
		
		
		String idaccion= (String) request.getParameter("IDACCION"); //variable para registrar la accion que se va a hacer
		
		Usuario usuario= (Usuario) request.getSession().getAttribute("USUARIO"); //objeto usuario con el valor del usuario que ha iniciado sesion
		
		
		if(usuario!=null) {
		
		Accion accion =this.acciones.get(idaccion);	
			
			if(accion!=null) {
				jsp= "/WEB-INF/jsp/" + accion.ejecutar(request, response);
			}
		}else {
			if("LOGIN".equals(idaccion)){
				AccionLogin accionlogin= new AccionLogin();
				
				jsp= "/WEB-INF/jsp/" + accionlogin.ejecutar(request, response);
			}else {
				jsp= "/WEB-INF/jsp/login.jsp";			}
		}
		
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
