/**
 * Define a estrutura geral de uma figura geométrica qualquer.
 */
public abstract class FiguraGeometrica
{
    protected String cor; //cor da figura
    protected boolean filled;

    /**
     * Construtor padrão para uma figura geométrica genérica.
     * @param cor
     * @param filled
     */
    public FiguraGeometrica(String cor, boolean filled) {
        this.cor = cor;
        this.filled = filled;
    }

    /**
     * Calcula do perímetro da figura.
     * @return o perímetro da figura.
     */
    public abstract double perimetro();

    /**
     * Calcula a área da figura.
     * @return a área da figura.
     */
    public abstract double area();

    /**
     * Getter para a cor da figura.
     * @return a cor da figura.
     */
    public String getCor() {
        return this.cor;
    }

    /**
     * Setter para a cor da figura.
     * @param novaCor nova cor.
     */
    public void setCor(String novaCor) {
        this.cor = novaCor;
    }

    /**
     * Checa se a figura é preenchida internamente por alguma cor.
     * @return true caso a figura seja preenchida, false caso contrário.
     */
    public boolean isFilled() {
        return this.filled;
    }

    /**
     * Setter para o campo "filled" da figura.
     * @param value novo valor para o campo.
     */
    public void setFilled(boolean value) {
        this.filled = value;
    }
}
