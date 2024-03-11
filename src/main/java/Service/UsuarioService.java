package Service;

import Entidades.Usuario;
import Entidades.TipoUsuario;
import Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void validarTransacao(Usuario usuarioPagador, double valorPago ) throws Exception {
        if (usuarioPagador.getTipoUsuario() == TipoUsuario.LOJISTA) {
            throw new Exception("Lojistas não podem enviar dinheiro, apenas receber");
        }
        if (usuarioPagador.getDinheiroUsuario() < valorPago){
            throw new Exception("O usuário não possui saldo o suficiente para realizar a transação");
        }
    }
    public Usuario findByCpfUsuario(int cpfUsuario) throws Exception{
        return this.usuarioRepository.findByCpfUsuario(cpfUsuario).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
    public void criarUsuario(Usuario novoUsuario){
        this.usuarioRepository.save(novoUsuario);
    }
}
