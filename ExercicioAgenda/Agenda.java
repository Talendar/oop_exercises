import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe para representar uma agenda de contatos. É usada em conjunto com a classe Contato e suas subclasses.
 */
public class Agenda
{
    private ArrayList<Contato> contatos; //lista de contatos

    /**
     * Construtor padrão para um objeto da classe Agenda.
     */
    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    /**
     * Retorna o tamanho da lista de contatos da agenda.
     * @return a lista de contatos da agenda.
     */
    public int tamanho() {
        return this.contatos.size();
    }

    /**
     * Adiciona um novo contato a agenda.
     * @param c contato a ser adicionado.
     */
    public void addContato(Contato c) {
        this.contatos.add(c);
    }

    /**
     * Busca um contato na agenda a partir de seu nome.
     * @param nome o nome do contato.
     * @return o contato, caso ele seja encontrado, ou null, caso o contato não tenha sido encontrado.
     */
    public Contato buscarContato(String nome) {
        for(Contato c: this.contatos) {
            if(c.getNome().equals(nome))
                return c;
        }
        return null;
    }

    /**
     * Busca um contato na agenda a partir de seu CPF/CNPJ.
     * @param cp CPF ou CNPJ do contato.
     * @return o contato, caso ele seja encontrado, ou null, caso o contato não tenha sido encontrado.
     */
    public Contato buscarContato(long cp) {
        for (Contato c : this.contatos) {
            if ((c instanceof PessoaFisica && ((PessoaFisica) c).getCpf() == cp)
                    || (c instanceof PessoaJuridica && ((PessoaJuridica) c).getCnpj() == cp))
                return c;
        }
        return null;
    }

    /**
     * Remove um contato da agenda a partir de seu nome.
     * @param nome nome do contato a ser removido.
     * @return true caso o contato tenha sido removido com sucesso ou false caso o contato não tenha sido achado.
     */
    public boolean removerContato(String nome) {
        Contato c = this.buscarContato(nome);
        if(c != null) {
            this.contatos.remove(c);
            return true;
        }
        return false;
    }

    /**
     * Remove um contato da agenda a partir de seu CPF ou CNPJ.
     * @param cp CPF ou CNPJ do contato a ser removido.
     * @return true caso o contato tenha sido removido com sucesso ou false caso o contato não tenha sido achado.
     */
    public boolean removerContato(long cp) {
        Contato c = this.buscarContato(cp);
        if(c != null) {
            this.contatos.remove(c);
            return true;
        }
        return false;
    }

    /**
     * Utiliza o algoritmo de ordenação por inserção para ordenar em ordem crescente os contatos da agenda de acordo com seus CPF/CNPJ. Pessoas físicas aparecerão antes de pessoas jurídicas.
     */
    public void ordenar() {
        ArrayList<Contato> pf = new ArrayList<>();
        ArrayList<Contato> pj = new ArrayList<>();

        for(Contato c: this.contatos) {
            if(c instanceof PessoaFisica)
                this.inserir_ordenado(pf, c, ((PessoaFisica) c).getCpf());
            else
                this.inserir_ordenado(pj, c, ((PessoaJuridica) c).getCnpj());
        }

        pf.addAll(pj);
        this.contatos = pf;
    }

    /**
     * Método auxiliar para a ordenação por inserção. Insere, seguindo a ordenação de uma lista já ordenada, um contato na lista dada.
     * @param lista lista de contatos.
     * @param contato contato a ser inserido na lista.
     * @param cp CPF ou CNPJ do contato.
     */
    private void inserir_ordenado(ArrayList<Contato> lista, Contato contato, long cp) {
        for(int i = 0; i < lista.size(); i++) {
            Contato c = lista.get(i);
            long cp2 = (c instanceof PessoaFisica) ? ((PessoaFisica) lista.get(i)).getCpf() : ((PessoaJuridica) lista.get(i)).getCnpj();
            if(cp < cp2) {
                lista.add(i, contato);
                return;
            }
        }
        lista.add(contato); //executado caso a lista esteja vazia ou não haja CP menor.
    }

    /**
     * Possibilita a visualização da agenda.
     * @return uma String formatada com os CPFS/CNPJ e os nomes do contatos da agenda.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Contato c: this.contatos) {
            long cp = (c instanceof PessoaFisica) ? ((PessoaFisica) c).getCpf() : ((PessoaJuridica) c).getCnpj();
            str.append(String.format("[%d] %s\n", cp, c.getNome()));
        }
        return str.toString();
    }

    /**
     * Limpa a agenda de contatos (remove todos os contatos).
     */
    public void limpar() {
        this.contatos.clear();
    }
}
