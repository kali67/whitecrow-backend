package whitecrow

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration

@SpringBootApplication(exclude = [HibernateJpaAutoConfiguration::class]) // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}