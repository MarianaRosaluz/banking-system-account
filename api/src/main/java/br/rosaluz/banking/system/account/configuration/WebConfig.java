package br.rosaluz.banking.system.account.configuration;

import br.rosaluz.banking.system.account.dto.AccountToAccountDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new AccountToAccountDTO());
    }
}
