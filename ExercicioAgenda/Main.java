import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Instituto de Ciências Matemáticas e de Computação (ICMC) - USP
 * Gabriel de Oliveira Guedes Nogueira (10295496)
 *
 * Resolução dos exercícios 1 e 2 de polimorfismo da disciplina de POO 2020.
 */
public class Main
{
    public static void main(String[] args)
    {
        Agenda agenda = new Agenda();
        int opt = -1;

        do {
            limparTela(2);
            System.out.print(
                    "> AGENDA ELETRONICA DELATURBO2000 <\n" +
                    "   [0] Imprimir Agenda\n" +
                    "   [1] Novo Contato\n" +
                    "   [2] Buscar Contato\n" +
                    "   [3] Remover Contato\n" +
                    "   [4] Limpar Agenda\n" +
                    "   [5] Sair\n" +
                    "Opcao: "
            );

            try {
                opt = EntradaTeclado.leInt();
                limparTela(2);
                switch(opt) {
                    case 0: System.out.print((agenda.tamanho() == 0) ? "Agenda vazia!\n" : agenda); break;
                    case 1: adicionarContato(agenda); break;
                    case 2: buscarContato(agenda); break;
                    case 3: removerContato(agenda); break;
                    case 4: agenda.limpar(); break;
                    case 5: break;
                    default: throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("\n\nOpcao invalida!");
            }
        } while(opt != 5);

        System.out.println("Finalzando...\n");
    }

    /**
     * Método auxiliar para receber uma entrada do usuário.
     * @param txt texto que irá pedir a entrada ao usuário.
     * @param tipo tipo da entrada a ser recebida ("str", "long" ou "int").
     * @return uma referência genérica para a entrada lida.
     */
    private static Object recebeEntrada(String txt, String tipo) throws IllegalArgumentException {
        while(true) {
            System.out.print(txt);
            try {
               switch(tipo) {
                   case "long": return EntradaTeclado.leLong();
                   case "int": return EntradaTeclado.leInt();
                   case "str": return EntradaTeclado.leString();
                   default: throw new IllegalArgumentException("Tipo invalido!");
               }
            } catch (IOException e) {
                System.out.println("Entrada invalida!\n");
            }
        }
    }

    /**
     * Lida com a entrada do usuário para a adição de um novo contato à agenda.
     * @param agenda agenda na qual o contato será adicionado.
     */
    private static void adicionarContato(Agenda agenda) {
        String nome, endereco, email;
        long telefone, cp;
        int tipo = -1;

        System.out.println("| ADICIONAR CONTATO |\n");
        while(tipo != 0 && tipo != 1) {
            tipo = (int) recebeEntrada("PF(0) ou PJ(1)? ", "int");
            if(tipo != 0 && tipo != 1)
                System.out.println("\nApenas 0 ou 1!\n");
        }

        nome = (String) recebeEntrada("Nome: ", "str");
        cp = (long) recebeEntrada( ( (tipo == 0) ? "CPF" : "CNPJ" ) + " (0s no inicio serao desconsiderados): ", "long");
        endereco = (String) recebeEntrada("Endereco: ", "str");
        email = (String) recebeEntrada("Email: ", "str");
        telefone = (long) recebeEntrada("Telefone: ", "long");

        if(tipo == 0) {
            Date nascimento;
            String estadoCiviil;

            while(true) {
                try {
                    String dateStr = (String) recebeEntrada("Data de nascimento (DD/MM/AAAA): ", "str");
                    nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                    break;
                } catch(ParseException e) {
                    System.out.println("Data invalida!\n");
                }
            }

            estadoCiviil = (String) recebeEntrada("Estado civil: ", "str");
            agenda.addContato(new PessoaFisica(nome, endereco, email, telefone, cp, nascimento, estadoCiviil));
        }
        else {
            long inscricao = (long) recebeEntrada("Inscricao Estadual (0s no inicio serao desconsiderados): ", "long");
            String razaoSocial = (String) recebeEntrada("Razao Social: ", "str");
            agenda.addContato(new PessoaJuridica(nome, endereco, email, telefone, cp, inscricao, razaoSocial));
        }
        System.out.printf("\n\n%s foi adicionado com sucesso a sua lista de contatos!\n", nome);
        agenda.ordenar();
    }

    /**
     * Lida com a entrada do usuário para a busca de um contato na agenda.
     * @param agenda agenda na qual o contato será buscado.
     */
    private static void buscarContato(Agenda agenda) {
        if(agenda.tamanho() == 0)
            System.out.println("Agenda vazia!");
        else {
            System.out.println("| BUSCAR CONTATO|\n");
            int tipoBusca;
            do {
                tipoBusca = (int) recebeEntrada("Buscar pelo NOME(0) ou CPF/CNPJ(1)? ", "int");
            } while(tipoBusca != 0 && tipoBusca != 1);
            Contato c;

            if(tipoBusca == 0)
                c = agenda.buscarContato((String) recebeEntrada("Nome: ", "str"));
            else
                c = agenda.buscarContato((long) recebeEntrada("CPF/CNPJ: ", "long"));

            if(c == null)
                System.out.println("\nContato não encontrado!");
            else
                System.out.print("\n" + c);
        }
    }

    /**
     * Lida com a entrada do usuário para a remoção de um contato na agenda.
     * @param agenda agenda da qual o contato será removido.
     */
    private static void removerContato(Agenda agenda) {
        if(agenda.tamanho() == 0)
            System.out.println("Agenda vazia!");
        else {
            System.out.println("| BUSCAR CONTATO|\n");
            int tipoBusca;
            do {
                tipoBusca = (int) recebeEntrada("Buscar pelo NOME(0) ou CPF/CNPJ(1)? ", "int");
            } while (tipoBusca != 0 && tipoBusca != 1);

            boolean removido = false;
            if (tipoBusca == 0)
                removido = agenda.removerContato((String) recebeEntrada("Nome: ", "str"));
            else
                removido = agenda.removerContato((long) recebeEntrada("CPF/CNPJ: ", "long"));

            if (!removido)
                System.out.println("\nContato não encontrado!");
            else {
                System.out.println("\nContato removido com sucesso!");
                agenda.ordenar();
            }
        }
    }

    /**
     * Método auxiliar simples usado para simular um comando "clear".
     * @param n quantidade de linhas que deverão ser puladas.
     */
    private static void limparTela(int n) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++)
            str.append("\n");
        System.out.print(str.toString());
    }
}
