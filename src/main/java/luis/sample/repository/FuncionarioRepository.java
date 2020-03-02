package luis.sample.repository;

import luis.sample.dados.Funcionario;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FuncionarioRepository  {
    Optional<Funcionario> findByLogin(@Param("login_param") String login);
}

