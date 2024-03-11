package Entidades;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransacao;
    private double valorTransacao;
    @ManyToOne
    @JoinColumn(name="pagador_id")
    private Usuario pagadorTransacao;
    @ManyToOne
    @JoinColumn(name="destinatario_id")
    private Usuario destinatarioTransacao;

    public long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public Usuario getPagadorTransacao() {
        return pagadorTransacao;
    }

    public void setPagadorTransacao(Usuario pagadorTransacao) {
        this.pagadorTransacao = pagadorTransacao;
    }

    public Usuario getDestinatarioTransacao() {
        return destinatarioTransacao;
    }

    public void setDestinatarioTransacao(Usuario destinatarioTransacao) {
        this.destinatarioTransacao = destinatarioTransacao;
    }
}
