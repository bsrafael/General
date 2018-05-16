
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

    public Lista()
    {
        this.inicio = null;
    }

    //método interno para inserir um jogador na lista
    private void push (Jogador val)
    {
        Nodo node = new Nodo(val);
        node.prox = this.inicio;
        this.inicio = node;
    }

    //método interno para ordenar a lista (chamado na exibição)
    private void ordenaLista()
    {
        Nodo nav = inicio;
        Jogador aux;
        int j=0;
        for (j=0; j<contador; j++)
        {
            while (nav.prox != null)
            {
        
                if (nav.info.getVitorias() <= nav.prox.info.getVitorias())
                {
                    //primeiro por vitórias
                    if (nav.info.getVitorias() < nav.prox.info.getVitorias())
                    {
                        aux = nav.info;
                        nav.info = nav.prox.info;
                        nav.prox.info = aux;
                    }
                    else
                    {
                        //depois por menos partidas jogadas
                        if (nav.info.getParticipacoes() > nav.prox.info.getParticipacoes())
                        {
                            aux = nav.info;
                            nav.info = nav.prox.info;
                            nav.prox.info = aux;
                        }
                        else if (nav.info.getParticipacoes() == nav.prox.info.getParticipacoes())
                        {
                            //depois por mais empates
                            if (nav.info.getEmpates() < nav.prox.info.getEmpates())
                            {
                                aux = nav.info;
                                nav.info = nav.prox.info;
                                nav.prox.info = aux;
                            }
                            else if (nav.info.getEmpates() == nav.prox.info.getEmpates())
                            {
                                //depois por mais pontos feitos
                                if (nav.info.getPontos() < nav.prox.info.getPontos())
                                {
                                    aux = nav.info;
                                    nav.info = nav.prox.info;
                                    nav.prox.info = aux;
                                }
                                else if (nav.info.getPontos() == nav.prox.info.getPontos())
                                {
                                    //em último caso, alfabético
                                    if (nav.info.getNome().compareToIgnoreCase(nav.prox.info.getNome()) > 0)
                                    {
                                        aux = nav.info;
                                        nav.info = nav.prox.info;
                                        nav.prox.info = aux;
                                    }
                                }
                            }
                        }
                    }
                }
                nav = nav.prox;
            }
            nav = inicio;
        }
    }

    //inserção de um novo jogador.
    public void insereJogador (String nome)
    {
        Jogador j = new Jogador(nome);
        push(j);
        this.contador++;
    }

    //obtenção de uma string ordenada com os elementos, para exibição
    public String getStrLista ()
    {
        int i=1;
        Nodo nav = this.inicio;
        String strLista;
        if (nav == null)
        {
            strLista = "nenhum jogador cadastrado.";
        }
        else
        {
            this.ordenaLista();
            strLista = i + "- " + nav.info.getStrJogador();
            while (nav.prox != null)
            {
                i++;
                nav = nav.prox;
                strLista = strLista + "\n" + i + "- "+ nav.info.getStrJogador();
            }
        }
        return strLista;
    }

    //busca o elemento na lista
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
