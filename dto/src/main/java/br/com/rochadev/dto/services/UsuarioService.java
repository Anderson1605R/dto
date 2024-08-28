package br.com.rochadev.dto.services;

import br.com.rochadev.dto.domain.UsuarioDto;
import br.com.rochadev.dto.domain.dto.UsuarioRequest;
import br.com.rochadev.dto.domain.dto.UsuarioResponse;
import br.com.rochadev.dto.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UserRepo userRepo;
    private Converter converter;



    @Autowired
    public UsuarioService(UserRepo userRepo, Converter converter) {
        this.userRepo = userRepo;
        this.converter = converter;

    }

    public UsuarioResponse saveUsuario (UsuarioRequest savedUsuario){
       UsuarioDto usuarioDto = converter.toRequest(savedUsuario);
       UsuarioDto usuarioSavedDTO = userRepo.save(usuarioDto);
       return converter.toResponse(usuarioSavedDTO);
    };
    public List<UsuarioResponse> usuarioResponses (){
        List<UsuarioDto> todosUsuarios = userRepo.findAll();
        List<UsuarioResponse> usuarioResponses = todosUsuarios.stream()
                .map(converter::toResponse)
                .collect(Collectors.toList());

        // Retornar a lista de UsuarioResponse
        return usuarioResponses;
    }
}
