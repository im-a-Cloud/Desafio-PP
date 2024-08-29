package com.DesafioPP.Service;


import com.DesafioPP.DTOS.UsuarioDTO;
import com.DesafioPP.Domain.TipoUsuario;
import com.DesafioPP.Domain.UsuarioClasse;
import com.DesafioPP.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public void validarTransacao(UsuarioClasse usuarioRemetente, BigDecimal valorTransacao) throws Exception {
        if(usuarioRemetente.getTipoUsuario() == TipoUsuario.PADRAO){
            if(usuarioRemetente.getSaldoConta().compareTo(valorTransacao) < 0){
                throw new Exception("Saldo insuficiente na conta");
            }
        }
        else{
            throw new Exception("Usuários do tipo Lojista não podem fazer transação");
        }

    }
    public UsuarioClasse acharUsuarioPeloId(long idUsuario) throws Exception{
        return this.usuarioRepository.findById(idUsuario).orElseThrow(()->new Exception("Usuário não encontrado"));
    }
    public void salvarModificacoesUsuario(UsuarioClasse novoUsuario){
        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioClasse criarNovoUsuario(UsuarioDTO novoUsuario){
        UsuarioClasse usuarioClasse = new UsuarioClasse(novoUsuario);
        this.salvarModificacoesUsuario(usuarioClasse);
        return  usuarioClasse;
    }
    public List<UsuarioClasse> retornaTodosUsuarios(){
        return this.usuarioRepository.findAll();
    }
}
