import java.util.ArrayList;

/**
 * Classe main. Usada para testar a implementação do exercício.
 */
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Retangulo(10, 15, "azul", false));
        figuras.add(new Quadrado(5, "verde", true));
        figuras.add(new Circulo(7, "preto", false));

        System.out.println();
        for(FiguraGeometrica f: figuras)
            System.out.println(f);

    }
}
