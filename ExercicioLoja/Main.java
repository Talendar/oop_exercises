import produtos.*;
import java.io.IOException;

/**
 * Classe principal usada para testar a implementação do excercício.
 */
public class Main
{
    public static void main(String[] args)
    {
        Loja loja = new Loja();
        loja.addProduto(new Livro("Java - The Complete Reference", 12345, 200, 2, 1000, 10, "Schildt"));
        loja.addProduto(new Livro("Learning Python", 54321, 189, 1, 1200, 5, "Lutz"));
        loja.addProduto(new CD("Sandy & Junior - AO VIVO", 91283, 24.99, 30, 512));
        loja.addProduto(new CD("CD-RW Virgem", 14583, 1.99, 100, 1024));
        loja.addProduto(new DVD("Stuart Little - O Filme", 43283, 42.50, 3, 4096));
        loja.addProduto(new Produto("Aspirador de Po DelaTurbo2000", 27818, 999.99, 1));

        int opt = -1;
        do {
            try {
                System.out.println("\n\n[0] Comprar;  [1] Estoque;  [2] Sair\n");
                opt = EntradaTeclado.leInt();

                if (opt == 0) {
                    System.out.print("\nNome do produto: ");
                    try {
                        Produto p = loja.buscarProduto(EntradaTeclado.leString());
                        System.out.print("Quantidade: ");
                        int qnt = EntradaTeclado.leInt();
                        System.out.print("Pagamento: ");
                        double v = EntradaTeclado.leDouble();
                        System.out.printf("Produto comprado com sucesso. Troco: %.2f\n", loja.venderProduto(p.getCodigoBarras(), qnt, v));
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println("\nProduto não encontrado!\n");
                    } catch (ProdutoForaDeEstoqueException e) {
                        System.out.println("\nProduto fora de estoque!\n");
                    } catch (ValorInsuficienteException e) {
                        System.out.println("\nPagamento insuficiente!\n");
                    }
                } else if (opt == 1)
                    System.out.println("\n\n" + loja);
            } catch (IOException e) {
                System.out.println("\nEntrada invalida!\n");
            }
        } while(opt != 2);
    }
}
