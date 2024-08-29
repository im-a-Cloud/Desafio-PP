package com.DesafioPP.Controller;

import com.DesafioPP.DTOS.UsuarioDTO;
import com.DesafioPP.Domain.UsuarioClasse;
import com.DesafioPP.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioClasse> criarUsuario(@RequestBody UsuarioDTO novoUsuario ){
        UsuarioClasse usuarioClasse = usuarioService.criarNovoUsuario(novoUsuario);
        return new ResponseEntity<>(usuarioClasse, HttpStatus.CREATED);
    }
    @GetMapping

    public List<UsuarioClasse> retornarUsuarios(){
        return usuarioService.retornaTodosUsuarios();
    }
}
