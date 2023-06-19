package br.com.foguete.rpgproject.domain;

import br.com.foguete.rpgproject.core.DadoCore;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;

public class Personagem {

    private String nome;
    private Raca raca;
    private String idJogador;
    private Integer forca;
    private Integer destreza;
    private Integer constituicao;
    private Integer inteligencia;
    private Integer sabedoria;
    private Integer carisma;

    public Personagem(String nome, Raca raca, String idJogador, Integer forca, Integer destreza, Integer constituicao, Integer inteligencia, Integer sabedoria, Integer carisma) {
        this.nome = nome;
        this.raca = raca;
        this.idJogador = idJogador;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

    public Personagem() {
    }

    public static Personagem randomPersonagem(String name, String playerId){
        return  new Personagem(name,
                Raca.HUMANO,
                playerId,
                randomProperty(),
                randomProperty(),
                randomProperty(),
                randomProperty(),
                randomProperty(),
                randomProperty());
    }

    public static Integer randomProperty(){

        return  (int) (Math.random() * 20) + 1;
    }





    public String getNome() {
        return nome;
    }

    public Personagem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Raca getRaca() {
        return raca;
    }

    public Personagem setRaca(Raca raca) {
        this.raca = raca;
        return this;
    }

    public String getIdJogador() {
        return idJogador;
    }

    public Personagem setIdJogador(String idJogador) {
        this.idJogador = idJogador;
        return this;
    }

    public Integer getForca() {
        return forca;
    }

    public Personagem setForca(Integer forca) {
        this.forca = forca;
        return this;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public Personagem setDestreza(Integer destreza) {
        this.destreza = destreza;
        return this;
    }

    public Integer getConstituicao() {
        return constituicao;
    }

    public Personagem setConstituicao(Integer constituicao) {
        this.constituicao = constituicao;
        return this;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public Personagem setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
        return this;
    }

    public Integer getSabedoria() {
        return sabedoria;
    }

    public Personagem setSabedoria(Integer sabedoria) {
        this.sabedoria = sabedoria;
        return this;
    }

    public Integer getCarisma() {
        return carisma;
    }

    public Personagem setCarisma(Integer carisma) {
        this.carisma = carisma;
        return this;
    }


    public static Personagem from(PersonagemEntity personagemEntity) {
        return new Personagem()
                .setNome(personagemEntity.getName())
                .setRaca(Raca.byValue(personagemEntity.getRace()))
                .setIdJogador(personagemEntity.getPlayer())
                .setForca(personagemEntity.getStrength())
                .setDestreza(personagemEntity.getDexterity())
                .setConstituicao(personagemEntity.getConstitution())
                .setInteligencia(personagemEntity.getIntelligence())
                .setSabedoria(personagemEntity.getWisdom())
                .setCarisma(personagemEntity.getCharisma());
    }
}
