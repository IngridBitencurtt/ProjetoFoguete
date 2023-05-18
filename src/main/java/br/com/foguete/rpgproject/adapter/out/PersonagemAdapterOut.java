package br.com.foguete.rpgproject.adapter.out;

import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;

import java.util.List;
import java.util.Optional;

public interface PersonagemAdapterOut {

    String criaPersonagem(Personagem personagem);

    Personagem findPersonagemPorIdEPlayerId(String id, String playerId);

    Optional<PersonagemEntity> findByPersonagemPorPlayerIdENome(String playerId, String nome);

    void atualizaPersonagemPorId(String id, Personagem personagem);

    void deletePersonagem(String id, String playerId);

    List<PersonagemEntity> findPersonagens(Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, String playerId);
}