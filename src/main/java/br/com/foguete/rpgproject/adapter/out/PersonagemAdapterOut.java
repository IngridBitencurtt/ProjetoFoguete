package br.com.foguete.rpgproject.adapter.out;

import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;

import java.util.Optional;

public interface PersonagemAdapterOut {

    String criaPersonagem(Personagem personagem);

    Personagem findPersonagemPorIdEPlayerId(String id, String playerId);

    Optional<PersonagemEntity> findByPersonagemPorPlayerIdENome(String playerId, String nome);

}