import java.util.Arrays;
import java.util.Random;

public class FrecuenciaDados {
    public static void main(String[] args) {

        final int TIRADAS = 10000;
        int dado1, dado2, valor;
        int[] frecuencias = new int[11];
        Arrays.fill(frecuencias, 0);
        Random rand1 = new Random();
        Random rand2 = new Random();

        for (int i = 0; i<TIRADAS; i++) {
            dado1 = rand1.nextInt(6) + 1;
            dado2 = rand2.nextInt(6) + 1;
            valor = dado1 + dado2;
            frecuencias[valor-2]++;
        }

        System.out.printf("%s %-24s %9s %15s %n",  "Valor", " Grafico", "Frecuencia", "Media (%)");
        for (int i = 0; i < frecuencias.length; i++) {
            float media = (float)frecuencias[i]*100/TIRADAS;
            String grafico = String.format(String.format("%%%ds", (int)media), " ").replace(" ","*");
            System.out.printf("%-6d %-20s %10d %15.2f %n",  i+2, grafico, frecuencias[i], media);
        }
    }
}