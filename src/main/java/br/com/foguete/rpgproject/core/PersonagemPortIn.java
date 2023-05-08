package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.domain.Personagem;

public interface PersonagemPortIn {
    String creatPersonagem(Personagem personagem);

    Personagem findPersonagemPorIdEPlayerId(String id, String playerId);

    void atualizaPersonagem(String id, Personagem personagem);
}
