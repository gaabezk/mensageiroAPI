package br.com.mensageiro.repositories;

import br.com.mensageiro.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<UsuarioModel,Long> {
}
