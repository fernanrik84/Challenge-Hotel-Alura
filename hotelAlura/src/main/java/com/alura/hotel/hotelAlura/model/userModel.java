package com.alura.hotel.hotelAlura.model;

public class userModel {

	private Long idusers;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    
    public userModel() {}
    public userModel( String nombre, String apellido, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
    }
    
    
	public Long getIdusers() {
		return idusers;
	}
	public void setIdusers(Long idusers) {
		this.idusers = idusers;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
