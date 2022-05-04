package edu.ucam.acciones.accionesUsuario;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.acciones.Accion;
import edu.ucam.pojos.Usuario;

public class AccionUpdateUsuario extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newParamName= (String) request.getParameter("NEWNAME");
		String newParamPass = (String) request.getParameter("NEWPASS");
		
		Usuario nuevo= new Usuario(newParamName,newParamPass,"");
		
		@SuppressWarnings("unchecked")
		Hashtable<String, Usuario> usuarios= (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		String oldname= (String)request.getServletContext().getAttribute("NAMEMOD");
		//System.out.println(oldname);
		System.out.println("NAMEMOD:"+request.getServletContext().getAttribute("NAMEMOD"));
		if (oldname!=null) {
			if (usuarios.containsKey(oldname)) {
				usuarios.remove(oldname);
				usuarios.put(nuevo.getNombre(), nuevo);
				request.getSession().setAttribute("MENSAJE", "Usuario modificado"); 
		
				
			}
		}else {
			request.getSession().setAttribute("MENSAJE", "Usuario no existente");
			
		}
		return "menuAdministrador.jsp";
		
	}

}
