package br.com.foguete.rpgproject.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonagemDto {

    @NotBlank
    private String name;

    @NotBlank
    private String race;

    @Min(1)
    @Max(20)
    private Integer strength;

    @Min(1)
    @Max(20)
    private Integer dexterity;

    @Min(1)
    @Max(20)
    private Integer constitution;

    @Min(1)
    @Max(20)
    private Integer intelligence;

    @Min(1)
    @Max(20)
    private Integer wisdom;

    @Min(1)
    @Max(20)
    private Integer charisma;

    public String getName() {
        return name;
    }

    public PersonagemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getRace() {
        return race;
    }

    public PersonagemDto setRace(String race) {
        this.race = race;
        return this;
    }

    public Integer getStrength() {
        return strength;
    }

    public PersonagemDto setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public PersonagemDto setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public PersonagemDto setConstitution(Integer constitution) {
        this.constitution = constitution;
        return this;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public PersonagemDto setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public PersonagemDto setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
        return this;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public PersonagemDto setCharisma(Integer charisma) {
        this.charisma = charisma;
        return this;
    }
}
