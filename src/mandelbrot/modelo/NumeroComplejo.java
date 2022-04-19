package src.mandelbrot.modelo;

public class NumeroComplejo {

    private double compReal;
    private double compImg;

    public NumeroComplejo(double compReal, double compImg) {
        this.compReal = compReal;
        this.compImg = compImg;
    }

    public double getCompReal() {
        return compReal;
    }

    public double getCompImg() {
        return compImg;
    }

    public NumeroComplejo sumar(NumeroComplejo z) {
        return new NumeroComplejo(this.compReal + z.getCompReal(),
                this.compImg + z.getCompImg());
    }

    public NumeroComplejo multiplicar(NumeroComplejo z) {
        return new NumeroComplejo(
                this.compReal*z.getCompReal() -
                        this.compImg * z.getCompImg(),
                this.compReal*z.getCompImg() +
                        this.compImg*z.getCompReal()
        );
    }

    public double absAlCuadrado() {
        return this.compReal*this.compReal +
                this.compImg*this.compImg;
    }
}
