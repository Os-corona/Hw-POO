import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== EXCEPCIONES EN JAVA ==\n");

        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }

        try {
            String texto = null;
            int longitud = texto.length();
        } catch (NullPointerException e) {
            System.out.println("Referencia nula: " + e.getMessage());
        }
        
        try {
            int[] arreglo = {1, 2, 3};
            int valor = arreglo[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango: " + e.getMessage());
        }

        try {
            String texto = "abc";
            int numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número inválido: " + e.getMessage());
        }

        try {
            Class clase = Class.forName("ClaseInexistente");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }

        try {
            FileReader archivo = new FileReader("archivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese un número entero:");
            int numero = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ser un número entero.");
        }

        try {
            ArrayList<String> lista = new ArrayList<>();
            lista.add("Uno");
            String elemento = lista.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango en la lista.");
        }

        try {
            int edad = -5;
            if (edad < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento ilegal: " + e.getMessage());
        }

        try {
            String texto = "Hola";
            char caracter = texto.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango en la cadena.");
        }
    }
}
