package com.alura.hotel.hotelAlura.controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.dao.precioDao;
import com.alura.hotel.hotelAlura.dao.reservasDao;
import com.alura.hotel.hotelAlura.model.reservasModel;
import com.alura.hotel.hotelAlura.model.precioModel;

public class reservasController {

	private static Long idReserva;
    private final reservasDao reservaDao;
    private Connection con;
    private precioDao valorDao;

    public reservasController() {
        this.con = new Conexion().conectar();
        this.reservaDao = new reservasDao(this.con);
        this.valorDao = new precioDao();
    }

    public BigDecimal calcularTotal(Date fecha1, Date fecha2) {
        long resultado = fecha2.getTime() - fecha1.getTime();
        precioModel valor = valorDao.obtener();
        float valorReserva = valor.getPrecio();
        System.out.println(valorReserva);
        TimeUnit time = TimeUnit.DAYS;

        long resto = time.convert(resultado, TimeUnit.MILLISECONDS);
        return new BigDecimal(resto * valorReserva);
    }

    public void guardarReserva(reservasModel reserva) {
        idReserva = this.reservaDao.guardarReserva(reserva);
    }

    public static Long getReservaId(){
        return idReserva;
    }

    public List<reservasModel> obtenerReservas() {
        return this.reservaDao.obtenerReservas();
    }

    public List<reservasModel> obtenerReservaPorNumero(int numero) {
        return this.reservaDao.obtenerReservaPorNumero(numero);
    }

    public int modificar(reservasModel reserva) {
        String valor = calcularTotal(reserva.getFecha_entrada(),reserva.getFecha_salida()).toString();

        reserva.setValor(Float.parseFloat(valor));
        return this.reservaDao.modificar(reserva);
    }

    public int eliminar(int id) {
        return this.reservaDao.eliminar(id);
    }
    
	
}
