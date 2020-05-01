/**
 * Define a estrutura geral de um retângulo.
 */
public class Retangulo extends FiguraGeometrica
{
    protected final double ALTURA, LARGURA;

    /**
     * Construtor padrão para um retângulo.
     * @param altura
     * @param largura
     * @param cor
     * @param filled
     */
    public Retangulo(double altura, double largura, String cor, boolean filled) {
        super(cor, filled);
        this.ALTURA = altura;
        this.LARGURA = largura;
    }

    /**
     * Calcula do perímetro do retângulo.
     * @return o perímetro do retângulo.
     */
    @Override
    public double perimetro() {
        return 2*this.ALTURA + 2*this.LARGURA;
    }

    /**
     * Calcula a área do retângulo.
     * @return a área da retângulo.
     */
    @Override
    public double area() {
        return this.ALTURA * this.LARGURA;
    }

    /**
     * Getter para a altura do retângulo.
     * @return a altura do retângulo.
     */
    public double getAltura() {
        return this.ALTURA;
    }

    /**
     * Getter para a largura do retângulo.
     * @return a largura do retângulo.
     */
    public double getLargura() {
        return this.LARGURA;
    }

    /**
     * Sobrecarga do método para facilitar impressões.
     * @return string representativa do retângulo.
     */
    @Override
    public String toString() {
        return String.format("<> RETANGULO <>  < Cor interna: %s | Filled: %s >  < Altura: %.2f | Largura: %.2f >  < Perimetro: %.2f | Area: %.2f >",
                this.cor, this.filled, this.ALTURA, this.LARGURA, this.perimetro(), this.area());
    }
}
