package fds.calabreso;

import java.time.LocalDate;

public class CodificadorReversoAlternado implements Codificador {
    private final int chave = 7; // valor pequeno e simples para parecer "caseiro"

    public String getNome() {
        return "Codificador Inverso com Troca";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 3, 17);
    }

    public int getNivelSeguranca() {
        return 40;
    }

    public String codifica(String str) {
        // Inverte a string e desloca alternadamente os caracteres
        String invertida = new StringBuilder(str).reverse().toString();
        StringBuilder resultado = new StringBuilder();
        boolean alterna = true;
        for (char c : invertida.toCharArray()) {
            if (alterna) {
                resultado.append((char)(c + chave));
            } else {
                resultado.append((char)(c - chave));
            }
            alterna = !alterna;
        }
        return resultado.toString();
    }

    public String decodifica(String str) {
        StringBuilder temp = new StringBuilder();
        boolean alterna = true;
        for (char c : str.toCharArray()) {
            if (alterna) {
                temp.append((char)(c - chave));
            } else {
                temp.append((char)(c + chave));
            }
            alterna = !alterna;
        }
        return temp.reverse().toString(); // desfaz a inversão
    }
}
