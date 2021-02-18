public class AFD {
    public int actual;
    public int inicial;
    public int[] finales;
    public int[] matriz;

    public void setInicial(int inicial) {
        this.inicial = inicial;
        this.actual = inicial;
    }

    public void setFinales(int[] finales) {
        this.finales = finales;
    }

    public void setMatriz(int[] matriz) {
        this.matriz = matriz;
    }


}
