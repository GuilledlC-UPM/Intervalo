public class Main {
    public static void main(String[] args) {
        Intervalo profe = new Intervalo(1, 5);
        System.out.println(profe.escalado(-3).mostrar());

        Intervalo3P a = new Intervalo3P(2d, 3d);

        /*profe.escalar(-2);
        System.out.println(profe.mostrar());*/
        /*Intervalo i1 = new Intervalo();
        Intervalo i2 = new Intervalo(9.0, 7.5);
        Intervalo i3 = new Intervalo(9.0);
        Intervalo i4 = new Intervalo(-9.0);
        Intervalo i5 = new Intervalo(i2);
        Intervalo i6 = new Intervalo(null);
        System.out.println(i1.mostrar());
        System.out.println(i2.mostrar());
        System.out.println(i3.mostrar());
        System.out.println(i4.mostrar());
        System.out.println(i5.mostrar());
        System.out.println(i6.mostrar());
        Intervalo i7 = new Intervalo(7);
        Intervalo i8 = new Intervalo(-5, -10);
        //Intervalo i9 = i7.unir(i8);
        System.out.println(i7.mostrar());
        System.out.println(i8.mostrar());
        //System.out.println(i9.mostrar());*/
    }
}
