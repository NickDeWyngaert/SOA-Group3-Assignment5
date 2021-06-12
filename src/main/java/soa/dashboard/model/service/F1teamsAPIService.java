package soa.dashboard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import soa.dashboard.model.dto.DataF1;
import soa.dashboard.model.dto.F1DTO;

import soa.dashboard.model.dto.OnlyF1Object;
import soa.dashboard.model.entity.F1;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.List;

@Service
public class F1teamsAPIService {

    @Autowired
    private final WebClient f1teamsAPI;

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);
    @Autowired
    public F1teamsAPIService(WebClient f1teamsAPI){ this.f1teamsAPI = f1teamsAPI; }

    public List<F1> read() {
        return this.requestAllF1teams();
    }
    private List requestAllF1teams(){
        return f1teamsAPI
                .get()
                .uri("")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List>() {})
                .block(REQUEST_TIMEOUT);

    }

    public F1 readOne(int id){ return requestOneF1(id); }
    private F1 requestOneF1(int id){
        return f1teamsAPI
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(F1.class)
                .block(REQUEST_TIMEOUT);
    }

    public F1DTO create(F1DTO F1) { return requestCreateF1(F1); }
    private F1DTO requestCreateF1(F1DTO F1){
        return f1teamsAPI
                .post()
                .uri("")
                .body(Mono.just(F1), F1DTO.class)
                .retrieve()
                .bodyToMono(F1DTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public F1DTO update(int id, F1DTO F1) { return requestUpdateF1(id,F1); }
    private F1DTO requestUpdateF1(int id, F1DTO F1){
        return f1teamsAPI
                .put()
                .uri("/" + id)
                .body(Mono.just(F1), F1DTO.class)
                .retrieve()
                .bodyToMono(F1DTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public void delete(int id) { this.requestDeleteF1(id); }
    private void requestDeleteF1(int id){
        f1teamsAPI
                .delete()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(REQUEST_TIMEOUT);
    }

}
