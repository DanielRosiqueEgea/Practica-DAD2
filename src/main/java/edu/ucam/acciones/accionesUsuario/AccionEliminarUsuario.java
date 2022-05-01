package edu.ucam.acciones.accionesUsuario;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.acciones.Accion;
import edu.ucam.pojos.Usuario;
/**
 * Clase que permite la eliminacion de un usuario por parte del administrador
 * @author Alejandro
 *
 */
public class AccionEliminarUsuario extends Accion {

	/**
	 * Metodo para eliminar un usuario de la tabla hash de usuarios
	 * @return ruta al menu del administrador
	 */
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nickname= (String) request.getParameter("NICKNAME");
		String contraseña = (String) request.getParameter("PASS");
		
		
		@SuppressWarnings("unchecked")
		Hashtable<String, Usuario> usuarios= (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		//si en la tabla hash existe un usuario con ese mismo nick, se procede a su eliminacion
		if (usuarios.containsKey(nickname) && usuarios.get(nickname).validatePass(contraseña)) {
			
			usuarios.remove(nickname);
			request.getSession().setAttribute("MENSAJE", "Usuario eliminado");
			
			return "menuAdministrador.jsp";
		}else {
			request.getSession().setAttribute("MENSAJE", "Usuario no existente");
			return "menuAdministrador.jsp";
		}
	}

}
