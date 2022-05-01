package edu.ucam.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Clase abstracta que servirá de padre para las clases correspondientes a todas las acciones de las jsp
 * @author Alejandro
 *
 */
public abstract class Accion {

	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
