package com.backend.parcial.service;

import com.backend.parcial.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);
    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto obtenerOdontologoPorId(int id);
    OdontologoSalidaDto actualizarOdontologo(OdontologoEntradaDto odontologo);



}
