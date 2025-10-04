// Name: Omar Elsayed
// Banner ID: B00993452
// Lab 1 – CSCI 2110 Fall 2025
public class Complex {
    private double real, imag;
    private static final double EPSILON = 1e-8; // Epsilon constant to be used throughout methods and classes

    public Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public Complex(){
        this.real = 0.0;
        this.imag = 0.0;
    }
    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getReal(){
        return real;
    }

    public double getImag(){
        return imag;
    }

    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal(){
        return Math.abs(imag - 0.0) <= EPSILON; // using hint from comparing doubes in Lab Spec
    }

    public boolean isImaginary(){
        return Math.abs(real - 0.0) <= EPSILON;
    }

    public boolean equals(Complex other){
        return Math.abs(real - other.real) <= EPSILON && Math.abs(imag - other.imag) <= EPSILON;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(real,2) + Math.pow(imag,2)); // same as (sqrt( real*real + imag*imag))
    }

    public Complex add(Complex other){
        double newR = real + other.real;
        double newI = imag + other.imag;
        return new Complex(newR,newI);
    }

    public Complex sub(Complex other){
        double newR = real - other.real;
        double newI = imag - other.imag;
        return new Complex(newR,newI);
    }

    public Complex multiply(Complex other){
        // foll0wing hint from lab doc  (a+bi)*(c+di) = (ac-bd)+(ad+bc)i
        double newR = (real * other.real) - (imag * other.imag);
        double newI = (real * other.imag) + (imag * other.real);
        return new Complex(newR,newI);
    }
}
