package di.configuration;

import di.services.EmailService;
import di.services.MessageInterface;
import di.services.TweeterMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"di.consumer"})
public class DIConfiguration {
    //@Bean
    public MessageInterface getMessageService() {
        return new EmailService();
    }

    @Bean
    public MessageInterface getMessageService1() {
        return new TweeterMessage();
    }
}
