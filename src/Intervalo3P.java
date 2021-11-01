public class Intervalo3P extends Intervalo {
    private double puntoIntermedio;

    public Intervalo3P() {
        super();
        this.puntoIntermedio = ORIGEN;
    }
    public Intervalo3P(double extremo) {
        super(extremo);
        this.puntoIntermedio = this.puntoMedio();
    }
    public Intervalo3P(double extremoInferior, double extremoSuperior) {
        super(extremoInferior, extremoSuperior);
        this.puntoIntermedio = this.puntoMedio();
    }
    public Intervalo3P(double extremoInferior, double extremoSuperior, double puntoIntermedio) {
        super(extremoInferior, extremoSuperior);
        this.puntoIntermedio = puntoIntermedio;
    }
    public Intervalo3P(Intervalo intervalo) throws IntervaloNuloException {
        super(intervalo);
        this.puntoIntermedio = this.puntoMedio();
    }
    public Intervalo3P(Intervalo3P intervalo) throws IntervaloNuloException {
        try {
            this.extremoInferior = intervalo.extremoInferior;
            this.extremoSuperior = intervalo.extremoSuperior;
            this.puntoIntermedio = intervalo.puntoIntermedio;
        }
        catch(NullPointerException npe) {
            throw new IntervaloNuloException();
        }
    }
    public Intervalo3P(Intervalo intervalo, double puntoIntermedio) throws IntervaloNuloException {
        super(intervalo);
        this.puntoIntermedio = puntoIntermedio;
    }

    @Override
    public Intervalo3P copia() {
        return new Intervalo3P(this.extremoInferior, this.extremoSuperior, this.puntoIntermedio);
    }

    @Override
    public Intervalo3P desplazado(double desplazamiento) {
        return new Intervalo3P(this.extremoInferior + desplazamiento, this.extremoSuperior + desplazamiento, this.puntoIntermedio + desplazamiento);
    }

    @Override
    public void desplazar(double desplazamiento) {
        super.desplazar(desplazamiento);
        this.puntoIntermedio += desplazamiento;
    }

    @Override
    public Intervalo3P escalado(double factor) {
        Intervalo3P escalado = this.copia();
        escalado.escalar(factor);
        return escalado;
    }

    @Override
    public void escalar(double factor) {
        super.escalar(factor);
        this.puntoIntermedio = this.puntoMedio();
    }

    public boolean iguales(Intervalo3P intervalo) {
        return super.iguales(intervalo) && this.puntoIntermedio == intervalo.puntoIntermedio;
    }

    @Override
    public String mostrar(int redondeo) {
        return this.toString() + " longitud: " + UtilDecimales.redondeo(this.longitud(), redondeo);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [" + this.extremoInferior + " - " + this.puntoIntermedio + " - " + this.extremoSuperior + "]";
    }

    @Override
    public Intervalo3P union(Intervalo intervalo) throws IntervaloNuloException {
        return new Intervalo3P(super.union(intervalo));
    }

    public Intervalo3P union(Intervalo3P intervalo) throws IntervaloNuloException {
        return new Intervalo3P(super.union(intervalo));
    }
}
