package br.com.foguete.rpgproject.adapter.out;

import br.com.foguete.rpgproject.domain.Personagem;

public interface PersonagemAdapterOut {

    String criaPersonagem(Personagem personagem);

    Personagem findPersonagemPorIdEPlayerId(String id, String playerId);
}
