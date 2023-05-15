package br.com.foguete.rpgproject.core;

import br.com.foguete.rpgproject.domain.Dado;
import org.springframework.stereotype.Service;

@Service
public class DadoCore implements DadoPortIn {
    @Override
    public Integer getDiceResult(Dado dado) {
        int resultado = 0;
        switch (dado) {
            case D6:
                resultado = rolarD6();
                System.out.println("Resultado do D6: " + resultado);
                break;
            case D8:
                resultado = rolarD8();
                System.out.println("Resultado do D8: " + resultado);
                break;
            case D10:
                resultado = rolarD10();
                System.out.println("Resultado do D10: " + resultado);
                break;
            case D20:
                resultado = rolarD20();
                System.out.println("Resultado do D20: " + resultado);
                break;
            default:
                System.out.println("Dado inválido.");
                break;
        }
        return resultado;
    }
    private int rolarD6() {
        return (int) (Math.random() * 6) + 1;
    }

    private int rolarD8() {
        return (int) (Math.random() * 8) + 1;
    }

    private int rolarD10() {
        return (int) (Math.random() * 10) + 1;
    }

    private int rolarD20() {
        return (int) (Math.random() * 20) + 1;
    }


}
