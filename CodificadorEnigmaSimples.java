import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CodificadorEnigmaSimples implements Codificador{
    // Retorna o nome do codificador
    public String getNome(){
        return "Codificador Enigma Simples (Rotores II, IV e V, Refletor B)";
    }

    // Retorna a data de imlementação do codificador (pode ser usado como versao)
    public LocalDate getDataCriacao(){
        return LocalDate.of(2025, 8, 17);
    }

    // Retorna o nivel de segurança do codificador (1 = muito baixo, 100 = muito alto)
    public int getNivelSeguranca(){
        return 25; //Ver depois se é válido assim
    }


    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
        //Instancia saída
        StringBuilder saida = new StringBuilder();

        //Para cada letra da mensagem recebida
        for (char letra : str.toCharArray()) {
            if (ABC.indexOf(letra) == -1) continue; // ignora caracteres fora do alfabeto

            int pos = ABC.indexOf(letra);

            // ---- ida ----
            pos = rotorIda(II, pos);
            pos = rotorIda(IV, pos);
            pos = rotorIda(V, pos);

            // ---- refletor ----
            char refletida = refletor.get(ABC.charAt(pos));
            pos = ABC.indexOf(refletida);

            // ---- volta ----
            pos = rotorVolta(V, pos);
            pos = rotorVolta(IV, pos);
            pos = rotorVolta(II, pos);

            saida.append(ABC.charAt(pos));
        }
        return saida.toString();
    }

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str){
        //Instancia saída
        StringBuilder saida = new StringBuilder();

        //Para cada letra da mensagem recebida
        for (char letra : str.toCharArray()) {
            if (ABC.indexOf(letra) == -1) continue; // ignora caracteres fora do alfabeto

            int pos = ABC.indexOf(letra);

            // ---- ida ----
            pos = rotorIda(II, pos);
            pos = rotorIda(IV, pos);
            pos = rotorIda(V, pos);

            // ---- refletor ----
            char refletida = refletor.get(ABC.charAt(pos));
            pos = ABC.indexOf(refletida);

            // ---- volta ----
            pos = rotorVolta(V, pos);
            pos = rotorVolta(IV, pos);
            pos = rotorVolta(II, pos);

            saida.append(ABC.charAt(pos));
        }

        return saida.toString();
    }
    
    static String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String II = "JDKSIRUXBLHWTMCQGZNPYFVOEA";
    
    static String IV = "BESOVPZJAYQUIRHXLMFTGKDCMW";
                        
    static String V  = "OFECKVZBRGITYUPSDNHLXAWMJQ";
    
    static int rotorIda(String rotor, int pos) {
        char letra = rotor.charAt(pos);
        return ABC.indexOf(letra);
    }

    static int rotorVolta(String rotor, int pos) {
        char letra = ABC.charAt(pos);
        return rotor.indexOf(letra);
    }

    static Map<Character, Character> refletor = new HashMap<>();
    static {
        refletor.put('A', 'Y'); refletor.put('Y', 'A');
        refletor.put('B', 'R'); refletor.put('R', 'B');
        refletor.put('C', 'U'); refletor.put('U', 'C');
        refletor.put('D', 'H'); refletor.put('H', 'D');
        refletor.put('E', 'Q'); refletor.put('Q', 'E');
        refletor.put('F', 'S'); refletor.put('S', 'F');
        refletor.put('G', 'L'); refletor.put('L', 'G');
        refletor.put('I', 'P'); refletor.put('P', 'I');
        refletor.put('J', 'X'); refletor.put('X', 'J');
        refletor.put('K', 'N'); refletor.put('N', 'K');
        refletor.put('M', 'O'); refletor.put('O', 'M');
        refletor.put('T', 'Z'); refletor.put('Z', 'T');
        refletor.put('V', 'W'); refletor.put('W', 'V');
    }

}
