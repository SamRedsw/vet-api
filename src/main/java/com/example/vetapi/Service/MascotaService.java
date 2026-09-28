package com.example.vetapi.Service;

import com.example.vetapi.Entity.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodas();

    Mascota buscarPorId(Long id);

    Mascota guardar(Mascota mascota);

    Mascota actualizar(Long id, Mascota mascota);

    void eliminar(Long id);
}