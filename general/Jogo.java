import java.util.Arrays;
/**
 * Jogo: classe que executa o jogo em si.
 *
 * @author Rafael
 * @version V1.0
 */

public class Jogo
{
    private Dados copoDados = new Dados();
    
    private Jogador player1;
    private Jogador player2;

    public Jogo(Jogador j1, Jogador j2)
    {
        UI.exibe("<- novo jogo ->");
        player1 = j1;
        player2 = j2;
        
        startGame(player1, player2);
    }

    //início de jogo e execução das rodadas
    private void startGame(Jogador player1, Jogador player2)
    {
        int ptsJ1 = 0;
        int ptsJ2 = 0;
        UI.exibe("\n• • • • • Nova partida • • • • •");
        UI.exibe("");
        UI.exibe("\t Jogador 1: " + player1.getNome() + "\t\t Jogador 2: " + player2.getNome()); 
        
        ptsJ1 = Rodada(player1);
        ptsJ2 = Rodada(player2);
        
        endGame(player1, ptsJ1, player2, ptsJ2);
    }

    //fim de jogo e "cálculo" do vencedor
    private void endGame(Jogador player1, int ptsJ1, Jogador player2, int ptsJ2)
    {
        UI.exibe("\n\n");
        UI.exibe("• • • • O jogo terminou. • • • •");
        UI.exibe("Jogador 1: " + player1.getNome() + " -- pontuacao: "+ptsJ1);
        UI.exibe("Jogador 2: " + player2.getNome() + " -- pontuacao: "+ptsJ2);
        if (ptsJ1 > ptsJ2)
        {
            UI.exibe(player1.getNome() + " você ganhou!");
            player1.aumentaVitorias();
        }
            
        else if (ptsJ2 > ptsJ1)
        {
            UI.exibe(player2.getNome() + " você ganhou!");
            player2.aumentaVitorias();
        }
            
        else 
        {
            UI.exibe("Empate. Parabéns aos dois!");
            player1.aumentaEmpates();
            player2.aumentaEmpates();
        }

        player1.aumentaParticipacoes();
        player2.aumentaParticipacoes();

        player1.aumentaPontos(ptsJ1);
        player2.aumentaPontos(ptsJ2);
    }

    //rodada e "cálculo" dos dados
    private int Rodada(Jogador currentPlayer)
    {
        int pts=0;
        int aceitaDados = -1;
        int numDadosParaTrocar = -1;
        int rolagensRestantes = 3;
        int le;
        int i;

        //início da rodada
        UI.exibe("\n• • •"+currentPlayer.getNome()+", sua vez!");
        
        //geração e validação dos dados
        this.copoDados.geraTodosOsDados();
        while (rolagensRestantes > 0 && aceitaDados != 1)
        {
            aceitaDados = validaDados(rolagensRestantes); //pergunta se o usuário aceita os dados.
            if (aceitaDados==0)
            {
                UI.exibe("Quantos dados você quer trocar?");
                do
                {
                    numDadosParaTrocar = UI.leInt();
                } while (numDadosParaTrocar < 1 || numDadosParaTrocar>6);

                for (i=1; i<=numDadosParaTrocar; i++)
                {
                    UI.exibe("Troca numero "+(i) + ". Qual dado voce quer trocar?");
                    do
                    {
                        le = UI.leInt();
                    } while (le < 1 || le > 5);
                    this.copoDados.trocaDado(le);
                }
            }
            else
            {
                UI.exibe("problema seu. Já implemento o que acontece aqui.");
                break;
            }
            rolagensRestantes--;
        }
        //fim: geração e validação dos dados

        //exibição dos dados já validados pelo jogador
        UI.exibe("\n\n\n");
        UI.exibe("• Estes são seus dados:");
        UI.exibe(this.copoDados.getStrDados());

        pts = acao();

        return pts;
    }

    private int acao()
    {
        int i=0;
        int pontuacao[] = new int[6];

        pontuacao[0] = 0;
        pontuacao[1] = checkSequencia();
        pontuacao[2] = checkFullHand();
        pontuacao[3] = checkCombinacao();
        pontuacao[4] = checkQuadra();
        pontuacao[5] = checkGeneral();

        UI.exibe(" • O que voce gostaria de fazer?");
        UI.exibe("  ├─ 1. pontuar como Sequência   | "+pontuacao[1] + " pontos");
        UI.exibe("  ├─ 2. pontuar como Full Hand   | "+pontuacao[2] + " pontos");
        UI.exibe("  ├─ 3. pontuar como Combinação  | "+pontuacao[3] + " pontos");
        UI.exibe("  ├─ 4. pontuar como Quadra      | "+pontuacao[4] + " pontos");
        UI.exibe("  └─ 5. pontuar como General     | "+pontuacao[5] + " pontos");

        do
        {
            i = UI.leInt();
            if(pontuacao[i] == 0)
            {
                UI.exibe(" !! Você não tem pontos nessa opção !!");
                //continue;
            }
                
        } while ((i<1 || i>5) || pontuacao[i] == 0 );
        UI.exibe("  Sábia escolha. Você marcou " + pontuacao[i] + " pontos.");
        return pontuacao[i];
    }

    //pergunta se o usuário aceita os dados.
    private int validaDados(int c)
    {
        int ad = -1;
        UI.exibe(this.copoDados.getStrDados());
        UI.exibe("Você tem "+c+" rolagens restantes nesta rodada.");
        UI.exibe(" Você aceita esses dados?");
        UI.exibe("  0. Não.");
        UI.exibe("  1. Sim!");
        do
        {
            ad = UI.leInt();
        } while (ad < 0 || ad > 1);
        return ad;
    }

    /*** verificações para as possibilidades de pontuação ***/
    //sequencia -> ok
    private int checkSequencia()
    {
        int resposta = 0;
        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {2,3,4,5,6};
        int[] seq3 = {1,3,4,5,6}; //3,4,5,6,1
        
        //o vetor de dados é ordenado.
        int[] dados = this.copoDados.getTodosOsDados();

        if (Arrays.equals(seq1, dados) || Arrays.equals(seq2, dados) || Arrays.equals(seq3, dados))
        {
            resposta = 20;
        }
        else
        {
            resposta = 0;
        }
        return resposta;
    }

    //fullhand -> ok
    private int checkFullHand()
    {
        int resposta = 0;
        int i;
        int[] dados = this.copoDados.getTodosOsDados();
        int trinca = checkTrinca();
        if (trinca > 0)
        {
            int repetido = trinca/3;
            for (i=0; i<dados.length - 1; i++)
            {
                if (dados[i] != repetido && dados[i] == dados[i+1])
                {
                    resposta = 2*dados[i] + trinca + 30;
                }
            }

        }
        return resposta;
    }

    //trinca -> ok
    //usado no fullhand e na combinacao simples
    private int checkTrinca()
    {
        int resposta = 0;
        int i;
        int[] dados = this.copoDados.getTodosOsDados();
        for (i=1; i<dados.length - 1; i++)
        {
            if (dados[i-1] == dados[i] && dados[i] == dados[i+1])
            {
                resposta = 3*dados[i];
            }
        }

        return resposta;
    }

    //quadra -> ok
    private int checkQuadra()
    {
        int resposta = 0;
        int i;
        int[] dados = this.copoDados.getTodosOsDados();
        for (i=1; i<dados.length - 2; i++)
        {
            if (dados[i-1] == dados[i] && dados[i] == dados[i+1] && dados[i] == dados[i+2])
            {
                resposta = 4*dados[i] + 40;
            }
        }
        return resposta;
    }

    //general -> ok
    private int checkGeneral()
    {
        int resposta = 0;
        int[] dados = this.copoDados.getTodosOsDados();
        if  (dados[0] == dados[1] && dados[1] == dados[2] &&
             dados[2] == dados[3] && dados[3] == dados[4] &&
             dados[4] == dados[5])

            resposta = 5*dados[0] + 50;
        //code
        return resposta;
    }

    //combinacao -> ok
    private int checkCombinacao()
    {
        int i;
        int resposta = 0;
        int trinca=0;
        int dupla=0;
        int dados[] = this.copoDados.getTodosOsDados();

        trinca = checkTrinca();
    
        for (i=0; i<dados.length -1; i++)
        {
            if (dados[i] == dados[i+1])
                dupla = 2*dados[i];
        }

        resposta = dados[dados.length-1];
        if (dupla > resposta)
        {
            resposta = dupla;
        }
        if (trinca > resposta)
        {
            resposta = trinca;
        }
        return resposta;
    }

    /*** fim: verificações para as possibilidades de pontuação ***/

}
