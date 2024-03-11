package Service;

import DTO.TransacaoDTO;
import Entidades.Transacao;
import Entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service

public class TransacaoService {
    @Autowired
    private UsuarioService usuarioService;
    //private TransacaoRepository transacaoRepository;
    private RestTemplate restTemplate;


    public boolean autorizarTransacao(Usuario pagador, double valorTransacao) {
        ResponseEntity<Map> respostaAutorizacao = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

        if (respostaAutorizacao.getStatusCode() == HttpStatus.OK) {
             String mensagem = (String) respostaAutorizacao.getBody().get("message");
            return true;
        }else{
            return false;
            }
        }
    public boolean fazerTransacao(TransacaoDTO transacao) throws Exception {
        Usuario pagador = this.usuarioService.findByCpfUsuario(transacao.cpfPagador());
        Usuario destinatario = this.usuarioService.findByCpfUsuario(transacao.cpfDestinatario());

        usuarioService.validarTransacao(pagador, transacao.valorTransacao());

        boolean transacaoAutorizada= this.autorizarTransacao(pagador, transacao.valorTransacao());

        if (transacaoAutorizada){
            throw new Exception("A transação não foi autorizada");
        }
        Transacao novaTransacao = new Transacao();
        novaTransacao.setValorTransacao(transacao.valorTransacao());
        novaTransacao.setPagadorTransacao(pagador);
        novaTransacao.setDestinatarioTransacao(destinatario);

        pagador.setDinheiroUsuario(pagador.getDinheiroUsuario()-(transacao.valorTransacao()));
        destinatario.setDinheiroUsuario(destinatario.getDinheiroUsuario()+(transacao.valorTransacao()));

        return true;
    }
}
