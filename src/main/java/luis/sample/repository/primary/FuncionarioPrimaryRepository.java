package luis.sample.repository.primary;

import luis.sample.dados.Funcionario;
import luis.sample.repository.FuncionarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioPrimaryRepository extends JpaRepository<Funcionario, String>, FuncionarioRepository {
    @Query(value="SELECT login, cargo, empresa, nomecompleto, matricula, IFNULL(email, ' ') as email,  funcao, lotacao FROM trabalhador  where login =:login_param",
           nativeQuery = true)
    Optional<Funcionario> findByLogin(@Param("login_param") String login);
}

