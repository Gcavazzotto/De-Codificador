package fds.calabreso;

public class CodificadorFactory {

    public static Codificador getCodificador(int nivelDesejado) {
        Codificador[] codificadores = {
            new CodificadorSimples(),//ir adicionando a baixo new "nome do codicador" (),
            new CodificadorReversoAlternado(),
            new CodificadorEnigmaSimples()
            
        };

        Codificador melhor = codificadores[0];
        int menorDiferenca = Math.abs(nivelDesejado - melhor.getNivelSeguranca());

        for (Codificador c : codificadores) {
            int dif = Math.abs(nivelDesejado - c.getNivelSeguranca());
            if (dif < menorDiferenca) {
                melhor = c;
                menorDiferenca = dif;
            }
        }
        return melhor;
    }
}