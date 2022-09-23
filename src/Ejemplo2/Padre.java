package Ejemplo2;

import java.io.*;
import java.util.Scanner;

public class Padre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas lines quieres mostrar");
        int cont = sc.nextInt();

        // pr es el que prepara pero no crea el proceso
        ProcessBuilder pb = new ProcessBuilder("java","src/Ejemplo2/Hijo.java");
        pb.redirectErrorStream(true);

        try {
            Process hijo = pb.start();
            //robarle sus entradas y salidas aL proceso hijo
            // ----------LECTURA ---------------
            // Cojo la entrada estandar de hijo
            InputStream isHijo = hijo.getInputStream();

            //Con esta linea creo un lecto para la entrada
            InputStreamReader isrHijo = new InputStreamReader(isHijo, "UTF-8");
            // Creare un buffer para que lea linea a linea
            BufferedReader brHijo = new BufferedReader(isrHijo);

            // -----------ESCRITURA----------
            OutputStream outputStream = hijo.getOutputStream();
            PrintStream psHijo = new PrintStream(outputStream);
            // al hijo le  hago un print de contador

            psHijo.println(cont);
            psHijo.flush();
            //despues de escribir al hijo lo que quiero que haga creamos un string resp

            String respuesta;
            while ((respuesta = brHijo.readLine()) != null){
                System.out.println(respuesta);

            }


            //poder escribir en ellos
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
