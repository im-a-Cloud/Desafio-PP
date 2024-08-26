package com.DesafioPP.Repository;

import com.DesafioPP.Domain.UsuarioClasse;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioClasse, Long> {

    Optional<UsuarioClasse> findByDocumentoUsuario(String documentoUsuario);
}
