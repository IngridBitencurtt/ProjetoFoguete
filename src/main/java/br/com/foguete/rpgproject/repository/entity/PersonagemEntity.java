package br.com.foguete.rpgproject.repository.entity;

import br.com.foguete.rpgproject.domain.Personagem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.Instant;

@Document(collection = "rpg-personagens")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String race;
    private String player;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Instant createdAt;
    private Instant updatedAt;

    public PersonagemEntity() {}

    public static PersonagemEntity personagemEntity(Personagem personagem){
        return new PersonagemEntity()
                .setName(personagem.getNome())
                .setRace(personagem.getRaca())
                .setPlayer(personagem.getNomeJogador())
                .setStrength(personagem.getForca())
                .setDexterity(personagem.getDestreza())
                .setConstitution(personagem.getConstituicao())
                .setIntelligence(personagem.getInteligencia())
                .setWisdom(personagem.getSabedoria())
                .setCharisma(personagem.getCarisma());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public PersonagemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getRace() {
        return race;
    }

    public PersonagemEntity setRace(String race) {
        this.race = race;
        return this;
    }

    public String getPlayer() {
        return player;
    }

    public PersonagemEntity setPlayer(String player) {
        this.player = player;
        return this;
    }

    public Integer getStrength() {
        return strength;
    }

    public PersonagemEntity setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public PersonagemEntity setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public PersonagemEntity setConstitution(Integer constitution) {
        this.constitution = constitution;
        return this;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public PersonagemEntity setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public PersonagemEntity setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
        return this;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public PersonagemEntity setCharisma(Integer charisma) {
        this.charisma = charisma;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public PersonagemEntity setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public PersonagemEntity setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
