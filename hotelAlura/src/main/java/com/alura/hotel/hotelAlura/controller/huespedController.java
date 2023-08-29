package com.alura.hotel.hotelAlura.controller;

import java.sql.Connection;
import java.util.List;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.dao.huespedDao;
import com.alura.hotel.hotelAlura.dao.reservasDao;
import com.alura.hotel.hotelAlura.model.huespedModel;

public class huespedController {
	
	private reservasDao reservaDao;
	private huespedDao huespedDao;
	private static Long reserva = reservasController.getReservaId();
	 
	private Connection con;
		
	public huespedController(Connection con){
		 this.con = con;
     }
	
	public huespedController() {
        this.con = new Conexion().conectar();
        this.huespedDao = new huespedDao(this.con);
    }

    public void guardar(huespedModel huesped){
        huesped.setIdreserva(reserva);
        this.huespedDao.guardarHuesped(huesped);
    }

    public Long getReserva() {
        return reserva;
    }

    public List<huespedModel> obtenerHuespedes() {
        return this.huespedDao.obtenerHuespedes();
    }

    public List<huespedModel> obtenerPorApellido(String apellido) {
        return this.huespedDao.obtenerPorApellido(apellido);
    }

    public List<huespedModel> obtenerPorReserva(int text) {
        return this.huespedDao.obtenerPorReserva(text);
    }

    public int modificar(huespedModel huesped) {
        return this.huespedDao.modificar(huesped);
    }

    public int eliminar(int id) {
        return this.huespedDao.eliminar(id);
    }
	    
	    
}
