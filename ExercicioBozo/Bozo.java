import java.io.IOException;

/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author Gabriel de Oliveira Guedes Nogueira (10295496)
 */
public class Bozo
{
    public static void main(String[] args)
    {
        int hscore = 0, opt = -1;
        do {
            printMenu();
            try {
                opt = EntradaTeclado.leInt();
                switch(opt) {
                    case 1:
                        int score = startGame();
                        System.out.println("\nPontuacao: " + score);
                        if(score > hscore) {
                            hscore = score;
                            System.out.println("Novo recorde!");
                        }
                        break;
                    case 2:
                        System.out.println("\nRecorde atual da sessao: " + hscore);  break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("\nOpcao invalida!\n");
            }
        } while(opt != 3);
        System.out.println("\n\nFinalizando...\n");
    }

    /**
     * Lida com a execução principal do jogo.
     * @return a pontuação obtida na partida.
     */
    private static int startGame()
    {
        RolaDados dados = new RolaDados(5);
        Placar placar = new Placar();

        for(int r = 1; r <= 10; r++) {
            System.out.println("\n\n" + placar);
            System.out.printf("\n >>>>>>>>>> RODADA [%d]\nPressione ENTER para lancar os dados.\n", r);
            pauseEnter();

            int[] lados = dados.rolar();
            System.out.println("\n" + dados.toString() + "\n");

            for(int i = 0; i < 2; i++) {
                System.out.println("Digite o numero dos dados que deseja TROCAR.");
                try {
                    String quais = EntradaTeclado.leString();
                    lados = dados.rolar(quais);
                } catch(IOException ignored) {}

                System.out.println("\n" + dados.toString() + "\n");
            }

            int pos = -1;
            boolean valid = false;

            do {
                System.out.println(placar.toString());
                System.out.print("\nEscolha a POSICAO que voce deseja marcar com essa jogada ====> ");

                try {
                    pos = EntradaTeclado.leInt();
                    placar.add(pos, lados);
                    valid = true;
                }
                catch(IOException | IllegalArgumentException e) {
                    System.out.println("\nPosicao invalida!\n");
                }
            } while(pos < 0 || pos > 10 || !valid);

        }

        return placar.getScore();
    }

    /**
     * Pausa a execução até que o usuário pressione ENTER.
     */
    private static void pauseEnter() {
        try {
            EntradaTeclado.leString();
        } catch (IOException ignored) {}
    }

    /**
     * Função simples que imprime o menu principal do jogo no stdout.
     */
    private static void printMenu() {
        System.out.print(
                "\n> BEM VINDO AO BOZOH DO DELA! <\n" +
                "  [1] Novo Jogo\n" +
                "  [2] Recorde atual\n" +
                "  [3] Sair\n" +
                "Opcao: "
        );
    }
}
