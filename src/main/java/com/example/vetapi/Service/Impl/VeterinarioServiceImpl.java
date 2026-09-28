package com.example.vetapi.Service.Impl;

import com.example.vetapi.Entity.Veterinario;
import com.example.vetapi.Exception.ResourceNotFoundException;
import com.example.vetapi.Repository.VeterinarioRepository;
import com.example.vetapi.Service.VeterinarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario con id " + id + " no encontrado"));
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario actualizar(Long id, Veterinario veterinario) {
        Veterinario existente = buscarPorId(id);
        existente.setNombre(veterinario.getNombre());
        existente.setTarjetaProfesional(veterinario.getTarjetaProfesional());
        existente.setEspecialidad(veterinario.getEspecialidad());
        existente.setCorreo(veterinario.getCorreo());
        return veterinarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Veterinario existente = buscarPorId(id);
        veterinarioRepository.delete(existente);
    }
}