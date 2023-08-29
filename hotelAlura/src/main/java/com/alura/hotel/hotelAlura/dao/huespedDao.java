package com.alura.hotel.hotelAlura.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.alura.hotel.hotelAlura.model.huespedModel;
import com.alura.hotel.hotelAlura.db.Conexion;

public class huespedDao {
	
	private final Connection con;
	
	public huespedDao(Connection con){
        this.con = con;
    }

	public void guardarHuesped(huespedModel huesped){
        final Connection con = new Conexion().conectar();
        try(con){
            con.setAutoCommit(false);
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO HUESPEDES" +
                            "(NOMBRE,APELLIDO,FECHA_NACIMIENTO,NACIONALIDAD,TELEFONO,IDRESERVA) VALUES " +
                            "(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            try(statement){
                this.ejecutarRegistro(statement,huesped);
                con.commit();
            }
        } catch (SQLException err){
            err.printStackTrace();
            throw new RuntimeException();
        }
    }
    
	//**************************************************
	
	private void ejecutarRegistro(PreparedStatement statement, huespedModel huesped) throws SQLException {

        statement.setString(1, huesped.getNombre());
        statement.setString(2, huesped.getApellido());
        statement.setDate(3, huesped.getFecha_nacimiento());
        statement.setString(4,huesped.getNacionalidad());
        statement.setString(5,huesped.getTelefono());
        statement.setLong(6,huesped.getIdreserva());
        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        try(resultSet) {
            while (resultSet.next()) {
                huesped.setIdreserva(resultSet.getLong(1));
                System.out.printf("el usuario del id %s fue insertado exitosamente%n",huesped);
            }
        }
    }
	
	//**************************************************
	
	public List<huespedModel> obtenerHuespedes() {
        List<huespedModel> huespedList = new ArrayList<>();
        final Connection con  = new Conexion().conectar();
        try(con) {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT " +
                            "IDHUESPEDES," +
                            "NOMBRE," +
                            "APELLIDO," +
                            "FECHA_NACIMIENTO," +
                            "NACIONALIDAD," +
                            "TELEFONO," +
                            "IDRESERVA " +
                            "FROM HUESPEDES"
            );
            try(statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet();

                while(resultSet.next()){
                	huespedModel huesped = new huespedModel(

                            resultSet.getString("NOMBRE"),
                            resultSet.getString("APELLIDO"),
                            resultSet.getDate("FECHA_NACIMIENTO"),
                            resultSet.getString("NACIONALIDAD"),
                            resultSet.getString("TELEFONO")
                    );
                    huesped.setIdhuespedes(resultSet.getLong("IDHUESPEDES"));
                    huesped.setIdreserva(resultSet.getLong("IDRESERVA"));
                    huespedList.add(huesped);
                }
                return huespedList;
            }

        }catch (SQLException err ) {
            throw new RuntimeException();
        }
    }
    
	//**************************************************

	public List<huespedModel> obtenerPorApellido(String apellido) {
        List<huespedModel> huespedList = new ArrayList<>();
        final Connection con  = new Conexion().conectar();
        try(con) {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT " +
                            "IDHUESPEDES," +
                            "NOMBRE," +
                            "APELLIDO," +
                            "FECHA_NACIMIENTO," +
                            "NACIONALIDAD," +
                            "TELEFONO," +
                            "IDRESERVA " +
                            "FROM HUESPEDES WHERE APELLIDO = ?"
            );
            try(statement) {
                statement.setString(1,apellido);
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                	huespedModel huesped = new huespedModel(

                            resultSet.getString("NOMBRE"),
                            resultSet.getString("APELLIDO"),
                            resultSet.getDate("FECHA_NACIMIENTO"),
                            resultSet.getString("NACIONALIDAD"),
                            resultSet.getString("TELEFONO")
                    );
                    huesped.setIdhuespedes(resultSet.getLong("IDHUESPEDES"));
                    huesped.setIdreserva(resultSet.getLong("IDRESERVA"));
                    huespedList.add(huesped);
                }
                return huespedList;
            }


        }catch (SQLException err ) {

            throw new RuntimeException();
        }
    }

	//**************************************************

    public List<huespedModel> obtenerPorReserva(int text) {
        List<huespedModel> huespedList = new ArrayList<>();
        final Connection con  = new Conexion().conectar();
        try(con) {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT " +
                            "IDHUESPEDES," +
                            "NOMBRE," +
                            "APELLIDO," +
                            "FECHA_NACIMIENTO," +
                            "NACIONALIDAD," +
                            "TELEFONO," +
                            "IDRESERVA " +
                            "FROM HUESPEDES WHERE IDRESERVA = ?"
            );
            try(statement) {
                statement.setInt(1,text);
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                	huespedModel huesped = new huespedModel(

                            resultSet.getString("NOMBRE"),
                            resultSet.getString("APELLIDO"),
                            resultSet.getDate("FECHA_NACIMIENTO"),
                            resultSet.getString("NACIONALIDAD"),
                            resultSet.getString("TELEFONO")
                    );
                    huesped.setIdhuespedes(resultSet.getLong("IDHUESPEDES"));
                    huesped.setIdreserva(resultSet.getLong("IDRESERVA"));
                    huespedList.add(huesped);
                }
                return huespedList;
            }
        }catch (SQLException err ) {
            throw new RuntimeException();
        }
    }

	//**************************************************

    public int modificar(huespedModel huesped) {
        final Connection con = new Conexion().conectar();
        try (con) {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE HUESPEDES SET " +
                            "NOMBRE=?," +
                            "APELLIDO=?," +
                            "FECHA_NACIMIENTO=?," +
                            "NACIONALIDAD=?," +
                            "TELEFONO=?," +
                            "IDRESERVA=? " +
                            "  WHERE IDHUESPEDES = ?"
            );
            try (statement) {
                statement.setString(1,huesped.getNombre());
                statement.setString(2,huesped.getApellido());
                statement.setDate(3,huesped.getFecha_nacimiento());
                statement.setString(4,huesped.getNacionalidad());
                statement.setString(5,huesped.getTelefono());
                statement.setLong(6,huesped.getIdreserva());
                statement.setLong(7,huesped.getIdhuespedes());
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPEDES WHERE IDHUESPEDES = ?");
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
