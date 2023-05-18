package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.domain.Personagem;

import java.util.List;

public interface PersonagemPortIn {
    String creatPersonagem(Personagem personagem);

    Personagem findPersonagemPorIdEPlayerId(String id, String playerId);

    void atualizaPersonagem(String id, Personagem personagem);

    void deletePersonagem(String id, String playerId);

    List<Personagem> findAllPersonagens(Integer strength, Integer dexterity, Integer constitution, Integer intelligence,
                                        Integer wisdom, Integer charisma, String playerId);
}
