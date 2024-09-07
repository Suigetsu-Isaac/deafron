package drafeon;

public class Habilidades {

    //nomes e descrições de todas as habilidades:
    private String cortelaminarNome = "cortelaminar";
    private String cortelaminaraDescricao;
    
    public String getCortelaminarNome() {
        return cortelaminarNome;
    }

    public void setCortelaminarNome(String cortelaminaraNome) {
        this.cortelaminarNome = cortelaminaraNome;
    }

    public String getCortelaminaraDescricao() {
        return cortelaminaraDescricao;
    }

    public void setCortelaminaraDescricao(String cortelaminaraDescricao) {
        this.cortelaminaraDescricao = cortelaminaraDescricao;
    }


    public String recuperecao(Personagem agente, Personagem alvo){
        agente.setDEF(agente.getDEF() - 1);
        String mensagem = "algo deu errado";

        alvo.setHP(alvo.getHP() + 2);
        if(alvo.getHP()>3) {alvo.setHP(3);}

        mensagem = "A vida de: "+alvo.getNome()+ " foi recuperada em 2 ao custo de 1 de defesa";

        return mensagem;
    }
    public String cortelaminar(Personagem agente, Personagem alvo) {
        //reduzir o atk do agente em 1 como custo.
        agente.setATK(agente.getATK() - 1);
        String mensagem = "algo deu errado";
        if (alvo.getDEF() >= 1) {
            alvo.setDEF(alvo.getDEF() - 2);
            mensagem = alvo.getNome() + " bloqueia gastando " + 2 + " de defesa";
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                mensagem = alvo.getNome() + " é acertado, recebendo " + 1 + " de dano ao seu HP";
            }
        } else if (alvo.getDEF() <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            mensagem = alvo.getNome() + " é acertado, recebendo " + 2 + " de dano";
        }
        return mensagem;
    }

    public String recuperarDescricao(){
        return "Recupera 2 de vida. Custo: 1 de defesa";
    }
    public String corteLaminarDesc() {
        cortelaminaraDescricao = "Desfere um poderoso ataque cortante em um alvo, causando 2 de dano. Custo: 1 de ataque";
        return cortelaminaraDescricao;
    }
}

