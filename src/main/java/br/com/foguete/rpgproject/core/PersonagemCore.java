package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.adapter.out.PersonagemAdapterOut;
import br.com.foguete.rpgproject.domain.Personagem;
import org.springframework.stereotype.Service;

@Service
public class PersonagemCore implements PersonagemPortIn {
    private final PersonagemAdapterOut personagemAdapterOut;

    public PersonagemCore(PersonagemAdapterOut personagemAdapterOut) {
        this.personagemAdapterOut = personagemAdapterOut;
    }


    @Override
    public String creatPersonagem(Personagem personagem) {
        return this.personagemAdapterOut.criaPersonagem(personagem);
    }

    @Override
    public Personagem findPersonagemPorIdEPlayerId(String id, String playerId) {

        Personagem personagem =  this.personagemAdapterOut.findPersonagemPorIdEPlayerId(id,playerId);

        return personagem;
    }
}
