package luis.sample;


import luis.sample.dados.Funcionario;
import luis.sample.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Classe relativa ao servico de consumo dos GraphQLs.
 * @author Luis
 */

@RestController
//@Component
public class RestAPIController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionario/{login}")
    public Optional<Funcionario> findFuncionarioByLogin(@PathVariable String login){
        return funcionarioService.findFuncionarioByLogin(login);
    }

}

