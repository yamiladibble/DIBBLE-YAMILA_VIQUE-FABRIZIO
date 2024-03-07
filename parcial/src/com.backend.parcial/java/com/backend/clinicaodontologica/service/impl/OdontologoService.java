package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.entity.Odontologo;
import java.util.List;

public class OdontologoService implements IOdontologoService {

    private IDao<Odontologo> odontologoIDao;
    public OdontologoService(IDao<Odontologo> odontologoIDao){
        this.odontologoIDao= odontologoIDao;
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoIDao.registrar(odontologo);
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.buscarTodos();
    }

    @Override
    public Odontologo obtenerOdontologoPorId(int id)  {
        return odontologoIDao.obtenerPorId(int id);
    }
    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoIDao.actualizar(odontologo);
    }
    }




