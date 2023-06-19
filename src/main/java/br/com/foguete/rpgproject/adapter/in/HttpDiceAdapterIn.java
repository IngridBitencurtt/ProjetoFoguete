package br.com.foguete.rpgproject.adapter.in;

import br.com.foguete.rpgproject.adapter.in.dto.DadoDto;
import br.com.foguete.rpgproject.core.DadoPortIn;
import br.com.foguete.rpgproject.domain.Dado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rpg/v1/dice")
public class HttpDiceAdapterIn {
    public final DadoPortIn dadoPortIn;

    public HttpDiceAdapterIn(DadoPortIn dadoPortIn) {
        this.dadoPortIn = dadoPortIn;
    }

    @GetMapping
    public ResponseEntity<DadoDto> getResultado(@RequestParam("dice") Dado dado) {
        Integer result = this.dadoPortIn.getDiceResult(dado);

        DadoDto dadoDto = new DadoDto(result);

        return ResponseEntity.ok().body(dadoDto);
    }

}
