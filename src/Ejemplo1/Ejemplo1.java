package Ejemplo1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {


    /**
     * app que abre el chrome con la pagina de progresa cargada
     *
     * @param args
     */
    public static void main(String[] args) {
        // Comandos -> Array de string
        // elemento 1 el programa
        // siguientes cada una de argumentos a arrancar
        //
      String[] comando = {"open","-a","Google Chrome","http://www.cieep.com"};
      String[] comando2 = {"open","/System/Applications/Textedit.app"};
      String[] hijo = {"java","-cp","out/production/EjemplosProcesos/Ejemplo1/procesohijo.class"};
      String[] hijo1 = {"java","-cp","src/Ejemplo1/procesohijo.java"};
      // Crear el proceso con el processBuilder
        //ProcessBuilder pb = new ProcessBuilder(comando);
        //ProcessBuilder pb = new ProcessBuilder(comando2);
        ProcessBuilder pb = new ProcessBuilder(hijo1);




        // crear proceso hijo
        try {
            Process pSafari = pb.start();
            if (pSafari.isAlive()) {
                TimeUnit.SECONDS.sleep(10);
                pSafari.destroy();
            }
            TimeUnit.SECONDS.sleep(10);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}
