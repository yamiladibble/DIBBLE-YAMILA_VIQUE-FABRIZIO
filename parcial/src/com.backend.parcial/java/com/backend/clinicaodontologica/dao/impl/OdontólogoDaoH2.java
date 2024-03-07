package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.dbconnection.H2Connection;
import com.backend.parcial.entity.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontólogoDaoH2 implements  IDao<Odontologo>{
    private final Logger LOGGER = Logger.getLogger(OdontólogoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        Connection connection = null;
        Odontologo odontologoObtenido = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            String insert = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, NUMERO_MATRICULA) VALUES(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3,odontologo.getNúmeroDeMatrícula());
            preparedStatement.execute();

            odontologoObtenido = new Odontologo(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(),odontologo.getNúmeroDeMatrícula());

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){

                odontologoObtenido.setId(resultSet.getInt("id"));

            }
            connection.commit();
            LOGGER.info("Odontólogo guardado: " + odontologoObtenido);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Hubo un error");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (Exception ex) {
                        LOGGER.error("No pudimos cerrar la conexion: " + ex.getMessage());
                    }
                }
            }
        }

        return odontologoObtenido;
    }



    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Odontologo odontologo = crearObjetoOdontologo(resultSet);
                odontologos.add(odontologo);
            }



            LOGGER.info("Listado de todos los odontólogos: " + odontologos);


        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No pudimos cerrar la conexion: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return odontologos;
    }

//    @Override
//    public Odontologo actualizar (Odontologo odontologo){
//
//        Connection connection = null;
//        Odontologo odontologoObtenido = null;
//        try {
//
//            connection = H2Connection.getConnection();
//            connection.setAutoCommit(false);
//            String insert = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, NUMERO_MATRICULA) VALUES(?, ?, ?)";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, odontologo.getNombre());
//            preparedStatement.setString(2, odontologo.getApellido());
//            preparedStatement.setInt(3,odontologo.getNúmeroDeMatrícula());
//            preparedStatement.execute();
//
//            odontologoObtenido = new Odontologo(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(),odontologo.getNúmeroDeMatrícula());
//
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            while (resultSet.next()){
//
//                odontologoObtenido.setId(resultSet.getInt("id"));
//
//            }
//            connection.commit();
//            LOGGER.info("Odontólogo guardado: " + odontologoObtenido);
//
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//            e.printStackTrace();
//            if (connection != null) {
//                try {
//                    connection.rollback();
//                    LOGGER.info("Hubo un error");
//                    LOGGER.error(e.getMessage());
//                    e.printStackTrace();
//                } catch (SQLException exception) {
//                    LOGGER.error(exception.getMessage());
//                    exception.printStackTrace();
//                } finally {
//                    try {
//                        connection.close();
//                    } catch (Exception ex) {
//                        LOGGER.error("No pudimos cerrar la conexion: " + ex.getMessage());
//                    }
//                }
//            }
//        }

    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {
        return new Odontologo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
    }

}


