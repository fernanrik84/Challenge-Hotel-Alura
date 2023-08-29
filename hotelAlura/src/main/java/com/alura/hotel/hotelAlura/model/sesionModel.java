package com.alura.hotel.hotelAlura.model;

import java.sql.Date;

public class sesionModel {

	private Long idusuario;
    private Date crear_at;
    
    public sesionModel(){}
    public sesionModel(Long idusuario) {
        this.idusuario = idusuario;
    }
    
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public Date getCrear_at() {
		return crear_at;
	}
	public void setCrear_at(Date crear_at) {
		this.crear_at = crear_at;
	}
    
    
}
