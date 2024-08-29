package com.DesafioPP.DTOS;

import com.DesafioPP.Domain.TipoUsuario;

import java.math.BigDecimal;

public record UsuarioDTO(String nomeCompleto, String documentoUsuario, String emailUsuario, String senhaUsuario, BigDecimal saldoUsuario, TipoUsuario tipoUsuario) {
}
