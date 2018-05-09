
import java.util.Scanner;

/**
 * Interface do Usuário.
 *
 * @author Rafael
 * @version 1.0
 */
public class UI
{
	Lista LJogadores = new Lista();
	
	public UI()
    {
       	menu();
	}

	private void menu()
	{
		while (true)
			switch (opcao())
			{
				case 0: sair();	                  	break; 
				case 1: novoJogador(LJogadores);	break; 
				case 2: exibirJogadores(LJogadores);break; 
				case 3: iniciarJogo();	          	break; 
			}
	}
	private int opcao()
	{
		Scanner scan = new Scanner(System.in);
		int i = -1;
		do
		{
			exibeMenu();
			i = scan.nextInt();
			scan.nextLine(); //limpar buffer
		} while (i<0 || i>3);
		scan.close();
		return i;
	}

	private void exibeMenu()
	{
		System.out.println("\n\n");
		System.out.println("•  •  •  •  •     General V1.0     •  •  •  •  •");
		System.out.println(" Digite sua escolha: ");
		System.out.println(" 0. Sair");
		System.out.println(" 1. Cadastrar novo jogador");
		System.out.println(" 2. Exibir os jogadores");
		System.out.println(" 3. Iniciar o jogo");
		System.out.println("");
	}

	private void sair()
	{
		System.out.println("");
		System.out.println("Obrigado por jogar !!!");
		System.out.println("\n\n\n");
		System.exit(0);
	}
	private void novoJogador(Lista LJogadores)
	{
		Scanner scan = new Scanner(System.in);
		String nome;
		System.out.println("Digite o nome do novo jogador: ");
		nome = scan.nextLine();
		scan.close();
		LJogadores.insereJogador(nome);
	}

	private void exibirJogadores(Lista LJogadores)
	{
		System.out.println("\nJogadores já cadastrados: ");
		System.out.println(LJogadores.getStrLista());
	}

	private void exibirRanking(Lista LJogadores)
	{
		
	}

	private void iniciarJogo()
	{
		Jogador j1;
		Jogador j2;
		Scanner scan = new Scanner(System.in);
		String s_aux;
		Nodo n_aux;
		if (LJogadores.contador < 2)
		{
			System.out.println("É preciso ter pelo menos dois jogadores cadastrados.");
		}
		else
		{
			if (LJogadores.contador == 2)
			{
				j1 = LJogadores.inicio.info;
				j2 = LJogadores.inicio.prox.info;
			}
			else
			{
				System.out.println("\nQuem vai jogar?\n");
				
				//jogador 1
				do
				{
					System.out.println("∞ Digite o nome do jogador1: ");
					s_aux = scan.nextLine();
					n_aux = LJogadores.procuraNome(s_aux);
				} while (n_aux == null);
				j1 = n_aux.info;

				//jogador 2
				do
				{
					System.out.println("∞ Digite o nome do jogador2: ");
					s_aux = scan.nextLine();
					n_aux = LJogadores.procuraNome(s_aux);
				} while (n_aux == null);
				j2 = n_aux.info;
			}
			new Jogo(j1, j2);
		}
		scan.close();
	}

	/* interface para outras classes */
	public static void exibe (String message)
	{
		System.out.println(message);
	}

	public static int leInt()
	{
		int aux;
		Scanner scan = new Scanner(System.in);
		aux = scan.nextInt();
		scan.close();
		return aux;
	}




}
