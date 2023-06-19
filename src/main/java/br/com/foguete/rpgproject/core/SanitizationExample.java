package br.com.foguete.rpgproject.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SanitizationExample {
    public static void main(String[] args) {
        String inputEmail = "user@example.com";

        // Definindo a expressão regular para validar o endereço de e-mail
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Validando os dados de entrada no lado do cliente
        boolean isValid = validateInputData(inputEmail, emailPattern);

        if (isValid) {
            // Sanitizando os dados removendo caracteres especiais
            String sanitizedEmail = sanitizeInputData(inputEmail);

            // Utilizando o endereço de e-mail sanitizado na aplicação
            System.out.println("Endereço de e-mail válido: " + sanitizedEmail);
        } else {
            System.out.println("Endereço de e-mail inválido.");
        }
    }

    // Função para validar os dados de entrada com base em uma expressão regular
    private static boolean validateInputData(String inputData, String pattern) {
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(inputData);
        return matcher.matches();
    }

    // Função para sanitizar os dados de entrada, removendo caracteres especiais
    private static String sanitizeInputData(String inputData) {
        // Removendo tags HTML e scripts maliciosos (exemplo de sanitização básica)
        String sanitizedData = inputData.replaceAll("<[^>]+>", "").replaceAll("[\"'();]", "");
        return sanitizedData;
    }
}
{
}
