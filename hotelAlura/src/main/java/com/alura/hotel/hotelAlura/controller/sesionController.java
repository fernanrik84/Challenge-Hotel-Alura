package com.alura.hotel.hotelAlura.controller;

import com.alura.hotel.hotelAlura.dao.sesionDao;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.sesionModel;
import java.sql.Connection;

public class sesionController {

	private static sesionModel session;
	private  sesionDao sessionDao;
	
	public sesionController(){
	    Connection con = new Conexion().conectar();
	    this.sessionDao = new sesionDao(con);
	}
	
	public void guardarSession(sesionModel sessionUser){
	    session = sessionUser;
	    this.sessionDao.guardarSession(sessionUser);
	}
	
	public sesionModel obtenerSession(){
	    if(session == null){
	        return this.sessionDao.obtenerSession();
	    }
	    return session;
	}
	
	public void eliminarSesion() {
	    if(session == null) {
	        this.sessionDao.eliminarSession();
	        return;
	    }
	    session = null;
	}
	    
}
