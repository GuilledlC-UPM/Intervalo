public class UtilDecimales {

    public static double redondeo(double valor, int redondeo) {
        double factor = Math.pow(10, redondeo);
        return Math.round(valor*factor)/factor;
    } //Redondea el valor al número de decimales indicados por redondeo

    public static int numDecimales(double valor) {
        String numero = String.valueOf(valor);
        String decimales = numero.substring(numero.indexOf('.') + 1);
        return decimales.length();
    } //Devuelve el número de decimales del valor
}
