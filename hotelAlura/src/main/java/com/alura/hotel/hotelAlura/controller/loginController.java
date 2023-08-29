package com.alura.hotel.hotelAlura.controller;

import com.alura.hotel.hotelAlura.dao.precioDao;
import com.alura.hotel.hotelAlura.dao.userDao;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.userModel;
import com.alura.hotel.hotelAlura.model.precioModel;

public class loginController {

	private userDao usuarioDao;
	private precioDao priceDao;

    public loginController(){
        this.usuarioDao = new userDao(new Conexion().conectar());
    }
    
    public userModel obtenerUsuario(String usuario){
        return this.usuarioDao.obtenerUsuario(usuario);
    }

    public void guardar(userModel usuario1) {
        this.usuarioDao.guardarUsuario(usuario1);
    }

    public userModel obtenerUsuarioPorId(Long idUsuario) {
        return this.usuarioDao.obtenerUsuarioPorId(idUsuario);
    }

    public int actualizar(userModel usuario) {
        return this.usuarioDao.actualizar(usuario);
    }
    
    public int eliminar(Long id){
        return this.usuarioDao.delete(id);
    }
    
	    
}
