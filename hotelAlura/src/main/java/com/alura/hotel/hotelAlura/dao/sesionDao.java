package com.alura.hotel.hotelAlura.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.sesionModel;

public class sesionDao {

	private final Connection con;
	
	public sesionDao(Connection con){
        this.con = con;
    }
	
	//**************************************************
	
	 public void guardarSession(sesionModel session){
	        try(this.con) {
	            this.con.setAutoCommit(false);
	            PreparedStatement statement = this.con.prepareStatement(
	                    "INSERT INTO SESION (idusuario) VALUES (?)"
	            );
	            try(statement){
	                statement.setLong(1,session.getIdusuario());
	                statement.execute();
	                this.con.commit();
	            }
	        } catch (SQLException err) {
	            throw new RuntimeException();
	        }
	    }

	//**************************************************

	    public sesionModel obtenerSession(){
	    	sesionModel session = new sesionModel();
	        Connection con = new Conexion().conectar();
	        try(con) {
	            con.setAutoCommit(false);
	            PreparedStatement statement = con.prepareStatement("SELECT IDUSUARIO,CREAR_AT FROM SESION");

	            try(statement){
	                statement.execute();
	                ResultSet resultSet = statement.getResultSet();
	                while (resultSet.next()){
	                    session.setIdusuario(resultSet.getLong("IDUSUARIO"));
	                    session.setCrear_at(resultSet.getDate("CREAR_AT"));
	                }
	            }
	        } catch (SQLException err) {
	            throw new RuntimeException();
	        }
	        return session;
	    }
	    
	//**************************************************

	    public int eliminarSession() {
	        final Connection con = new Conexion().conectar();

	        try (con) {
	            PreparedStatement statement = con.prepareStatement(
	                    "DELETE FROM SESSION"
	            );
	            try(statement) {
	                statement.execute();
	                return statement.getUpdateCount();
	            }
	        }catch (SQLException err ){
	            throw new RuntimeException();
	        }

	    }
	    
	
}
