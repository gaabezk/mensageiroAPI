package br.com.mensageiro.repositories;

import br.com.mensageiro.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<UsuarioModel,Long> {

    Optional<UsuarioModel> findByEmail(String email);
    Optional<UsuarioModel> findByNickname(String nickname);

}
