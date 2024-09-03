package com.DesafioPP.Controller;

import com.DesafioPP.DTOS.TransacaoDTO;
import com.DesafioPP.Domain.TransacaoClasse;
import com.DesafioPP.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transacao")

public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoClasse> fazerTransacao(@RequestBody TransacaoDTO novaTransacao) throws Exception{
        TransacaoClasse transacao = this.transacaoService.realizarTransacao(novaTransacao);
        return new ResponseEntity<>(transacao, HttpStatus.OK);

    }
}
