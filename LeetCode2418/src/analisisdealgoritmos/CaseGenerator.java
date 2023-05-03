package analisisdealgoritmos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CaseGenerator {

    String[] nombres = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
        "Bartolome", "Baruc", "Baruj", "Candelaria", "Candida", "Canela", "Caridad", "Carina", "Carisa",
        "Caritina", "Carlota", "Baltazar"};
    int aux = 10 * 10 * 10 * 10 * 10;
    String[] nombre;
    int[] altura;

    public void generarCasos(int n) {
        nombre = new String[n];
        altura = new int[n];
        int name, height;
        try {
            String ruta = "nombre.txt";
            File fichero = new File(ruta);
            if (fichero.exists() == false) {
                fichero.createNewFile();
            }
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            String ruta2 = "altura.txt";
            File fichero2 = new File(ruta2);
            if (fichero2.exists() == false) {
                fichero.createNewFile();
            }
            FileWriter fw2 = new FileWriter(fichero2);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            //caso 1: nombres iguales con alturas diferentes
            name = (int) Math.floor(Math.random() * 20);
            for (int i = 0; i < n / 2; i++) {
                height = (int) (Math.random() * aux + 1);
                nombre[i] = nombres[name];
                while(verificar(height)){
                    height = (int) (Math.random() * aux + 1);
                }
                altura[i] = height;
            }
            //caso 2: nombres y alturas diferentes
            for (int i = n / 2; i < n; i++) {
                name = (int) Math.floor(Math.random() * 20);
                height = (int) (Math.random() * aux + 1);
                nombre[i] = nombres[name];
                while(verificar(height)){
                    height = (int) (Math.random() * aux + 1);
                }
                altura[i] = height;
            }

            for (int i = 0; i < n; i++) {
                bw.write("\"" + nombre[i] + "\"" + " ");
                bw2.write(altura[i] + " ");
            }

            bw.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean verificar(int a) {
        for (int i = 0; i < altura.length; i++) {
            if (altura[i] == a) {
                return true;
            }
        }
        return false;
    }

}
