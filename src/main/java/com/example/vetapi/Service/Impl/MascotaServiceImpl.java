package com.example.vetapi.Service.Impl;

import com.example.vetapi.Entity.Mascota;
import com.example.vetapi.Exception.ResourceNotFoundException;
import com.example.vetapi.Repository.MascotaRepository;
import com.example.vetapi.Service.MascotaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota con id " + id + " no encontrada"));
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Long id, Mascota mascota) {
        Mascota existente = buscarPorId(id);
        existente.setNombre(mascota.getNombre());
        existente.setEspecie(mascota.getEspecie());
        existente.setRaza(mascota.getRaza());
        existente.setEdad(mascota.getEdad());
        existente.setPeso(mascota.getPeso());
        existente.setPropietario(mascota.getPropietario());
        return mascotaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Mascota existente = buscarPorId(id);
        mascotaRepository.delete(existente);
    }
}