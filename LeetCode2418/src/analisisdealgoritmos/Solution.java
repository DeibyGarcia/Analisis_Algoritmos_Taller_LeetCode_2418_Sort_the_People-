package analisisdealgoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        String[][] datos = new String[2][heights.length];
        for (int i = 0; i < names.length; i++) {
            datos[0][i] = names[i];
            datos[1][i] = heights[i] + "";
        }
        datos = sort(datos, heights.length);
        String[] orden = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            orden[i] = datos[0][names.length - 1 - i];
        }
        return orden;

    }

    public String[][] sort(String[][] datos, int tamaño) {
        int menor = 0;
        String aux;
        String aux2;
        for (int i = 0; i < tamaño - 1; i++) {
            menor = i;
            for (int j = i + 1; j < tamaño; j++) {
                if (Integer.parseInt(datos[1][j]) < Integer.parseInt(datos[1][menor])) {
                    menor = j;
                }
            }
            aux = datos[0][menor];
            aux2 = datos[1][menor];
            datos[0][menor] = datos[0][i];
            datos[1][menor] = datos[1][i];
            datos[0][i] = aux;
            datos[1][i] = aux2;
        }
        return datos;
    }

    public String[] leerNombres(int n) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] retorno = new String[n];
        try {
            archivo = new File("nombre.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            retorno = linea.split(" ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return retorno;
    }

    public int[] leerAlturas(int n) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int[] retorno = new int[n];
        String[] aux = new String[n];
        try {
            archivo = new File("altura.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            aux = linea.split(" ");
            for (int i = 0; i < n; i++) {
                retorno[i] = Integer.parseInt(aux[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return retorno;
    }

    public void imprimir(String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }
    }
}
