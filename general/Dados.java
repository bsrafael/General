import java.util.Random;
/**
 * "Copo de Dados" para o jogo. Contém 5 dados de seis lados.
 *
 * @author Rafael
 * @version V1.0
 */
public class Dados
{
    public int[] dados = new int[5];
    /**
     * Constructor for objects of class CopoDados
     */
    public Dados()
    {
        int i;
        for (i=0;i<5;i++)
            dados[i] = 0;
    }

    public int setDado()
    {
        Random rand = new Random();
        return rand.nextInt(6) + 1; //retorna 1 + número entre 0 a 5 
    }
    public int getDado(int required_index)
    {
        return dados[required_index];
    }
    
    public void geraTodosOsDados()
    {
        int i, j, aux;
        for (i=0;i<5;i++)
            dados[i] = setDado();

        //ordenação dos dados.  
        for (i=0; i<5; i++)
        {
            for (j=5-1; j>=0; j--)
            {
                if (dados[i] > dados[j])
                {
                    aux = dados[i];
                    dados[i] = dados[j];
                    dados[j] = aux;
                }
            }
            
        }
    }
    
    public void imprimeDados()
    {
        int i;

        int[] value = this.dados;

        //linha 0: borda superior
        for (i=0; i<value.length; i++)
            System.out.print("\t╔═══════╗");
        System.out.println("");

        //linha 1: ponto branco quando 1; esquerdo quando 2 e 3; esquerdo e direito quando 4,5,6
        for (i=0; i<value.length; i++)
            if(value[i] > 3)
                System.out.print("\t║ •   • ║");
            else if(value[i] == 1)
                System.out.print("\t║       ║");
            else 
                System.out.print("\t║ •     ║");
        System.out.println("");

        //linha 2: ponto centralizado quando ímpar; branco quando 2 e 4; esquerdo e direito quando 6.
        for (i=0; i<value.length; i++)
            if(value[i] % 2 == 1)
                System.out.print("\t║   •   ║");
            else if(value[i] == 6)
                System.out.print("\t║ •   • ║");
            else 
                System.out.print("\t║       ║");
        System.out.println("");


        //linha 3: ponto branco quando 1; direito quando 2 e 3; esquerdo e direito quando 4,5,6
        for (i=0; i<value.length; i++)
            if(value[i] > 3)
                System.out.print("\t║ •   • ║");
            else if(value[i] == 1)
                System.out.print("\t║       ║");
            else 
                System.out.print("\t║     • ║");
        System.out.println("");

        //linha 4: borda inferior
        for (i=0; i<value.length; i++)
            System.out.print("\t╚═══════╝");
        System.out.println("");

        //linha 5: referência do dado
        for (i=0; i<value.length; i++)
            System.out.print("\t dado: " + (i+1) );
        System.out.println("");
        
        
    }
}
