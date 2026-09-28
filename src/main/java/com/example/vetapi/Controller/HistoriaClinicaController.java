package com.example.vetapi.Controller;

import com.example.vetapi.Entity.HistoriaClinica;
import com.example.vetapi.Service.HistoriaClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarTodo() {
        return ResponseEntity.ok(historiaClinicaService.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historiaClinicaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> crear(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica creada = historiaClinicaService.crear(historiaClinica);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        return ResponseEntity.ok(historiaClinicaService.actualizar(id, historiaClinica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}