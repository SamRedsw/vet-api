package com.example.vetapi.Service;

import com.example.vetapi.Entity.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {

    List<HistoriaClinica> listarTodo();

    HistoriaClinica buscarPorId(Long id);

    HistoriaClinica crear(HistoriaClinica historiaClinica);

    HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica);

    void eliminar(Long id);
}