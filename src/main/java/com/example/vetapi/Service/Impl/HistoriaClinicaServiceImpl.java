package com.example.vetapi.Service.Impl;

import com.example.vetapi.Entity.HistoriaClinica;
import com.example.vetapi.Exception.ResourceNotFoundException;
import com.example.vetapi.Repository.HistoriaClinicaRepository;
import com.example.vetapi.Service.HistoriaClinicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public List<HistoriaClinica> listarTodo() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica buscarPorId(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historia clinica con id " + id + " no encontrada"));
    }

    @Override
    public HistoriaClinica crear(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica) {
        HistoriaClinica existente = buscarPorId(id);
        existente.setFechaApertura(historiaClinica.getFechaApertura());
        existente.setAntecedentes(historiaClinica.getAntecedentes());
        existente.setObservaciones(historiaClinica.getObservaciones());
        return historiaClinicaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        HistoriaClinica existente = buscarPorId(id);
        historiaClinicaRepository.delete(existente);
    }
}