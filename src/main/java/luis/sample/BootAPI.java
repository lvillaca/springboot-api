package luis.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.Filter;

/**
 * Classe principal SpringBoot.
 * @author Luis
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class BootAPI  {

    private static final Logger logger = LoggerFactory.getLogger(BootAPI.class);

    /**
     * Define Filtro para codigo de caracteres.
     * @return objeto Filter
     */
    @Bean
    public Filter getCharacterEncodingFilter() {

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        return encodingFilter;

    }

    /**
     * Sobe o SpringBoot.
     * @param args
     */
    //classe principal do main
    public static void main(String[] args) {
        SpringApplication.run(BootAPI.class, args);
    }


}
