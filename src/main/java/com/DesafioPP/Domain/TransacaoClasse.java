package com.DesafioPP.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "tb_transacoes")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class TransacaoClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransferencia;
    @ManyToOne
    @JoinColumn(name = "id_remetente")

    private UsuarioClasse remetenteTransacao;
    @ManyToOne
    @JoinColumn(name = "id_destinatario")
    private UsuarioClasse destinatarioTransacao;

    private BigDecimal valorTransferencia;

    private LocalDateTime tempoTransacao;

}
