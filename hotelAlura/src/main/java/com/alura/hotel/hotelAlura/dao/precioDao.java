package com.alura.hotel.hotelAlura.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.precioModel;

public class precioDao {

	public void guardar(precioModel valor) {
        Connection con = new Conexion().conectar();
        try(con) {
            con.setAutoCommit(false);
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO PRECIO_RESERVAS (precio) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            try(statement) {
                this.ejecutarRegistro(statement,valor);
                con.commit();
            }
        }catch (SQLException err) {
            throw new RuntimeException(err);
        }
    }
	
	//**************************************************
	private void ejecutarRegistro(PreparedStatement statement,precioModel valor) throws SQLException {
        statement.setFloat(1,valor.getPrecio());
        statement.execute();

        final ResultSet resultSet =  statement.getGeneratedKeys();

        try(resultSet){
            while (resultSet.next()) {
                valor.setId(resultSet.getLong(1));
            }
        }

    }
	//**************************************************
	 public precioModel obtener(){
		 precioModel valor = new precioModel();
	        Connection con = new Conexion().conectar();
	        try(con) {
	            final PreparedStatement statement = con.prepareStatement(
	                    "SELECT ID,PRECIO FROM PRECIO_RESERVAS ORDER BY ID DESC LIMIT 1"
	            );
	            try(statement) {
	                statement.execute();
	                ResultSet resultSet = statement.getResultSet();
	                try(resultSet){
	                    while (resultSet.next()) {
	                        valor.setId(resultSet.getLong("ID"));
	                        valor.setPrecio(resultSet.getFloat("PRECIO"));
	                    }
	                }
	                return valor;
	            }
	        }catch (SQLException err) {
	            throw new RuntimeException(err);
	        }
	 }
	//**************************************************

	 
}
