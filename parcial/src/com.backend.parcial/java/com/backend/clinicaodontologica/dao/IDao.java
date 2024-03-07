package com.backend.parcial.dao;
import java.util.List;
public interface IDao<T> {

    T registrar(T t);
    List<T> buscarTodos();


    List<T> listarTodos();


    T obtenerPorId(Long id);


    T actualizar(T entidad);


    void eliminar(int id);



}