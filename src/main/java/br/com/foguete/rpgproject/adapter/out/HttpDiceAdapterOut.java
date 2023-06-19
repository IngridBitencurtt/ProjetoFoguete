package br.com.foguete.rpgproject.adapter.out;

import br.com.foguete.rpgproject.adapter.in.dto.DadoDto;
import br.com.foguete.rpgproject.adapter.in.dto.DiceDto;
import br.com.foguete.rpgproject.domain.Dado;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpDiceAdapterOut implements DiceAdapterOut{

    private final RestTemplate restTemplate;

    public HttpDiceAdapterOut(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    public Integer getResult(Dado dado) {

        String uriString = "http://localhost:8082/dice/v1/result";
        DiceDto dadoDto = new DiceDto();
        dadoDto.setDice(dado);
        HttpEntity<DiceDto> body = new HttpEntity(dadoDto);
        ResponseEntity<DadoDto> exchange = restTemplate.exchange(uriString,
                HttpMethod.POST,
                body,
                new ParameterizedTypeReference<>() {
                });

        return exchange.getBody().getResult();

    }
}
