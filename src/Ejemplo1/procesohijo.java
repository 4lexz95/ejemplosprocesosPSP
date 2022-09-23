package Ejemplo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class procesohijo {
    public static void main(String[] args) throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(60);
        PrintWriter pw = new PrintWriter(new FileWriter("prueba.txt"));
        pw.println("Estoy vivo");
        pw.close();
    }
}
