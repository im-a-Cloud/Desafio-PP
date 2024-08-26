package com.DesafioPP.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Table (name = "tb_Usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class UsuarioClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nomeCompleto;
    @Column(unique = true)
    private String documentoUsuario;
    @Column(unique = true)
    private String emailUsuario;

    private String senhaUsuario;

    private BigDecimal saldoConta;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
