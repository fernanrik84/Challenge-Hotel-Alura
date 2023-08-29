package com.alura.hotel.hotelAlura.model;

import java.sql.Date;

public class reservasModel {

	private Long idreservas;
    private Date fecha_entrada;
    private Date fecha_salida;
    private float valor;
    private String forma_pago;
    
    public reservasModel( Date fecha_entrada, Date fecha_salida, float valor, String forma_pago) {

        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_pago = forma_pago;
    }
    
	public Long getIdreservas() {
		return idreservas;
	}
	public void setIdreservas(Long idreservas) {
		this.idreservas = idreservas;
	}
	public Date getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
    
}
