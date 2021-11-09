/*
 * Started a thread named AMQP Connection but has failed to stop it<br>
 * https://stackoverflow.com/questions/69878187/started-a-thread-named-amqp-connection-but-has-failed-to-stop-it
 */
package question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebStart {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebStart.class);
        springApplication.run(args);
    }
}
