public class Intervalo {
    protected double extremoInferior;
    protected double extremoSuperior;
    protected static final double ORIGEN = 0.0;

    public Intervalo() {
        this(ORIGEN, ORIGEN);
    }
    public Intervalo(double extremo) {
        this(extremo, ORIGEN);
    }
    public Intervalo(double extremoInferior, double extremoSuperior) {
        this.extremoInferior = Math.min(extremoSuperior, extremoInferior);
        this.extremoSuperior = Math.max(extremoSuperior, extremoInferior);
    }
    public Intervalo(Intervalo intervalo) throws IntervaloNuloException{
        try {
            this.extremoInferior = intervalo.extremoInferior;
            this.extremoSuperior = intervalo.extremoSuperior;
        }
        catch(NullPointerException npe) {
            throw new IntervaloNuloException();
        }
    }


    public boolean anterior(Intervalo intervalo) throws IntervaloNuloException {
        try {
            return this.extremoSuperior < intervalo.extremoInferior;
        }
        catch(NullPointerException npe) {
            throw new IntervaloNuloException();
        }
    } //Indica si el Intervalo base es anterior al intervalo proporcionado como parámetro.

    public Intervalo copia() {
        return new Intervalo(this.extremoInferior, this.extremoSuperior);
    } //Devuelve un nuevo Intervalo con los extremos superior e inferior del Intervalo base.

    public Intervalo desplazado(double desplazamiento) {
        return new Intervalo(this.extremoInferior + desplazamiento, this.extremoSuperior + desplazamiento);
    } //Devuelve un Intervalo desplazado el desplazamiento dado respecto al Intervalo base.

    public void desplazar(double desplazamiento) {
        this.extremoInferior += desplazamiento;
        this.extremoSuperior += desplazamiento;
    } //Desplaza el Intervalo base el desplazamiento dado.

    public Intervalo diferencia(Intervalo intervalo) throws IntervaloNuloException {
        if(intervalo == null || !this.intersecta(intervalo) || this.incluye(intervalo))
            throw new IntervaloNuloException();

        Intervalo diferencia;
        if(this.extremoInferior < intervalo.extremoInferior)
            diferencia = new Intervalo(this.extremoInferior, intervalo.extremoInferior);
        else
            diferencia = new Intervalo(intervalo.extremoSuperior, this.extremoSuperior);
        return diferencia;
    } //Devuelve un Intervalo resultado de la diferencia del Intervalo base con el intervalo pasado por parámetro o null si no existe intersección con dicho intervalo.

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj.getClass() == Intervalo.class)
            equals = iguales((Intervalo) obj);
        return equals;
    } //Indica si el Intervalo es igual al intervalo pasado por parámetro.

    public Intervalo escalado(double factor) {
        double longitud = (this.longitud()/2)*(factor < 0? 1/factor*-1: factor);
        return new Intervalo(this.puntoMedio() - longitud, this.puntoMedio() + longitud);
    } //Devuelve un Intervalo resultado de escalar el Intervalo base con el factor pasado por parámetro.

    public void escalar(double factor) {
        double longitud = (this.longitud()/2)*(factor < 0? 1/factor*-1: factor);
        double menor = this.puntoMedio() - longitud;
        double mayor = this.puntoMedio() + longitud;
        this.extremoInferior = menor;
        this.extremoSuperior = mayor;
    } //Escala el Intervalo base con el factor pasado por parámetro.

    public double getExtremoInferior() {
        return this.extremoInferior;
    }

    public double getExtremoSuperior() {
        return this.extremoSuperior;
    }

    public boolean iguales(Intervalo intervalo) {
        boolean iguales = false;
        if(intervalo != null)
            iguales = this.extremoInferior == intervalo.extremoInferior && this.extremoSuperior == intervalo.extremoSuperior;
        return iguales;
    } //Indica si el Intervalo es igual al intervalo pasado por parámetro.

    public boolean incluye(double punto) {
        return this.extremoInferior <= punto && this.extremoSuperior >= punto;
    } //Indica si el Intervalo base incluye al punto proporcionado como parámetro.

    public boolean incluye(Intervalo intervalo) throws IntervaloNuloException {
        try {
            return this.extremoInferior <= intervalo.extremoInferior && this.extremoSuperior >= intervalo.extremoSuperior;
        }
        catch(NullPointerException npe) {
            throw new IntervaloNuloException();
        }
    } //Indica si el Intervalo base incluye al intervalo proporcionado como parámetro.

    public Intervalo interseccion(Intervalo intervalo) throws IntervaloNuloException {
        Intervalo interseccion = null;;
        if(intersecta(intervalo)) {
            double menor = Math.max(this.extremoInferior, intervalo.extremoInferior);
            double mayor = Math.min(this.extremoSuperior, intervalo.extremoSuperior);
            interseccion = new Intervalo(menor, mayor);
        }
        return interseccion;
    } //Devuelve un Intervalo resultado de la intersección con el intervalo pasado por parámetro o null si no existe intersección.

    public boolean intersecta(Intervalo intervalo) throws IntervaloNuloException {
        return this.incluye(intervalo.extremoInferior) || this.incluye(intervalo.extremoSuperior) || intervalo.incluye(this);
    } //Indica si el Intervalo base intersecta con el intervalo proporcionado como parámetro.

    public Intervalo intervaloEntre(Intervalo intervalo) throws IntervaloNuloException {
        if(intervalo == null || this.intersecta(intervalo))
            throw new IntervaloNuloException();
        double menor = Math.min(this.extremoSuperior, intervalo.extremoSuperior);
        double mayor = Math.max(this.extremoInferior, intervalo.extremoInferior);
        return new Intervalo(menor, mayor);
    } //Devuelve un Intervalo correspondiente al espacio existente entre el Intervalo base y el intervalo pasado por parámetro o null si no existe espacio entre ambos.

    public double longitud() {
        return extremoSuperior - extremoInferior;
    } //Calcula la longitud del Intervalo como la diferencia entre sus extremos.

    public double longitudEntre(Intervalo intervalo) throws IntervaloNuloException {
        Intervalo aux = intervaloEntre(intervalo);
        return aux.longitud();
    } //Devuelve la longitud del Intervalo correspondiente al espacio existente entre el Intervalo base y el intervalo pasado por parámetro, o 0.0 si no existe espacio entre ambos.

    public String mostrar() {
        return this.toString() + " longitud: " + this.longitud() + " punto medio: " + this.puntoMedio();
    } //Genera una representación como cadena del Intervalo.

    public String mostrar(int redondeo) {
        return this.toString() + " longitud: " + UtilDecimales.redondeo(this.longitud(), redondeo) + " punto medio: " + UtilDecimales.redondeo(this.puntoMedio(), redondeo);
    }

    public boolean posterior(Intervalo intervalo) throws IntervaloNuloException {
        try {
            return this.extremoInferior > intervalo.extremoSuperior;
        }
        catch (NullPointerException npe) {
            throw new IntervaloNuloException();
        }
    } //Indica si el Intervalo base es posterior al intervalo proporcionado como parámetro.

    public double puntoMedio() {
        return extremoInferior + this.longitud()/2;
    } //Calcula el punto medio del Intervalo.

    @Override
    public String toString() {
        return this.getClass().getName() + " [" + this.extremoInferior + ", " + this.extremoSuperior + "]";
    } //Genera una representación como cadena del Intervalo.

    public Intervalo union(Intervalo intervalo) throws IntervaloNuloException {
        if(intervalo == null || !this.intersecta(intervalo))
            throw new IntervaloNuloException();
        double menor = Math.min(this.extremoInferior, intervalo.extremoInferior);
        double mayor = Math.max(this.extremoSuperior, intervalo.extremoSuperior);
        return new Intervalo(menor, mayor);
    } //Devuelve un Intervalo resultado de la unión del Intervalo base con el intervalo pasado por parámetro o null si no existe intersección con dicho intervalo.
}
