class Complex {

    double real;
    double image;

    // write methods here
    public void add(Complex anotherComplex) {
        real += anotherComplex.real;
        image += anotherComplex.image;
    }
    public void subtract(Complex anotherComplex) {
        real -= anotherComplex.real;
        image -= anotherComplex.image;
    }
}