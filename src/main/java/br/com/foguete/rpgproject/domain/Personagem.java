package br.com.foguete.rpgproject.domain;

public class Personagem {
    private String nome;
    private String raca;
    private String nomeJogador;
    private Integer forca;
    private Integer destreza;
    private Integer constituicao;
    private Integer inteligencia;
    private Integer sabedoria;
    private Integer carisma;

    public Personagem(String nome, String raca, String nomeJogador, Integer forca, Integer destreza, Integer constituicao, Integer inteligencia, Integer sabedoria, Integer carisma) {
        this.nome = nome;
        this.raca = raca;
        this.nomeJogador = nomeJogador;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }


    public Personagem() {
    }

    public String getNome() {
        return nome;
    }

    public Personagem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getRaca() {
        return raca;
    }

    public Personagem setRaca(String raca) {
        this.raca = raca;
        return this;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public Personagem setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
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
}
