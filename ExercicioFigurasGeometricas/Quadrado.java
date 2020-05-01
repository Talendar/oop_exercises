/**
 * Classe para figuras geométricas quadradas. Atua como um wrapper para a classe Retangulo (um quadradado é um retângulo de lados iguais).
 */
public class Quadrado extends Retangulo
{
    /**
     * Construtor padrão para um quadrado.
     * @param lado
     * @param cor
     * @param filled
     */
    public Quadrado(double lado, String cor, boolean filled) {
        super(lado, lado, cor, filled);
    }

    /**
     * Sobrecarga do método para facilitar impressões.
     * @return string representativa do quadrado.
     */
    @Override
    public String toString() {
        return String.format("<> QUADRADO <>  < Cor interna: %s | Filled: %s >  < Lado: %.2f >  < Perimetro: %.2f | Area: %.2f >",
                this.cor, this.filled, this.ALTURA, this.perimetro(), this.area());
    }
}
