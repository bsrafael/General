
/**
 * Jogo: classe que executa o jogo em si.
 *
 * @author Rafael
 * @version V1.0
 */

public class Jogo
{
    private int contadorRodadas=0;
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

    private void startGame(Jogador player1, Jogador player2)
    {
        UI.exibe("\n• • • Nova partida • • •");
        UI.exibe("");
        UI.exibe("\t Jogador 1: " + player1.getNome() + "\t\t Jogador 2: " + player2.getNome()); 
        
        player1.aumentaParticipacoes();
        player2.aumentaParticipacoes();

        Rodada(player1);
        Rodada(player2);
        
        endGame();
    }

    private int Rodada(Jogador currentPlayer)
    {
        int pts=0;
        int aceitaDados = -1;
        int numDadosParaTrocar = -1;
        int rolagensRestantes = 3;
        int le;
        int i;
        UI.exibe("\n•••••"+currentPlayer.getNome()+", sua vez!");
        
        copoDados.geraTodosOsDados();
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
                    copoDados.trocaDado(le);
                }
            }
            else
            {
                UI.exibe("problema seu. Já implemento o que acontece aqui.");
                break;
            }
            rolagensRestantes--;
        }
        UI.exibe("\n\n\n");
        UI.exibe("Estes são seus dados:");
        UI.exibe(copoDados.getStrDados());

        

        return pts;
    }


    private void endGame()
    {
        //showHeader();
        UI.exibe("O jogo terminou.");

    }

    private int validaDados(int c)
    {
        int ad = -1;
        UI.exibe(copoDados.getStrDados());
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

    private int checkSequencia()
    {
        int resposta = 0;
        //code
        return resposta;
    }

    private int checkFullHand()
    {
        int resposta = 0;
        //if (checkTrinca()!=0 && checkQuadra()!=0)
        //code
        return resposta;
    }

    private int checkTrinca()
    {
        int resposta = 0;
        //code
        return resposta;
    }

    private int checkQuadra()
    {
        int resposta = 0;
        //code
        return resposta;
    }

    private int checkGeneral()
    {
        
        int resposta = 0;
        
        //code
        return resposta;
    }

}
