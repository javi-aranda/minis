import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CesarCipher {
    public static void main (String[] args) {
        // Argumentos

        if (args.length != 3) {
            System.out.println("Incorrect syntax: Expected \"java CesarCipher <SEED> <INPUT FILE> <OUTPUT FILE>\""); 
            System.exit(0);
        }
        
        int seed = Integer.parseInt(args[0]);
        String inputFilename = args[1];
        String outputFilename = args[2];

        // Otras cosas que he declarado
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final int ASCII_A_LOWERCASE = 97;                    // Posicion donde empieza la 'a' en la tabla ASCII
        StringBuilder inputStr = new StringBuilder();
        StringBuilder outputStr = new StringBuilder();

        // Lectura del archivo
        FileReader read;
        int c;
        try {
            read = new FileReader(inputFilename);
            c = read.read();
            while (c != -1) {
                inputStr.append((char)c);                    
                c = read.read();
            }
            read.close();
        } catch (IOException e) {
            System.out.println("Cannot read.");
        }
                
        // Proceso principal
        String finalInput = inputStr.toString().toLowerCase();         
                                                                          
        try {
            for (int i = 0; i < finalInput.length(); i++) {
                char letra = finalInput.charAt(i);
                int cesar = ((int)letra-ASCII_A_LOWERCASE+seed)%(alphabet.length);
                outputStr.append(alphabet[cesar]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File contains unsupported characters.");
        }

        // Escritura del archivo
        String finalOutput = outputStr.toString().toUpperCase();            // Idem finalInput

        try {
            BufferedWriter f = new BufferedWriter(new FileWriter(outputFilename));
            f.write(finalOutput);
            f.close();
        } catch (IOException e) {
            System.out.println("Error writing file.");
        } 

        System.out.print(finalOutput);
    }
}