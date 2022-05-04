package edu.ucam.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccionIr extends Accion {
	
protected String jsp;
	
	public AccionIr(String jsp){
		this.jsp=jsp;
	}
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return jsp;
	}

}
