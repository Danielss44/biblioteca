package com.example.biblioteca.services;

import com.example.biblioteca.dto.EmprestimoRequestDTO;
import com.example.biblioteca.dto.EmprestimoResponseDTO;
import com.example.biblioteca.exception.EmprestimoNotFound;
import com.example.biblioteca.exception.LivroIndisponivelException;
import com.example.biblioteca.exception.LivroNotFoundException;
import com.example.biblioteca.exception.UsuarioNotFoundException;
import com.example.biblioteca.infra.entity.Emprestimo;
import com.example.biblioteca.infra.entity.Livro;
import com.example.biblioteca.infra.entity.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoServices {


    private final EmprestimoRepository emprestimoRepository;

    private final UsuarioRepository usuarioRepository;

    private final LivroRepository livroRepository;

    public EmprestimoResponseDTO criarEmprestimo(EmprestimoRequestDTO dto){
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioid()).orElseThrow(() -> new UsuarioNotFoundException("Usuario não encrontado"));

        Livro livro = livroRepository.findById(dto.getLivroid()).orElseThrow(() -> new LivroNotFoundException("Livro não encrontado"));

        if(!livro.getDisp()){
            throw new LivroIndisponivelException("Livro indisponivel");
        }

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());

        livro.setDisp(false);
        livroRepository.save(livro);

        emprestimoRepository.save(emprestimo);

        return new EmprestimoResponseDTO(
                emprestimo.getId(),
                emprestimo.getUsuario(),
                emprestimo.getLivro(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }

    public EmprestimoResponseDTO devolver(Long id){
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new EmprestimoNotFound("Empréstimo não encrontado"));

        emprestimo.setDataDevolucao(LocalDate.now());

        Livro livro = emprestimo.getLivro();
        livro.setDisp(true);

        livroRepository.save(livro);

        emprestimoRepository.save(emprestimo);

        return new EmprestimoResponseDTO(
                emprestimo.getId(),
                emprestimo.getUsuario(),
                emprestimo.getLivro(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }

    public List<EmprestimoResponseDTO> listarTodos(){

        return emprestimoRepository.findAll()
                .stream()
                .map(emprestimo -> new EmprestimoResponseDTO(
                        emprestimo.getId(),
                        emprestimo.getUsuario(),
                        emprestimo.getLivro(),
                        emprestimo.getDataEmprestimo(),
                        emprestimo.getDataDevolucao()
                ))
                .toList();
    }

    
}
