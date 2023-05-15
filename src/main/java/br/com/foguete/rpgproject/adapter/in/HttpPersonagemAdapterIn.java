package br.com.foguete.rpgproject.adapter.in;

import br.com.foguete.rpgproject.adapter.in.dto.PersonagemDto;
import br.com.foguete.rpgproject.core.PersonagemPortIn;
import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.PersonagemRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public  ResponseEntity<String> createPersonagem(@RequestBody @Valid PersonagemDto personagemDto,
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

        String idPersonagem = this.personagemPortIn.creatPersonagem(personagem);

        return  ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idPersonagem).toUri()).build();
    }
    //Criar uma rota GET dado um id
    //onde será retornado o personagem criado
    //regra 1 - só retornar o personagem do player-id correspondente
    //regra 1.1 - caso não encontre retornar 404 (not found) com body vazio
    //regra 2 - caso encontre, retornar informações do personagem, sem retornar player-id, id do banco, sem data atualizacao ou criacao, status 200.
    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDto> findPersonagemPortIn(@PathVariable("id") String id,
                                                              @RequestHeader(name = "player-id", required = true)String playerId){

        return ResponseEntity.ok(PersonagemDto.from(this.personagemPortIn.findPersonagemPorIdEPlayerId(id, playerId)));
    }


    //Criar rota PUT, dado um id onde o personagem será atualizado
    // regra 1 - só retornar o personagem do player-id correspondente
    // regra 1.1 - caso não encontre retornar 404 (not found) com body vazio
    // regra 1.2 - não atualizar personagem com o mesmo nome de outro personagem já salvo na base, do mesmo playerId, retornando 422
    // regra 2 - caso encontre, atualizar todos os valores do personagem
    // regra 3 - retornar status 204, no_content, sem body.
    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDto> atualizaPersonagem(@RequestBody @Valid PersonagemDto personagemDto,
                                                   @PathVariable("id") String id,
                                                   @RequestHeader(name = "player-id", required = true)String playerId){
        Personagem personagem = new Personagem(personagemDto.getName()
                ,personagemDto.getRace()
                ,playerId
                ,personagemDto.getStrength()
                ,personagemDto.getDexterity()
                ,personagemDto.getConstitution()
                ,personagemDto.getIntelligence()
                ,personagemDto.getWisdom()
                ,personagemDto.getCharisma());

        this.personagemPortIn.atualizaPersonagem(id, personagem);

        return ResponseEntity.noContent().build();

}
//    Criar rota DELETE recebendo o id do personagem, e o playerId - ok
//    regra 1 - buscar o personagem no repositorio - ok
//    regra 1.1 - caso não exista retornar 404 - ok
//    regra 2 - deletar o personagem
//    regra 3 - em caso de sucesso, retornar status 204, no_content, e body vazio - ok
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonagemDto> deletaPersonagem(@PathVariable("id") String id,
                                                          @RequestHeader(name = "player-id", required = true) String playerId) {

        this.personagemPortIn.deletePersonagem(id, playerId);


        return ResponseEntity.noContent().build();
    }








}
