package com.alura.hotel.hotelAlura.model;

import java.sql.Date;

public class huespedModel {
	
	private Long idhuespedes;
	private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String nacionalidad;
    private String telefono;
    private Long idreserva;
	
    public huespedModel(Long idhuespedes ,String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono,Long idreserva) {
        this.idhuespedes = idhuespedes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.idreserva = idreserva;
    }

    public huespedModel(String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono,Long idreserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.idreserva = idreserva;
    }

    public huespedModel(String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }

   
    public Long getIdhuespedes() {
		return idhuespedes;
	}
	public void setIdhuespedes(Long idhuespedes) {
		this.idhuespedes = idhuespedes;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Long idreserva) {
		this.idreserva = idreserva;
	}
	
    
    
    
}
