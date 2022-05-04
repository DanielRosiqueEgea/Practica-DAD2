package edu.ucam.acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.pojos.Usuario;
/**
 * Clase para realizar el login en la pagina web
 * @author Alejandro
 *
 */
public class AccionLogin extends Accion {
/**
 * Metodo que permite hacer el login del administrador y de los usuarios
 * @return ruta de la jsp "menuAdministrado"
 * @return ruta de la jsp "login"
 */
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pass= request.getParameter("PASS");//pass recoge el valor del parametro PASS que hemos metido en la jsp login
		String nickname =request.getParameter("NICKNAME");
		/*
		Usuario user= new Usuario(nombre,pass); 
		No hace falta inicializar esto aqui, solo lo inicializaremos si existe dentro de la hashtable
		*/
		Usuario user;
		
		@SuppressWarnings("unchecked")
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		/*
		esto lo hago asi porque quiero que el administrador pueda acceder a su entorno siempre, 
		asegurandome que ningun fallo en el programa pueda evitarselo
		*/
		
		if ("admin".equals(pass) && "admin".equals(nickname)) {
			user = new Usuario("admin","admin","admin"); //se crea el usuario una vez comprobado que es admin
			user.setNickName("admin"); 
			// como el nickname se genera despúes, no se muy bien si dejarlo como un metodo set o dentro del constructor 
			request.getSession().setAttribute("USUARIO", user);
			return "menuAdministrador.jsp";
			
		}
		
		//si existe el nicname y se valida la contraseña es por que existe el usuario.
		if(usuarios.containsKey(nickname) && usuarios.get(nickname).validatePass(pass)) {
			user= usuarios.get(nickname); //si existe el usuario lo cogemos y lo añadimos a Usuario conectado
			request.getSession().setAttribute("USUARIO", user);
			System.out.println(request.getSession().getAttribute("USUARIO"));
			return "menuProductos.jsp";
		}
		return "login.jsp";
		
	}

}
