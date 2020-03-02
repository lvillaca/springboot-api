package luis.sample.service;

import luis.sample.dados.Funcionario;
import luis.sample.repository.FuncionarioRepository;
import luis.sample.repository.primary.FuncionarioPrimaryRepository;
import luis.sample.repository.secondary.FuncionarioSecondaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Optional;

/**
 * @author Luis
 */
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioPrimaryRepository funcionarioPrimaryRepository;

    @Autowired
    private FuncionarioSecondaryRepository funcionarioSecondaryRepository;

    boolean isPrimary = true;
 
    private Object pullRepositoryRoundRobin() {
        if (isPrimary) {
            isPrimary = false;
            return funcionarioPrimaryRepository;
        } else {
            isPrimary = true;
            return funcionarioSecondaryRepository;
        }
    }

    @Cacheable(value = "Funcionario", key="#login")
    public Optional<Funcionario> findFuncionarioByLogin(String login) {

       return ((FuncionarioRepository)pullRepositoryRoundRobin()).findByLogin(login);
    }

    @Scheduled(fixedRate = 20000)
    @CacheEvict(value = "Funcionario", allEntries = true)
    public void expireFuncionarioCache() { }

}



