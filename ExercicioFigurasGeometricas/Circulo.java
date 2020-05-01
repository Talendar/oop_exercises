/**
 * Define a estrutura geral e as operações de um círculo.
 */
public class Circulo extends FiguraGeometrica
{
    private final double RAIO;

    /**
     * Construtor padrão para um círculo.
     * @param raio
     * @param cor
     * @param filled
     */
    public Circulo(double raio, String cor, boolean filled) {
        super(cor, filled);
        this.RAIO = raio;
    }

    /**
     * Calcula o perímetro do círculo.
     * @return o perímetro do círculo.
     */
    @Override
    public double perimetro() {
        return 2 * Math.PI * this.RAIO;
    }

    /**
     * Calcula a área do círculo.
     * @return a área do círculo.
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(this.RAIO, 2);
    }

    /**
     * Sobrecarga do método para facilitar impressões.
     * @return string representativa do círculo.
     */
    @Override
    public String toString() {
        return String.format("<> CIRCULO <>  < Cor interna: %s | Filled: %s >  < Raio: %.2f >  < Perimetro: %.2f | Area: %.2f >",
                this.cor, this.filled, this.RAIO, this.perimetro(), this.area());
    }
}
