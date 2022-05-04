package edu.ucam.acciones.accionesUsuario;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.acciones.Accion;
import edu.ucam.pojos.Usuario;
/**
 * Clase que permite a�adir un usuario a la tabla hash de usuarios, que posteriormente se volcar� en la base de datos
 * @author Alejandro
 *
 */
public class AccionA�adirUsuario extends Accion {
/**
 * Metodo para a�adir usuario mediante los parametros recogidos en el formulario de la jsp "a�adirUsuario"
 * @return ruta al menu del administrador
 */
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre= (String) request.getParameter("NAME"); //variable que recoge el nombre del nuevo usuario
		String contrase�a = (String) request.getParameter("PASS");//variable que recoge la contrase�a del nuevo usuario
		String apellido = (String) request.getParameter("SURNAME");
		String nickname =(String) request.getParameter("NICKNAME");
		
		
		//se obtiene la tabla hash del contexto para ser usada en esta clase
		Hashtable<String, Usuario> usuarios= (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS"); 
		
		
		if("".equals(nickname)) { // si el nickname est� vac�o se genera automaticamente
			//nick est� formado por la primera letra del nombre+ el apellido (drosique por ejemplo)
			String nick = nombre.charAt(0) + apellido;
			nickname = nick;
			int i=0;
			while(usuarios.containsKey(nickname)){ // mientras exista ese nickname
					i++;
					nickname = nick + i; // nickname = drosique1 
			}
		}
		
		//si en la tabla de usuarios no existe un usuario con dicho nickname, se procede al almacenamiento de este nuevo usuario
		if (!usuarios.containsKey(nickname)) {
			Usuario user= new Usuario(nombre,contrase�a,apellido); //instancia de objeto Usuario
			user.setNickName(nickname);
			usuarios.put(nickname, user); //se vuelca en al tabla hash
			request.getSession().setAttribute("MENSAJE", "Usuario a�adido <strong>Nickname: " + nickname + "</strong>"); 
			
			return "menuAdministrador.jsp";
		}else {
			
			request.getSession().setAttribute("MENSAJE", "Usuario ya existente");
			return "menuAdministrador.jsp";
		}
	}

}
