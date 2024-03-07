package com.backend.clinicaodontologica.controller;
import com.backend.clinicaodontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;


import com.backend.clinicaodontologica.service.impl.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoServiceService;
    }

    @GetMapping("/{id}")//buscar odontologo por id
    public ResponseEntity<OdontologoSalidaDto> buscarOdontologoPorId(@PathVariable int id){
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id),HttpStatus.OK);
    }
    @PostMapping("/registrar")//registrar odontologo
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@RequestBody @Valid OdontologoEntradaDto odontologo){
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")//actualizar registro de odontologo
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@RequestBody @Valid OdontologoEntradaDto odontologo){
        return null; //pacienteService.actualizar(paciente);
    }
}
