package com.alura.hotel.hotelAlura.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.userModel;

public class userDao {

	private final Connection con;
	
	public userDao(Connection con){
        this.con = con;
    }
	
	//**************************************************
	
	public userModel obtenerUsuario(String usuario){
		userModel user = new userModel();
	       Connection con = new Conexion().conectar();

	       try(con){
	           final PreparedStatement statement = con.prepareStatement(
	                   "SELECT idusers,NOMBRE,APELLIDO,usuario,password FROM USERS WHERE usuario = ?"
	           );
	           try(statement){
	               statement.setString(1,usuario);
	               statement.execute();

	               ResultSet resultSet = statement.getResultSet();

	               while (resultSet.next()){
	                    user.setIdusers(resultSet.getLong("idusers"));
	                    user.setNombre(resultSet.getString("NOMBRE"));
	                    user.setApellido(resultSet.getString("APELLIDO"));
	                    user.setUsuario(resultSet.getString("usuario"));
	                    user.setPassword(resultSet.getString("password"));
	               }
	           }
	       }catch (SQLException e){
	           throw new RuntimeException(e);
	       }
	       return user;
	   }
	
	//**************************************************
	 public void guardarUsuario(userModel user){

	       try(this.con) {
	           this.con.setAutoCommit(false);
	           final PreparedStatement statement = this.con.prepareStatement(
	                   "INSERT INTO USERS (NOMBRE,APELLIDO,USUARIO,PASSWORD) VALUES (?,?,?,?)",
	                   Statement.RETURN_GENERATED_KEYS
	           );
	           try(statement) {
	               this.ejecutarRegistro(statement,user);
	               con.commit();
	           }
	       }catch (SQLException err) {
	           throw new RuntimeException(err);
	       }

	    }
	//**************************************************
	 private void ejecutarRegistro(PreparedStatement statement, userModel user) throws SQLException {
	        statement.setString(1,user.getNombre());
	        statement.setString(2,user.getApellido());
	        statement.setString(3,user.getUsuario());
	        statement.setString(4,user.getPassword());

	        statement.execute();

	        final ResultSet resultSet = statement.getGeneratedKeys();

	        try(resultSet){
	            while (resultSet.next()){
	                user.setIdusers(resultSet.getLong(1));
	                System.out.printf("el usuario del id %s fue insertado exitosamente%n",user);
	            }
	        }

	    }
	//**************************************************
	 public userModel obtenerUsuarioPorId(long idUsuario) {
		 userModel user = new userModel();
	        Connection con = new Conexion().conectar();

	        try(con){
	            final PreparedStatement statement = con.prepareStatement(
	                    "SELECT IDUSERS,NOMBRE,APELLIDO,USUARIO,PASSWORD FROM USERS WHERE IDUSERS = ?"
	            );
	            try(statement){
	                statement.setLong(1,idUsuario);
	                statement.execute();

	                ResultSet resultSet = statement.getResultSet();

	                while (resultSet.next()){
	                    user.setIdusers(resultSet.getLong("IDUSERS"));
	                    user.setNombre(resultSet.getString("NOMBRE"));
	                    user.setApellido(resultSet.getString("APELLIDO"));
	                    user.setUsuario(resultSet.getString("USUARIO"));
	                    user.setPassword(resultSet.getString("PASSWORD"));
	                }
	            }
	        }catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	        return user;
	    }
	//**************************************************
	 public int actualizar(userModel usuario) {
	        final Connection con = new Conexion().conectar();
	        try (con) {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE USERS SET NOMBRE=?,APELLIDO=?,USUARIO=?,PASSWORD=? WHERE IDUSERS = ?"
	            );
	            try (statement) {
	                statement.setString(1,usuario.getNombre());
	                statement.setString(2,usuario.getApellido());
	                statement.setString(3,usuario.getUsuario());
	                statement.setString(4,usuario.getPassword());
	                statement.setLong(5,usuario.getIdusers());
	                statement.execute();

	                return statement.getUpdateCount();
	            }
	        } catch (SQLException err) {
	            throw new RuntimeException(err);
	        }
	 }
	//**************************************************
	 public int delete(Long id){
        Connection con = new Conexion().conectar();
        try(con) {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM USERS WHERE IDUSERS = ?");
            try(statement) {
                statement.setLong(1, id);
                statement.execute();
                return statement.getUpdateCount();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
	//**************************************************

}
