package luis.sample.dados;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe para Fucionario
 * @author Luis
 */
@Entity
public class Funcionario implements Serializable {
    @Id
    @Column(name = "login", nullable = false)
    String login;
    @Column(name = "cargo", nullable = false)
    String cargo;
    @Column(name = "matricula", nullable = false)
    String matricula;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "funcao", nullable = false)
    String funcao;
    @Column(name = "lotacao", nullable = false)
    String lotacao;
    @Column(name = "nomecompleto", nullable = false)
    String nomeCompleto;
    @Column(name = "empresa", nullable = false)
    String empresa;

    public String getLogin() {
        return login;
    }

    public String getCargo() {
        return cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getLotacao() {
        return lotacao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmpresa() {
        return empresa;
    }
}
