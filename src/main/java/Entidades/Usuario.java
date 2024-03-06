package Entidades;

import jakarta.persistence.*;
import org.hibernate.usertype.UserType;

@Entity
@Table (name = "tb_Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cpfUsuario;
    private String nomeCompleto;
    @Column(unique = true)
    private String emailUsuario;
    private String senhaUsuario;
    private double dinheiroUsuario;
    @Enumerated(EnumType.STRING)
    private UserType tipoUsuario;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(int cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public double getDinheiroUsuario() {
        return dinheiroUsuario;
    }

    public void setDinheiroUsuario(double dinheiroUsuario) {
        this.dinheiroUsuario = dinheiroUsuario;
    }

}
