import java.util.Random;
/**
 * "Copo de Dados" para o jogo. Contém 5 dados de seis lados.
 *
 * @author Rafael
 * @version V1.0
 */
public class Dados
{
    private int[] dados = new int[5];
    
    public Dados()
    {
        int i;
        for (i=0;i<5;i++)
            dados[i] = 0;
    }

    private int setDado()
    {
        Random rand = new Random();
        return rand.nextInt(6) + 1; //retorna 1 + número entre 0 a 5 
    }
    public int getDado(int required_index)
    {
        return this.dados[required_index];
    }
    
    public int[] getTodosOsDados()
    {
        return this.dados;
    }

    public String getStrDados()
    {
        String output="  ";
        int i;
        ordenaDados();
        
        for (i=0; i<dados.length; i++)
        {
            output = output + "∞ Dado "+ (i+1) + ": " + dados[i] + "\t";
        }
        return output;
    }

    public void geraTodosOsDados()
    {
        for (int i=0;i<5;i++)
            this.dados[i] = setDado();
        ordenaDados();
    }

    public void trocaDado(int dado_number)
    {
        this.dados[dado_number - 1] = setDado();
    }

    private void ordenaDados()
    {
        int aux;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<4; j++){
                if(this.dados[j] > this.dados[j + 1]){
                    aux = this.dados[j];
                    this.dados[j] = this.dados[j+1];
                    this.dados[j+1] = aux;
                }
            }
        }

    }
}
