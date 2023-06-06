package br.com.foguete.rpgproject.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.*;

public enum Raca {
    ANAO("anão"),
    ELFO("elfo"),
    MEIOELFO("meio-Elfo"),
    HAFLING("hafling"),
    HUMANO("humano"),
    DRACONADO("draconato"),
    GNOMO("gnomo"),
    MEIOORC("meio-orc"),
    TIEFLING("tiefling");

    String racaNome;

    private static final List<Raca> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static  final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Raca randomRaca(){
        return  VALUES.get(RANDOM.nextInt(SIZE));
    }

    Raca(String raca){
        this.racaNome = raca;
    }

    @Override
    @JsonValue
    public  String toString(){
        return racaNome;
    }

    public static Raca byValue(String value){
        for (Raca raca : Raca.values()){
            if(Objects.equals(raca.racaNome,value)){
                return raca;
            }
        }
        return null;
    }
    public static String valueOf(Raca raca){
        for (Raca racaValue: Raca.values()){
            if (Objects.equals(racaValue, raca)){
                return racaValue.toString();
            }
        }
        return null;
    }
}

