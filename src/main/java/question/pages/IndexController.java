package question.pages;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private FanoutExchange exchange;

    @RequestMapping(value = "/")
    public ModelAndView render() {
        return new ModelAndView("index");
    }

    /**
     * After I send the message using the following code<br>
     * An error message will appear when trying to stop the application.<br>
     * <code>a thread named [AMQP Connection 127.0.0.1:5672] but has failed to stop it</code>
     *
     * @return
     */
    @RequestMapping(value = "/send")
    public ModelAndView sendMessage() {
        template.convertAndSend(exchange.getName(), "Hello world".getBytes());
        return new ModelAndView("index");
    }

}
