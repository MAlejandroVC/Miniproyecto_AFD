import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mein {
    public static void main(String[] args) throws FileNotFoundException {

        String cadena;
        String[] alfabeto;
        String inicialStr;
        String[] finalesStr;
        String[][] matrizStr = new String[1_000][];

        //input por txt
        File entrada = new File("AFD.txt");
        Scanner myReader = new Scanner(entrada);
        String line;
            //cadena
        line = myReader.nextLine();
        cadena = line;
            //alfabeto
        line = myReader.nextLine();
        line = line.substring(0,line.length()-1);
        alfabeto = line.split(";");
            //inicialSTR
        line = myReader.nextLine();
        inicialStr = line;
            //finalesSTR
        line = myReader.nextLine();
        line = line.substring(0,line.length()-1);
        finalesStr = line.split(";");
            //matrizSTR
        int k = 0;
        while (myReader.hasNextLine()) {
            line = myReader.nextLine();
            line = line.substring(0,line.length()-1);
            matrizStr[k] = line.split(";");
            k++;
        }
        myReader.close();

        //convertir Str a Int
        int inicial = Integer.parseInt(inicialStr);

        int[] finales = new int[finalesStr.length];
        for(int i=0; i<finalesStr.length; i++)
            finales[i] = Integer.parseInt(finalesStr[i]);

        int[][] matriz = new int[k][alfabeto.length];
        for(int i=0; i<k; i++)
            for (int j = 0; j < alfabeto.length; j++)
                matriz[i][j] = Integer.parseInt(matrizStr[i][j]);

        //crear AFD
        AFD automata = new AFD(inicial, finales, matriz, alfabeto);
        StringBuilder mapa = new StringBuilder();
        for(int i=0; i<cadena.length(); i++){
            mapa.append(automata.actual).append("/");
            automata.cambiarEstado(""+cadena.charAt(i));
        }
        mapa.append(automata.actual);
        boolean aceptado = false;
        for (int fin : finales)
            if (automata.actual == fin) {
                aceptado = true;
                break;
            }

        //mostrar resultados
        JOptionPane.showMessageDialog(null,
                "Cadena: "+cadena+
                        "\nMapa: "+mapa+
                        "\nPertenece: "+aceptado,
                "Imprechonante",JOptionPane.INFORMATION_MESSAGE);
    }
}