package com.DesafioPP.Service;

import com.DesafioPP.DTOS.NotificacaoDTO;
import com.DesafioPP.Domain.UsuarioClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;


    public void enviarNotificacao(UsuarioClasse usuarioClasse, String mensagem)throws Exception {
        String email = usuarioClasse.getEmailUsuario();
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO(email, mensagem);

       /* ResponseEntity<String> notificacaoRepsosta = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify",notificacaoDTO, String.class);
        if (!(notificacaoRepsosta.getStatusCode() == HttpStatus.OK)){
            System.out.println("deu ruim");
            throw new Exception("Serviço de notificação fora do ar");
        }
    }
    */
        System.out.println("Transação feita com sucesso");
    }
}
