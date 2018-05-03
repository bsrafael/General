
/**
 * Jogo: classe que executa o jogo em si.
 *
 * @author Rafael
 * @version V1.0
 */

///import java.text.DecimalFormat;

public class Jogo
{
    private int contadorRodadas=0;
    private Dados dado = new Dados();
    
    private Jogador player1;
    private Jogador player2;
    public Jogo(Jogador j1, Jogador j2)
    {
        UI.exibe("<- novo jogo ->");
        player1 = j1;
        player2 = j2;
        player1.score = new Pontuacao();
        player2.score = new Pontuacao();
        
        startGame(player1, player2);
    }

    private void startGame(Jogador player1, Jogador player2)
    {
        UI.exibe("\n• • • Nova partida • • •");
        UI.exibe("");
        UI.exibe("\t Jogador 1: " + player1.getNome() + "\t\t Jogador 2: " + player2.getNome()); 

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
        UI.exibe(Pontuacao.tableHeader);
        UI.exibe(player1.score.strPoints(player1.getNome()));
        UI.exibe(player2.score.strPoints(player2.getNome()));
    }

    private void endGame()
    {
        showHeader();
        UI.exibe("O jogo terminou.");

    }
}
