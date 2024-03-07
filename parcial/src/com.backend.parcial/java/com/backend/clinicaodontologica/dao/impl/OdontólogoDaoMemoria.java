package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontólogoDaoMemoria implements IDao <Odontologo>{

    private final Logger LOGGER = Logger.getLogger(OdontólogoDaoMemoria.class);
    private List<Odontologo> odontologoRepository;
    public OdontólogoDaoMemoria(List<Odontologo> odontologoRepository) {this.odontologoRepository = odontologoRepository;}


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        int id = odontologoRepository.size() + 1;
        Odontologo odontologoGuardado = new Odontologo(id, odontologo.getNombre(), odontologo.getApellido(), odontologo.getNúmeroDeMatrícula());
        odontologoRepository.add(odontologo);
        LOGGER.info("Odontólogo registrado: " + odontologoGuardado);
    return odontologoGuardado;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository;
    }
    }
