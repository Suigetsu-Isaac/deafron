package drafeon;

import java.util.ArrayList;

public class Interpretador {

    // Método que processa a string
    public Interpretador(String input) {
        String palavra1 = "";
        String palavra2 = "";
        String palavra3 = "";
        int quantidadeDePalavras = 0;
        Personagem objPersonagem;

        //verificar quantos espaos vazios tem no input para definir quantidade de palavras através de um if
        // Remove espaços em excesso e divide a string por espaços e vírgulas
        String[] palavras = input.split("[,\\s]+");

//ABAIXO VERIFICAR QUANTIDADE DE PALAVRES
        // Exibir o número de palavras
        quantidadeDePalavras = palavras.length;
        System.out.println("Número de palavras: " + quantidadeDePalavras);

        // Armazena as palavras em variáveis
        if (quantidadeDePalavras == 1) {
            palavra1 = palavras.length > 0 ? palavras[0] : "";
        } else if (quantidadeDePalavras == 2) {
            palavra1 = palavras.length > 0 ? palavras[0] : "";
            palavra2 = palavras.length > 1 ? palavras[1] : "";
        } else if (3 == quantidadeDePalavras) {
            palavra1 = palavras.length > 0 ? palavras[0] : "";
            palavra2 = palavras.length > 1 ? palavras[1] : "";
            palavra3 = palavras.length > 2 ? palavras[2] : "";
        } else {
            //retorna mensagem de erro
        }

        //designa ação baseada no comando passado pelo jogador
        if (quantidadeDePalavras == 1) {
            //chama todos os métodos chamados por uma palavra
            if (palavra1 == "ajuda" || palavra1 == "help") {
                ajuda();
            }

        } else if (quantidadeDePalavras == 2) {

            //chama todos os métodos chamados por uma palavra
        } else if (quantidadeDePalavras == 3) {
            if (palavra1.equals("x")){
                System.out.println("x");
            }
            //chama todos os métodos chamados por uma palavra
        } else {
            //mensagem de erro
        }
    }
    //Método que verifica se o alvo é válido o e retorna:
    public Object verificarPersonagem(String alvo, ArrayList<Personagem> personagens) {
        //tri catchs que verificam se um alvo é válido
    for (Personagem personagem : personagens){
    if (personagem.getNome().equalsIgnoreCase(alvo)) {
         return personagem;//.getNome();
         
            }
        
        }
    return "ERROR";
    }

    public String cortelaminar(String alvo, String agente, ArrayList personagens){
        Object resposta1;
        Object resposta2;
        resposta1 = verificarPersonagem(alvo, personagens);
        resposta2 = verificarPersonagem(agente, personagens);

        //verifica se
        return "foi deu certo"; 
    }


public String verificarAcao(String acao){
if (true) {
    
}
return "ERROR!";
}

    //a seguir, método chamados por uma só palavra:

    public String ajuda() {
        return "texto de ajuda";
    }

    public String sair() {
        //cria janela de confirmação na tela
        //alterna para a tela do menu inicial
        return "Saindo";
    }

    public String verStatus(){
        return "adicionar retorno";
    }

    }
