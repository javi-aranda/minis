import java.util.Scanner;
import java.lang.*;

public class Polybius {

    static char polybiusCypher[][] = { { 'A', 'B', 'C', 'D', 'E' }, 
                                     { 'F' , 'G', 'H', 'I', 'K' },
                                     { 'L', 'M' , 'N', 'O', 'P' }, 
                                     { 'Q', 'R', 'S', 'T', 'U'}, 
                                     { 'V', 'W', 'X', 'Y' , 'Z'} };
    
    public static String cipher(char singleCharacter) {
        char uppercaseChar = Character.toUpperCase(singleCharacter);
        for (int i = 0; i < polybiusCypher.length; i++) {
            for (int j = 0; j < polybiusCypher[0].length; j++) {
                if (uppercaseChar == polybiusCypher[i][j])
                    return Integer.toString(i+1) + Integer.toString(j+1); // Devuelve las coordenadas concatenadas.
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String userInput;
        Scanner reader = new Scanner(System.in);

        // Entrada y excepciones
        while (true) {
            System.out.print("Enter your text: ");
            try {
                userInput = reader.next();
                break;
            } catch (Exception e) {
                System.out.println("Input error. Check what you've entered and try again.");
            }
        }

        char variableCharacter;
        for (int i = 0; i < userInput.length(); i++) {
            variableCharacter = userInput.toCharArray()[i];
            System.out.print(cipher(variableCharacter));
        }
    }
}