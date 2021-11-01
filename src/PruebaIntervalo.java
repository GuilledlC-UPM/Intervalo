public class PruebaIntervalo {
    public PruebaIntervalo() {
        System.out.println("--------Constructores--------");
        System.out.print("Intervalo()\t\t\t -> ");
        Intervalo i1 = new Intervalo();
        System.out.println(i1.mostrar());
        System.out.print("Intervalo(9.25, 7.5) -> ");
        Intervalo i2 = new Intervalo(9.25, 7.5);
        System.out.println(i2.mostrar());
        System.out.print("Intervalo(5.0)\t\t -> ");
        Intervalo i3 = new Intervalo(5.0);
        System.out.println(i3.mostrar());
        System.out.print("Intervalo(-5.0)\t\t -> ");
        Intervalo i4 = new Intervalo(-5.0);
        System.out.println(i4.mostrar());
        System.out.print("Intervalo(i2)\t\t -> ");
        Intervalo i5 = null;
        try {
            i5 = new Intervalo(i2);
            System.out.println(i5.mostrar());
        } catch (IntervaloNuloException ine){
            System.out.println(ine.getMessage());
        }

        System.out.print("Intervalo(null)\t\t -> ");
        Intervalo i6 = null;
        try {
            i6 = new Intervalo(null);
            System.out.println(i6.mostrar());
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------anterior/posterior--------");
        try {
            System.out.println(i2+" es anterior a "+i4+" -> "+i2.anterior(i4));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i4+" es anterior a "+i2+" -> "+i4.anterior(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" es posterior a "+i4+" -> "+i2.posterior(i4));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i4+" es posterior a "+i2+" -> "+i4.posterior(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------incluye--------");
        System.out.println(i2+" incluye a 8.0 -> "+i2.incluye(8.0));
        System.out.println(i2+" incluye a 10.0 -> "+i2.incluye(10.0));
        Intervalo i7 = new Intervalo(8, 10);
        try {
            System.out.println(i2+" incluye a "+i7+" -> "+i2.incluye(i7));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" incluye a "+i5+" -> "+i2.incluye(i5));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i7+" incluye a "+i2+" -> "+i7.incluye(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------intersecta--------");
        try {
            System.out.println(i2+" intersecta a "+i7+" -> "+i2.intersecta(i7));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" intersecta a "+i5+" -> "+i2.intersecta(i5));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i7+" intersecta a "+i2+" -> "+i7.intersecta(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" intersecta a "+i4+" -> "+i2.intersecta(i4));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i4+" intersecta a "+i2+" -> "+i4.intersecta(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------interseccion--------");
        try {
            System.out.println(i2+" interseccion con "+i7+" -> "+i2.interseccion(i7));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" interseccion con "+i5+" -> "+i2.interseccion(i5));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i7+" interseccion con "+i2+" -> "+i7.interseccion(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" interseccion con "+i4+" -> "+i2.interseccion(i4));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i4+" interseccion con "+i2+" -> "+i4.interseccion(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------diferenciaEntre--------");
        try {
            System.out.println(i2+" diferencia con "+i7+" -> "+i2.intervaloEntre(i7));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" diferencia con "+i4+" -> "+i2.intervaloEntre(i4));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------longitudEntre--------");
        try {
            System.out.println(i2+" longitud con "+i7+" -> "+i2.longitudEntre(i7));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i2+" longitud con "+i4+" -> "+i2.longitudEntre(i4));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------desplazar--------");
        System.out.println(i5.mostrar());
        i5.desplazar(3);
        System.out.println("\t desplazar 3.0 -> "+i5.mostrar());
        i5.desplazar(-3);
        System.out.println("\t desplazar -3.0 -> "+i5.mostrar());
        System.out.println();

        System.out.println("--------desplazado--------");
        System.out.println(i5.mostrar());
        System.out.println("\t desplazado 5.0 -> "+i5.desplazado(5).mostrar());
        System.out.println("\t original -> "+i5.mostrar());
        System.out.println();

        System.out.println("--------escalar--------");
        Intervalo i8 = new Intervalo(2, 4);
        System.out.println(i8.mostrar());
        i8.escalar(3);
        System.out.println("\t\t  escalar por 3 -> "+i8.mostrar());
        i8.escalar(-3);
        System.out.println("\t\t  escalar por -3 -> "+i8.mostrar());
        i8.escalar(-10);
        System.out.println("\t\t  escalar por -10 -> "+i8.mostrar());
        i8.escalar(0);
        System.out.println("\t\t  escalar por 0 -> "+i8.mostrar());
        System.out.println();

        System.out.println("--------escalado--------");
        System.out.println(i5.mostrar());
        System.out.println("\t escalado 5.0 -> "+i5.escalado(5).mostrar());
        System.out.println("\t original -> "+i5.mostrar());
        System.out.println();

        System.out.println("--------igual--------");
        Intervalo i9 = i7.copia();
        Intervalo i10 = i9.desplazado(7);
        System.out.println(i10+" es igual a "+i9+" desplazado 7.0 -> " + i10.iguales(i9.desplazado(7)));
        System.out.println(i10+" es igual a "+i9+" -> " + i10.iguales(i9));
        System.out.println(i10+" es 'equals' a "+i9+" desplazado 7.0 -> " + i10.equals(i9.desplazado(7)));
        System.out.println(i10+" es 'equals' a "+i9+" -> " + i10.equals(i9));
        System.out.println();

        System.out.println("--------union/diferencia--------");
        i10.desplazar(-7);
        try {
            System.out.println(i10+" union "+i2+" -> "+i10.union(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i8+" union "+i10+" -> "+i8.union(i10));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i10+" diferencia "+i2+" -> "+i10.diferencia(i2));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        try {
            System.out.println(i8+" diferencia "+i10+" -> "+i8.diferencia(i10));
        } catch (IntervaloNuloException ine) {
            System.out.println(ine.getMessage());
        }
        System.out.println();

        System.out.println("--------mostrar(redondeo)--------");
        Intervalo i11 = new Intervalo(1.23456789, 9.87654321);
        System.out.println(i11.mostrar());
        System.out.println("\t\t redondeo a 2 -> "+i11.mostrar(2));
        System.out.println("\t\t redondeo a 3 -> "+i11.mostrar(3));
        System.out.println("\t\t redondeo a 4 -> "+i11.mostrar(4));
        System.out.println("\t\t redondeo a 5 -> "+i11.mostrar(5));
        System.out.println("\t\t original -> "+i11.mostrar());
    }

    public static void main(String[] args) {
        new PruebaIntervalo();
    }
}
