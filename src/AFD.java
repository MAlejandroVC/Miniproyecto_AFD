public class AFD {
    public int actual;
    public int inicial;
    public int[] finales;
    public int[][] matriz;
    public String[] alfabeto;

    public AFD(int inicial, int[] finales, int[][] matriz, String[] alfabeto) {
        this.actual = inicial;
        this.inicial = inicial;
        this.finales = finales;
        this.matriz = matriz;
        this.alfabeto = alfabeto;
    }

    public void cambiarEstado(String simbolo){
        //encontrar el simbolo en el alfabeto
        int columna = 0;
        for(int i=0; i<alfabeto.length; i++){
            if(simbolo.equals(alfabeto[i])){
                columna = i;
                break;
            }
            System.out.println("ERROR. No se encontró símbolo en alfabeto");
        }
        //mover segun matriz
        this.actual = this.matriz[this.actual][columna];
    }
}
