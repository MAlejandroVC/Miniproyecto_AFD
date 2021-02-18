import javax.swing.*;

public class mein {
    public static void main(String[] args) {
        //inputs temporales... debe conseguir esto de un .txt
        String cadena = JOptionPane.showInputDialog("Ingresa la cadena inicial");
        String[] alfabeto = {"a","b"};
        String inicialStr = "0";
        String[] finalesStr = {"1","3"};
        String[][] matrizStr = {{"3","1"},{"2","1"},{"2","1"},{"3","4"},{"3","4"}};

        //convertir Str a Int
        int inicial = Integer.parseInt(inicialStr);

        int[] finales = new int[finalesStr.length];
        for(int i=0; i<finalesStr.length; i++)
            finales[i] = Integer.parseInt(finalesStr[i]);

        int[][] matriz = new int[matrizStr.length][alfabeto.length];
        for(int i=0; i<matrizStr.length; i++)
            for (int j = 0; j < alfabeto.length; j++)
                matriz[i][j] = Integer.parseInt(matrizStr[i][j]);

        //crear AFD
        AFD automata = new AFD(inicial, finales, matriz, alfabeto);
        String mapa = "";
        for(int i=0; i<cadena.length(); i++){
            mapa += automata.actual+"/";
            automata.cambiarEstado(""+cadena.charAt(i));
        }
        boolean aceptado = false;
        for(int i=0; i<finales.length; i++)
            if (automata.actual == finales[i])
                aceptado = true;

        //mostrar resultados
        JOptionPane.showMessageDialog(null,
                "Cadena: "+cadena+
                        "\nMapa: "+mapa+
                        "\nPertenece: "+aceptado,
                "Imprechonante",JOptionPane.INFORMATION_MESSAGE);
    }
}

//matrix[row][col]
