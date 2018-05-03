import java.text.DecimalFormat;

public class Pontuacao
{
    private int[] pts;
    public static String tableHeader = "\n\t| TOTAL |  1  |  2  |  3  |  4  |  5  |  6  |  T  |  Q  |  F  |  S+ |  S- |  G  |  X  |";

    public Pontuacao()
    {
        this.pts = new int[14];
        
        int i;
        for (i=0; i<this.pts.length; i++)
        {
            this.pts[i] = -1;
        }
    }

    public boolean checkWinner()
    {
        int i;
        int[] v = this.pts;
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

    public String strPoints(String source)
    {
        String aux;
        String output = source + "\t";
        DecimalFormat df = new DecimalFormat (" # ");
        int i;
        int[] v = this.pts;

        //cálculo para a posição "total" 
        v[0] = 0;
        for (i=1; i<v.length; i++)
        {
            v[0] += v[i];
        }

        //gravar "total" na string
        if (v[0] < 0) 
            aux = "   ";
        else
            aux = df.format(v[0]);

        output = output + "|  "+aux+"  |";

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

    private boolean checkPar(Dados d)
    {
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkTrinca(Dados d)
    {
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkQuadra(Dados d)
    {
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkGeneral(Dados d)
    {
        boolean resposta = false;
        //code
        return resposta;
    }

    private boolean checkFullhouse(Dados d)
    {
        boolean resposta = false;
        //code
        return resposta;
    }
    
    private int checkSequencia(Dados d)
    {
        int resposta = 0;
        //code
        return resposta;
    }

    public void verificaDisponiveis(int[] v, Dados dado)
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


}