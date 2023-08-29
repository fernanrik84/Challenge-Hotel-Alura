package com.alura.hotel.hotelAlura;

import com.alura.hotel.hotelAlura.controller.sesionController;
import com.alura.hotel.hotelAlura.dao.userDao;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.sesionModel;
import com.alura.hotel.hotelAlura.model.userModel;
import com.alura.hotel.hotelAlura.utils.ValidatePasswords;
import java.sql.Connection;

public class TestSesion {

	public static void main(String[] args) {
        crearSesion();
    }

    public static void eliminarSesion(){
    	sesionController sessionController = new sesionController();
        sessionController.eliminarSesion();
    }

    public static void crearSesion(){
    	sesionModel session = new sesionModel(1L);
        sesionController sessionController = new sesionController();
        sessionController.guardarSession(session);
        sesionModel session1 =  sessionController.obtenerSession();
        System.out.println(session1.getIdusuario());
    }
    public static void crearUsuario(){
        Connection con = new Conexion().conectar();
        userDao usuarioDao = new userDao(con);
        String password = ValidatePasswords.encryptPassword("031182");
        userModel usuario = new userModel("Juan","Barajas","JBarajas",password);
        usuarioDao.guardarUsuario(usuario);
        userModel usuario1 = usuarioDao.obtenerUsuario("JBarajas");
    }
    
}
