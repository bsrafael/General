
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
    /**
     * Constructor for objects of class Jogador
     */
    public Jogador(String name)
    {
        // initialise instance variables
        this.nome = setNome(name);
    }

    /**
     * @param  name  nome a ser recebido da interface
     * @return    nome (minúsculo) a ser atribuído para a instância de Jogador
     */
    public String setNome(String name)
    {
        return name.toLowerCase();
    }
  
    public String getNome()
    {
        return this.nome;
    }
  
    
}
