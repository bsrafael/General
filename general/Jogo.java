
/**
 * Jogo: classe que executa o jogo em si.
 *
 * @author Rafael
 * @version V1.0
 */

 import java.text.DecimalFormat;

public class Jogo
{
    
    private int contadorRodadas=0;
    private Dados dado = new Dados();
    private int[] ptsPlayer1= new int[14];
    private int[] ptsPlayer2= new int[14];
    private String tableHeader = "\n\t| TOTAL |  1  |  2  |  3  |  4  |  5  |  6  |  T  |  Q  |  F  |  S+ |  S- |  G  |  X  |";
    
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

        for (int i=0; i<14; i++)
        {
            this.ptsPlayer1[i]=0;
            this.ptsPlayer2[i]=0;
        }
        roundGame(); //inicia uma rodada (recursiva)
    }

    private void roundGame()
    {
        Jogador currentPlayer;
        contadorRodadas++;

        if (contadorRodadas > 1) UI.exibe("\n\n\n\n\n\n\n\n\n\n\n\n");
        showHeader(); //exibe o cabeçalho (com a pontuação mais recente)

        dado.geraTodosOsDados();
        dado.imprimeDados();
        if (contadorRodadas%2 == 1)
        {
            //jogador 1
        }
        else
        {
            //jogador 2
        }

        if (true)//(checkWinner(ptsPlayer1) || checkWinner(ptsPlayer2))
        {
            endGame();
        }
        else
        {
            roundGame();
        }
    }
    
    private void showHeader()
    {
        UI.exibe(tableHeader);
        UI.exibe(strPoints(ptsPlayer1, player1.getNome()));
        UI.exibe(strPoints(ptsPlayer2, player2.getNome()));
    }

    private boolean checkWinner(int[] v)
    {
        int i;
        boolean vencedor = true;
        for (i=0; i<v.length; i++)
        {
            if (v[i] == -1)
            {
                vencedor = false;
                break;
            }
        }
        return vencedor;
    }


    private String strPoints(int[] v, String source)
    {
        String output = source + "\t";
        DecimalFormat df = new DecimalFormat (" # ");
        int i;

        //cálculo para a posição "total" 
        v[0] = 0;
        for (i=1; i<v.length; i++)
        {
            v[0] += v[i];
        }

        //gravar "total" na string
        output = output + "|  "+df.format(v[0])+"  |";

        //gravar as outras posições na string
        for (i=1; i<v.length; i++)
        {
            if (v[i] < 0)
            {
                output = output + "     |";
            }
            else
            {
               output = output + " " +df.format(v[i]) + " |"; 
            }
            
        }
        return output;
    }

    private void endGame()
    {
        UI.exibe("\n\n\n\n\n\n\n\n\n\n\n\n");
        showHeader();
        UI.exibe("O jogo terminou.");

    }

    private void verificaDisponiveis(int[] v)
    {
        int i,j , aux;
        Dados d = dado;

        //varre o vetor e exibe quais as possíveis jogadas.
        for (i=1; i<=6; i++)
        {
            if (v[i] == -1) 
                for (j=1; j<d.dados.length; j++)
                {
                    if (d.dados[j] == i && d.dados[j] == d.dados[j-1])
                    {
                        UI.exibe("  01. jogada de "+i+" com dois dados");
                    }
                }
        }
    }

    private boolean checkPar()
    {
        Dados d = dado;
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkTrinca()
    {
        Dados d = dado;
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkQuadra()
    {
        Dados d = dado;
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkGeneral()
    {
        Dados d = dado;
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkFullhouse()
    {
        Dados d = dado;
        boolean resposta = false;
        //code
        return resposta;
    }
    
    private int checkSequencia()
    {
        Dados d = dado;
        int resposta = 0;
        //code
        return resposta;
    }
}
