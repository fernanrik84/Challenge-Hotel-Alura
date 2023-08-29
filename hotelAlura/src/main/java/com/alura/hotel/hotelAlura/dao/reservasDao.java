package com.alura.hotel.hotelAlura.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.hotelAlura.db.Conexion;
import com.alura.hotel.hotelAlura.model.reservasModel;

public class reservasDao {

	
	private final Connection con;
	
	public reservasDao(Connection con){
        this.con = con;
    }
	
	public Long guardarReserva(reservasModel reserva) {
        try(this.con) {
            this.con.setAutoCommit(false);
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO RESERVAS " +
                            "(FECHA_ENTRADA,FECHA_SALIDA,VALOR,FORMA_PAGO)" +
                            " VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            try(statement){
                ejecutarRegistro(statement,reserva);
                con.commit();
            }
        } catch (SQLException err){
            throw new RuntimeException(err);
        }
        return reserva.getIdreservas();
    }
    
	//**************************************************
	
	private void ejecutarRegistro(PreparedStatement statement, reservasModel reserva) throws SQLException {
        statement.setDate(1,reserva.getFecha_entrada());
        statement.setDate(2,reserva.getFecha_salida());
        statement.setDouble(3,reserva.getValor());
        statement.setString(4,reserva.getForma_pago());
        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();
        try(resultSet) {
            while (resultSet.next()) {
                reserva.setIdreservas(resultSet.getLong(1));
            }
        }
    }
	
	//**************************************************

	 public List<reservasModel> obtenerReservas() {
	        List<reservasModel> reservaList = new ArrayList<>();
	        final Connection con = new Conexion().conectar();
	        try(con){
	            final PreparedStatement statement = con.prepareStatement(
	                    "SELECT IDRESERVAS," +
	                            "FECHA_ENTRADA," +
	                            "FECHA_SALIDA," +
	                            "VALOR," +
	                            "FORMA_PAGO FROM RESERVAS");
	            try(statement) {
	                statement.execute();
	                ResultSet resultSet = statement.getResultSet();

	                while (resultSet.next()){
	                	reservasModel reserva = new reservasModel(
	                            resultSet.getDate("FECHA_ENTRADA"),
	                            resultSet.getDate("FECHA_SALIDA"),
	                            resultSet.getFloat("VALOR"),
	                            resultSet.getString("FORMA_PAGO")
	                    );
	                    reserva.setIdreservas(resultSet.getLong("IDRESERVAS"));
	                    reservaList.add(reserva);
	                }
	                return reservaList;
	            }
	        } catch (SQLException err) {
	            throw new RuntimeException(err);
	        }
	    }
	
	//**************************************************

	 public List<reservasModel> obtenerReservaPorNumero(int numero) {
	        List<reservasModel> reservaList = new ArrayList<>();
	        final Connection con = new Conexion().conectar();
	        try(con){
	            final PreparedStatement statement = con.prepareStatement(
	                    "SELECT IDRESERVAS," +
	                            "FECHA_ENTRADA," +
	                            "FECHA_SALIDA," +
	                            "VALOR," +
	                            "FORMA_PAGO FROM RESERVAS WHERE IDRESERVAS = ?");
	            try(statement) {
	                statement.setInt(1,numero);
	                statement.execute();
	                ResultSet resultSet = statement.getResultSet();

	                while (resultSet.next()){
	                	reservasModel reserva = new reservasModel(
	                            resultSet.getDate("FECHA_ENTRADA"),
	                            resultSet.getDate("FECHA_SALIDA"),
	                            resultSet.getFloat("VALOR"),
	                            resultSet.getString("FORMA_PAGO")
	                    );
	                    reserva.setIdreservas(resultSet.getLong("IDRESERVAS"));

	                    reservaList.add(reserva);
	                }

	                return reservaList;
	            }
	        } catch (SQLException err) {
	            throw new RuntimeException(err);
	        }
	    }
	 
	//**************************************************

	 public int modificar(reservasModel reserva) {
	        final Connection con = new Conexion().conectar();
	        try (con) {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE RESERVAS SET FECHA_ENTRADA=?," +
	                            "FECHA_SALIDA=?," +
	                            "VALOR=?," +
	                            "FORMA_PAGO=? WHERE IDRESERVAS = ?"
	            );
	            try (statement) {
	                statement.setDate(1,reserva.getFecha_entrada());
	                statement.setDate(2,reserva.getFecha_salida());
	                statement.setDouble(3,reserva.getValor());
	                statement.setString(4,reserva.getForma_pago());
	                statement.setLong(5,reserva.getIdreservas());
	                statement.execute();

	                return statement.getUpdateCount();
	            }
	        } catch (SQLException err) {
	            throw new RuntimeException(err);
	        }
	    }
	
	//**************************************************
	 
	 public int eliminar(int id) {
	        Connection con = new Conexion().conectar();
	        try(con) {
	            final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVAS WHERE IDRESERVAS = ?");
	            try(statement) {
	                statement.setInt(1, id);
	                statement.execute();
	                return statement.getUpdateCount();
	            }
	        } catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	    }
	 
	//**************************************************

}
