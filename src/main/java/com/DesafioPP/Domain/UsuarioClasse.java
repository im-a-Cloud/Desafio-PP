package com.DesafioPP.Domain;

import com.DesafioPP.DTOS.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Table (name = "tb_Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public UsuarioClasse(UsuarioDTO usuarioDTO){
        this.nomeCompleto = usuarioDTO.nomeCompleto();
        this.documentoUsuario = usuarioDTO.documentoUsuario();
        this.emailUsuario = usuarioDTO.emailUsuario();
        this.senhaUsuario = usuarioDTO.senhaUsuario();
        this.saldoConta = usuarioDTO.saldoUsuario();
        this.tipoUsuario = usuarioDTO.tipoUsuario();
    }
}
