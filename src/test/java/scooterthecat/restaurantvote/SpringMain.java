package scooterthecat.restaurantvote;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {

        public static void main(String[] args) {
            System.setProperty("spring.profiles.active","postgres");
            try(ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml"))
            {
                System.out.println("Bean definition names: " + Arrays.toString(ctx.getBeanDefinitionNames()));
            }
        }
}
