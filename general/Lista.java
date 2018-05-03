
/**
 * Lista de jogadores.
 *
 * @author Rafael
 * @version 1.0
 */
public class Lista
{
    public Nodo inicio;
    public int contador = 0;
    /**
     * Constructor for objects of class Lista
     */
    public Lista()
    {
        // initialise instance variables
        this.inicio = null;
    }

    //método interno para inserir um jogador na lista
    private void push (Jogador val)
    {
        Nodo node = new Nodo(val);
        node.prox = this.inicio;
        this.inicio = node;
    }

    /**
     * insereJogador (string nome)
     * @param nome nome recebido da UI.
     * 
     */
    public void insereJogador (String nome)
    {
        Jogador j = new Jogador(nome);
        push(j);
        this.contador++;
    }

    public String getStrLista ()
    {
        Nodo nav = inicio;
        String str = nav.info.getNome();
        while (nav.prox != null)
        {
            nav = nav.prox;
            str = str + "\n" + nav.info.getNome();
        }
        return str;
    }

    public Nodo procuraNome (String name)
    {
        Nodo posicao = inicio;
        while ( posicao != null )
        {
            if (name.equalsIgnoreCase(posicao.info.getNome()))
            {
                break; //sai do laco ao achar a posicao
            }
            else
            {
                if (posicao.prox != null)
                {
                    posicao = posicao.prox; //prepara para próxima iteração
                }
                else 
                {
                    posicao = null;
                    break; //sai do laco se nao achar
                }
            }
        }
        return posicao;    
    }

}
