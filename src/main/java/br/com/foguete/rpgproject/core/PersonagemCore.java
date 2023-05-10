package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.adapter.in.exception.BusinessException;
import br.com.foguete.rpgproject.adapter.out.PersonagemAdapterOut;
import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonagemCore implements PersonagemPortIn {
    private final PersonagemAdapterOut personagemAdapterOut;

    public PersonagemCore(PersonagemAdapterOut personagemAdapterOut) {
        this.personagemAdapterOut = personagemAdapterOut;
    }


    @Override
    public String creatPersonagem(Personagem personagem) {
        Optional< PersonagemEntity> personagemPorPlayerIdENome = this.personagemAdapterOut.findByPersonagemPorPlayerIdENome(personagem.getIdJogador(),personagem.getNome());
        if (personagemPorPlayerIdENome.isPresent()){
            throw new BusinessException("Personagem " + personagem.getNome() + " Já existe" );
        }
        return this.personagemAdapterOut.criaPersonagem(personagem);
    }

    @Override
    public Personagem findPersonagemPorIdEPlayerId(String id, String playerId) {

        Personagem personagem =  this.personagemAdapterOut.findPersonagemPorIdEPlayerId(id,playerId);

        return personagem;
    }

    @Override
    public void atualizaPersonagem(String id, Personagem personagem) {

        Optional<PersonagemEntity> personagemPorPlayerIdENome =
                this.personagemAdapterOut.findByPersonagemPorPlayerIdENome(personagem.getIdJogador(), personagem.getNome());

        if (personagemPorPlayerIdENome.isEmpty()){
            this.personagemAdapterOut.atualizaPersonagemPorId(id, personagem);
            return;
        }
        if (personagemPorPlayerIdENome.get().getId().equals(id)){
            this.personagemAdapterOut.atualizaPersonagemPorId(id, personagem);
            return;
        }
        throw new BusinessException("Personagem "+ personagemPorPlayerIdENome.get().getName() + " já existe");


    }
}
