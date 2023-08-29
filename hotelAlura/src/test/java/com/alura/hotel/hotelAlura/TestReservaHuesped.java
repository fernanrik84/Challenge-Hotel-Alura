package com.alura.hotel.hotelAlura;

import com.alura.hotel.hotelAlura.dao.huespedDao;
import com.alura.hotel.hotelAlura.dao.reservasDao;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.huespedModel;
import com.alura.hotel.hotelAlura.model.reservasModel;
import java.sql.Connection;
import java.sql.Date;

public class TestReservaHuesped {

	 public static void main(String[] args) {
	        Connection con = new Conexion().conectar();
	        huespedDao huespedDao = new huespedDao(con);
	        reservasDao reservaDao = new reservasDao(con);

	        reservasModel reserva = new reservasModel(
	                Date.valueOf("2023-08-30"),
	                Date.valueOf("2023-09-5"),
	                10,
	                "Dinero en efectivo"
	        );
	        Long result =  reservaDao.guardarReserva(reserva);
	        huespedModel huesped = new huespedModel(
	                "Shiara",
	                "Barajas",
	                Date.valueOf("2019-05-09"),
	                "Venezolana",
	                "1234567890",
	                result
	        );
	        huespedDao.guardarHuesped(huesped);
	    }
	 
}
