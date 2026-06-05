package com.example.biblioteca.controllers;

import com.example.biblioteca.services.UsuarioServices;
import com.example.biblioteca.dto.UsuarioRequestDTO;
import com.example.biblioteca.dto.UsuarioResponseDTO;
import com.example.biblioteca.infra.entity.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices services;

    @Operation(summary = "Lista todos os usuarios")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> ListarUsuario(){
        return ResponseEntity.ok(services.listarUsuarios());
    }

    @Operation(summary = "Cria novos usuarios")
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.status(201).body(services.criarUsuario(dto));

    }

    @Operation(summary = "Mostra usuario por id")
    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarID(@PathVariable Long id){

        return ResponseEntity.ok(services.buscarUsuarioID(id));
    }

    @Operation(summary = "Atualiza usuario por id")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuario){
        return ResponseEntity.accepted().body(services.autualizarUsuario(id, usuario));
    }

    @Operation(summary = "Deleta usuario por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        services.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
