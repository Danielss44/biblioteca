package com.example.biblioteca.controllers;

import com.example.biblioteca.services.LivroServices;
import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.infra.entity.Livro;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroServices services;

    @Operation(summary = "Lista todos os Livros")
    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarTodos(){
        return ResponseEntity.ok(services.listarTodos());
    }

    @Operation(summary = "Cadastra os livros")
    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvarLivro(@RequestBody LivroRequestDTO dto){

        return ResponseEntity.status(201).body(services.salvarLivro(dto));
    }

    @Operation(summary = "Mostra o livro por id")
    @GetMapping("/id/{id}")
    public ResponseEntity<LivroResponseDTO> buscarId(@PathVariable Long id){

        return ResponseEntity.ok(services.buscarID(id));
    }

    @Operation(summary = "Atualiza o livro pela id")
    @PutMapping("{id}")
    public ResponseEntity<LivroResponseDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroRequestDTO livro){
        return ResponseEntity.accepted().body(services.atualizarLivro(id, livro));
    }

    @Operation(summary = "Deleta o livro pela id")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        services.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}
