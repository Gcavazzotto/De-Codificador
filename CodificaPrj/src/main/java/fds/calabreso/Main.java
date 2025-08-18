package fds.calabreso;

public class Main {
    public static void main(String[] args) {
        String texto = "cavazzo";

        Codificador c1 = CodificadorFactory.getCodificador(1);
        Codificador c2 = CodificadorFactory.getCodificador(30);
        Codificador c3 = CodificadorFactory.getCodificador(70);

        testarCodificador(c1, texto);
        testarCodificador(c2, texto);
        testarCodificador(c3, texto);
    }

    private static void testarCodificador(Codificador c, String texto) {
        String codificado = c.codifica(texto);
        String decodificado = c.decodifica(codificado);
        System.out.println("Algoritmo: " + c.getNome() + 
                           " (Segurança: " + c.getNivelSeguranca() + ")");
        System.out.println("Texto original: " + texto);
        System.out.println("Codificado: " + codificado);
        System.out.println("Decodificado: " + decodificado);
        System.out.println("------------------------------");
    }
}
