package com.example.vetapi.Controller;

import com.example.vetapi.Entity.Propietario;
import com.example.vetapi.Service.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @GetMapping
    public ResponseEntity<List<Propietario>> listarTodos() {
        return ResponseEntity.ok(propietarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(propietarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Propietario> guardar(@RequestBody Propietario propietario) {
        Propietario creado = propietarioService.guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable Long id, @RequestBody Propietario propietario) {
        return ResponseEntity.ok(propietarioService.actualizar(id, propietario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}