package edu.ucam.pojos;

public class Producto {

	private String nombre="";
	private static int id=0;
	private float precio;
	public Producto(String nombre,float precio) {
		this.nombre=nombre;
		this.precio=precio;
		this.id++;;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Producto.id = id;
	}

	
	
	
}
