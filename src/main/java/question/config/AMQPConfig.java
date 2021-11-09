package question.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

    @Bean
    Queue queue() {
        return new Queue("QUEUE_USER_NOTIFY", false);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("EVENT_BUS_EXCHANGE");
    }

    @Bean
    public Binding bindForUserNotify(FanoutExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
