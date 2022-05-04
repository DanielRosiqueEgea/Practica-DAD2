package edu.ucam.pojos;

public class Usuario {

	private String nombre;
	private String apellido;
	private String pass;
	private String nickName;
	
	public Usuario(String nombre, String pass, String apellido) {
		this.apellido= apellido;
		this.nombre= nombre;
		this.pass= pass;
	}
	
	//metodo que valida la contraseña (util en caso de cifrarla) 
		public boolean validatePass(String pass) {
			return this.pass.equals(pass);
		}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickname) {
		
		this.nickName=nickname;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
