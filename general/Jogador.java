
/**
 * Write a description of class Jogador here.
 *
 * @author Rafael
 * @version 1.0
 */
public class Jogador
{
    // instance variables - replace the example below with your own
    private String nome;

    private int countVitorias;
    private int countParticipacoes;
    private int countEmpates;
    private int somatorioPontos;
    
    /**
     * Constructor for objects of class Jogador
     */
    public Jogador(String name)
    {
        // initialise instance variables
        this.nome               = setNome(name);
        this.countParticipacoes = 0;
        this.countEmpates       = 0;
        this.countVitorias      = 0;
        this.somatorioPontos    = 0;
    }


    public String setNome(String name)
    {
        return name.toLowerCase();
    }
  
    public String getNome()
    {
        return this.nome;
    }

    public void aumentaParticipacoes()
    {
        this.countParticipacoes++;
    }
    public int getParticipacoes()
    {
        return this.countParticipacoes;
    }

    public void aumentaEmpates()
    {
        this.countEmpates++;
    }
    public int getEmpates()
    {
        return this.countEmpates;
    }

    public void aumentaVitorias()
    {
        this.countVitorias++;
    }
    public int getVitorias()
    {
        return this.countVitorias;
    }

    public void aumentaPontos(int pts)
    {
        this.somatorioPontos += pts;
    }
    public int getPontos()
    {
        return this.somatorioPontos;
    }

    public String getStrJogador()
    {
        String str = " ";
        str = str + getNome() +"\t |   "+countVitorias +"    |   "+countParticipacoes +"   |    "+countEmpates +"    |    "+somatorioPontos;   
        return str;
    }
    
}
