package soa.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }

    /*
    Example WebClient
    https://howtodoinjava.com/spring-webflux/webclient-get-post-example/
     */
    @Bean
    public WebClient moviesAPI(){ return WebClient.create("http://localhost:8290/movies"); }

    @Bean
    public WebClient productsAPI(){ return WebClient.create("http://localhost:8290/products"); }

    @Bean
    public WebClient todolistAPI(){ return WebClient.create("http://localhost:8290/todoitems"); }

    @Bean
    public WebClient f1teamsAPI(){ return WebClient.create("http://localhost:8290/f1_teams"); }
}
