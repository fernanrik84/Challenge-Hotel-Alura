package com.alura.hotel.hotelAlura;

import java.sql.Connection;

import com.alura.hotel.hotelAlura.dao.userDao;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.reservasModel;
import com.alura.hotel.hotelAlura.model.userModel;
import com.alura.hotel.hotelAlura.utils.ValidatePasswords;

public class TestCrearUser {

	public static void main(String[] args) {
		
        Connection con = new Conexion().conectar();
        String password = ValidatePasswords.encryptPassword("admin");
        userModel usuarioTest = new userModel("Admin Fernando","Rico","admin",password);
        userDao usuarioDao = new userDao(con);
        usuarioDao.guardarUsuario(usuarioTest);


    }
	
}
