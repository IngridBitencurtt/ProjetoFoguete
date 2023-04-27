package br.com.foguete.rpgproject.adapter.in;

import br.com.foguete.rpgproject.adapter.in.dto.PersonagemDto;
import br.com.foguete.rpgproject.core.PersonagemPortIn;
import br.com.foguete.rpgproject.domain.Personagem;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rpg/v1/personagem")
public class HttpPersonagemAdapterIn {

    public final PersonagemPortIn personagemPortIn;

    public HttpPersonagemAdapterIn(PersonagemPortIn personagemPortIn) {
        this.personagemPortIn = personagemPortIn;
    }

    @GetMapping
    public ResponseEntity<List<PersonagemDto>> findAllPersonagem() {
        return ResponseEntity.ok().build();

    }

    @PostMapping
    public  ResponseEntity<PersonagemDto> createPersonagem(@RequestBody @Valid PersonagemDto personagemDto,
                                                           @RequestHeader(name = "player-id") String playerId){
        Personagem personagem = new Personagem(personagemDto.getName()
                ,personagemDto.getRace()
                ,playerId
                ,personagemDto.getStrength()
                ,personagemDto.getDexterity()
                ,personagemDto.getConstitution()
                ,personagemDto.getIntelligence()
                ,personagemDto.getWisdom()
                ,personagemDto.getCharisma());

        String id = this.personagemPortIn.creatPersonagem(personagem);


        return  ResponseEntity.created(personagemDto);
    }

}
