package com.DesafioPP.Service;

import com.DesafioPP.DTOS.TransacaoDTO;
import java.time.LocalDateTime;
import java.util.Map;

import com.DesafioPP.Domain.TransacaoClasse;
import com.DesafioPP.Domain.UsuarioClasse;
import com.DesafioPP.Repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TransacaoService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificacaoService;

    public TransacaoClasse realizarTransacao(TransacaoDTO novaTransacao) throws Exception {
        UsuarioClasse remetente = this.usuarioService.acharUsuarioPeloId(novaTransacao.idRemetente());
        UsuarioClasse destinatario = this.usuarioService.acharUsuarioPeloId(novaTransacao.idDestinatario());

        usuarioService.validarTransacao(remetente, novaTransacao.valorTransferencia());

        if (!autorizarTransacao(remetente, novaTransacao.valorTransferencia())) {
            throw new Exception("Transação não autorizada");
        } else {
            TransacaoClasse transacaoNova = new TransacaoClasse();
            transacaoNova.setDestinatarioTransacao(destinatario);
            transacaoNova.setRemetenteTransacao(remetente);
            transacaoNova.setValorTransferencia(novaTransacao.valorTransferencia()); // Corrigido aqui
            transacaoNova.setTempoTransacao(LocalDateTime.now());

            remetente.setSaldoUsuario(remetente.getSaldoUsuario().subtract(novaTransacao.valorTransferencia()));
            destinatario.setSaldoUsuario(destinatario.getSaldoUsuario().add(novaTransacao.valorTransferencia()));

            // Salvar a transação no repositório
            this.transacaoRepository.save(transacaoNova);
            this.usuarioService.salvarModificacoesUsuario(remetente);
            this.usuarioService.salvarModificacoesUsuario(destinatario);

            this.notificacaoService.enviarNotificacao(remetente,"Transação feita");
            this.notificacaoService.enviarNotificacao(destinatario,"Transação recebida");

            return transacaoNova;

        }
    }

    public boolean autorizarTransacao(UsuarioClasse usuarioRemetente, BigDecimal valorTransacao) {
        ResponseEntity<java.util.Map> respostaRequisicao = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", java.util.Map.class);

        if (respostaRequisicao.getStatusCode() == HttpStatus.OK) {
            String mensagem = (String) respostaRequisicao.getBody().get("status");
            return "success".equalsIgnoreCase(mensagem);
        } else {
            return false;
        }
    }
}
