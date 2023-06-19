package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.adapter.in.exception.BusinessException;
import br.com.foguete.rpgproject.adapter.out.PersonagemAdapterOut;
import br.com.foguete.rpgproject.domain.Dado;
import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.domain.Raca;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonagemCore implements PersonagemPortIn {
    private final PersonagemAdapterOut personagemAdapterOut;
    private final DadoPortIn dadoPortIn;

    public PersonagemCore(PersonagemAdapterOut personagemAdapterOut, DadoPortIn dadoPortIn) {
        this.personagemAdapterOut = personagemAdapterOut;
        this.dadoPortIn = dadoPortIn;
    }


    @Override
    public String creatPersonagem(Personagem personagem) {
        Optional<PersonagemEntity> personagemPorPlayerIdENome = this.personagemAdapterOut.findByPersonagemPorPlayerIdENome(personagem.getIdJogador(),personagem.getNome());
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

    @Override
    public void deletePersonagem(String id, String playerId) {

        this.personagemAdapterOut.deletePersonagem(id, playerId);


    }

    @Override
    public List<Personagem> findAllPersonagens(Integer strength, Integer dexterity, Integer constitution, Integer intelligence,
                                               Integer wisdom, Integer charisma, String playerId) {

        List<PersonagemEntity> personagemEntityList = this.personagemAdapterOut.findPersonagens(strength, dexterity,
                constitution, intelligence, wisdom, charisma, playerId);

        List<Personagem> personagemList = new ArrayList<>();

        for (PersonagemEntity personagemEntity : personagemEntityList) {
            Personagem personagem = Personagem.from(personagemEntity);
            personagemList.add(personagem);
        }

        return personagemList;
    }

    public String createRandom(Personagem personagem) {

        personagem.setCarisma(dadoPortIn.getDiceResult(Dado.D20))
                .setForca(dadoPortIn.getDiceResult(Dado.D20))
                .setDestreza(dadoPortIn.getDiceResult(Dado.D20))
                .setConstituicao(dadoPortIn.getDiceResult(Dado.D20))
                .setInteligencia(dadoPortIn.getDiceResult(Dado.D20))
                .setSabedoria(dadoPortIn.getDiceResult(Dado.D20))
                .setRaca(Raca.randomRaca());

        return this.creatPersonagem(personagem);
    }
}
