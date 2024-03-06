package Entidades;

import jakarta.persistence.*;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransacao;
    private double valorTransacao;
    @ManyToOne
    private Usuario pagadorTransacao;
    @ManyToOne
    private Usuario destinatarioTransacao;
}
