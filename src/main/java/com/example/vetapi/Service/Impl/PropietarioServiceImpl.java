package com.example.vetapi.Service.Impl;

import com.example.vetapi.Entity.Propietario;
import com.example.vetapi.Exception.ResourceNotFoundException;
import com.example.vetapi.Repository.PropietarioRepository;
import com.example.vetapi.Service.PropietarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioServiceImpl(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario buscarPorId(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Propietario con id " + id + " no encontrado"));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietario) {
        Propietario existente = buscarPorId(id);
        existente.setNombre(propietario.getNombre());
        existente.setDocumento(propietario.getDocumento());
        existente.setTelefono(propietario.getTelefono());
        existente.setCorreo(propietario.getCorreo());
        return propietarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Propietario existente = buscarPorId(id);
        propietarioRepository.delete(existente);
    }
}