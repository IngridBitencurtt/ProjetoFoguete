package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.domain.Personagem;

public class PersonagemCore {
    public void criacaoPersonagem(){
        Personagem personagem = new Personagem()
                .setNome("Jinx")
                .setRaca("maluca")
                .setNomeJogador("Ingrid")
                .setForca(10)
                .setDestreza(10)
                .setConstituicao(10)
                .setInteligencia(10)
                .setSabedoria(10)
                .setCarisma(10);


        Personagem personagem2 = new Personagem(
                  "Vi"
                , "lutadora"
                , "Ingrid"
                , 10
                , 10
                , 10
                , 10
                , 10
                , 10 );

        Personagem personagem3 = new Personagem();
        personagem3.setNome("Caitilyn");
        personagem3.setRaca("Policial");
        personagem3.setNomeJogador("Ingrid");
        personagem3.setForca(10);
        personagem3.setDestreza(10);
        personagem3.setConstituicao(10);
        personagem3.setInteligencia(10);
        personagem3.setSabedoria(10);
        personagem3.setCarisma(10);


    }
}
