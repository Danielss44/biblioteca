package com.example.biblioteca.controllers;

import com.example.biblioteca.dto.EmprestimoRequestDTO;
import com.example.biblioteca.dto.EmprestimoResponseDTO;
import com.example.biblioteca.infra.entity.Emprestimo;
import com.example.biblioteca.services.EmprestimoServices;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoServices services;

    @Operation(summary = "Lista todos os empréstimos")
    @GetMapping
    public ResponseEntity<List<EmprestimoResponseDTO>> listarTodos(){
        return ResponseEntity.ok(services.listarTodos());
    }

    @Operation(summary = "Cria os empréstimos")
    @PostMapping
    public  ResponseEntity<EmprestimoResponseDTO> crirarEmprestimo(@RequestBody EmprestimoRequestDTO dto){
        return ResponseEntity.status(201).body(services.criarEmprestimo(dto));
    }

    @Operation(summary = "Devolve o livro e muda a disponibilidade")
    @PostMapping("/{id}/devolver")
    public ResponseEntity<EmprestimoResponseDTO> devolver(@PathVariable Long id, @RequestBody EmprestimoRequestDTO dto){
        return ResponseEntity.status(201).body(services.devolver(id));
    }
}
