package br.com.rochadev.dto.repository;

import br.com.rochadev.dto.domain.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UsuarioDto,Long> {
}
