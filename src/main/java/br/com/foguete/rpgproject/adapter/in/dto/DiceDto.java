package br.com.foguete.rpgproject.adapter.in.dto;

import br.com.foguete.rpgproject.domain.Dado;

public class DiceDto {
    private Dado dice;

    public DiceDto() {
    }

    public Dado getDice() {
        return dice;
    }

    public DiceDto setDice(Dado dice) {
        this.dice = dice;
        return this;
    }
}
