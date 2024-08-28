package br.com.rochadev.dto.services;

import br.com.rochadev.dto.domain.UsuarioDto;
import br.com.rochadev.dto.domain.dto.UsuarioRequest;
import br.com.rochadev.dto.domain.dto.UsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Converter {
    public  UsuarioDto toRequest(UsuarioRequest usuarioRequest){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNome(usuarioRequest.nome());
        usuarioDto.setEmail(usuarioRequest.email());
        usuarioDto.setSenha(usuarioRequest.senha());
        return usuarioDto;
    }
    public  UsuarioResponse toResponse(UsuarioDto usuarioDto){
      return new UsuarioResponse(usuarioDto.getNome(), usuarioDto.getEmail());

    }

}
