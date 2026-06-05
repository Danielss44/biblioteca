package com.example.biblioteca.services;

import com.example.biblioteca.dto.UsuarioRequestDTO;
import com.example.biblioteca.dto.UsuarioResponseDTO;
import com.example.biblioteca.exception.UsuarioJaExiste;
import com.example.biblioteca.exception.UsuarioNotFoundException;
import com.example.biblioteca.infra.entity.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServices {
    @Autowired
    private final UsuarioRepository repository;

    private UsuarioResponseDTO toDTO(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getEmail()
        );
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();

        usuario.setLogin(dto.getLogin());
        usuario.setEmail(dto.getEmail());

        if(repository.existsByLogin(dto.getLogin())){
            throw new UsuarioJaExiste("Usuário já cadastrado");
        }
        return toDTO(repository.save(usuario));
    }

    public List<UsuarioResponseDTO> listarUsuarios(){
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

    }

    public UsuarioResponseDTO buscarUsuarioID(Long id){
                Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encrontado"));
        return toDTO(usuario);
    }


    public UsuarioResponseDTO autualizarUsuario(Long id, UsuarioRequestDTO dto){
        Usuario usuario = repository.findById(id).orElseThrow(()-> new UsuarioNotFoundException("Usuário não encrontado"));

            usuario.setLogin(dto.getLogin());
            usuario.setEmail(dto.getEmail());
            return toDTO(repository.save(usuario));

    }

    public void deletarUsuario(Long id){
        if (!repository.existsById(id)){

            throw new UsuarioNotFoundException("Usuário não encrontado");

        }
        repository.deleteById(id);
    }

}
