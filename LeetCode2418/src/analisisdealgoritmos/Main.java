package analisisdealgoritmos;

import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CaseGenerator cg = new CaseGenerator();
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Cantidad de casos a generar");
        int cantidad = sc.nextInt();
        cg.generarCasos(cantidad);
        String[] datos = s.sortPeople(s.leerNombres(cantidad), s.leerAlturas(cantidad));
        s.imprimir(datos);
    }

}
