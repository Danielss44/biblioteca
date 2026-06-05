package com.example.biblioteca.services;

import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.dto.UsuarioResponseDTO;
import com.example.biblioteca.exception.LivroNotFoundException;
import com.example.biblioteca.infra.entity.Livro;
import com.example.biblioteca.infra.entity.Usuario;
import com.example.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroServices {


    private final LivroRepository repository;

    private LivroResponseDTO toDTO(Livro livro){
        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getDisp()
        );
    }

    public List<LivroResponseDTO> listarTodos(){
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }


    public LivroResponseDTO salvarLivro(LivroRequestDTO dto){
        Livro livro =new Livro();

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setDisp(true);

        if (repository.existsByTitulo(livro.getTitulo())){
            throw new RuntimeException("Livro já cadastrado");
        }

        return toDTO(repository.save(livro));
    }

    public LivroResponseDTO buscarID(Long id){
        Livro livro = repository.findById(id).orElseThrow(() -> new LivroNotFoundException("Livro não encrontado"));
        return toDTO(livro);
    }

    public LivroResponseDTO atualizarLivro(Long id,LivroRequestDTO dto){
        Livro livro = repository.findById(id).orElseThrow(() -> new LivroNotFoundException("Livro não encrotnado"));

            livro.setTitulo(dto.getTitulo());
            livro.setAutor(dto.getAutor());
            return toDTO(repository.save(livro));

    }

    public void deletarLivro(Long id){
        repository.deleteById(id);
    }

}
