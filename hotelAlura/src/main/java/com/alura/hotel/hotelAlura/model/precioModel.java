package com.alura.hotel.hotelAlura.model;

public class precioModel {

	private Long id;
	private float precio;
	
	public precioModel(){}
    public precioModel(float precio) {
        this.precio = precio;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
