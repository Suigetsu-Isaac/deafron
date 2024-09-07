package drafeon;

import java.util.ArrayList;

public class CampoDeBatalha {
    private ArrayList<Personagem> aliados;
    private ArrayList<Personagem> inimigos;

    public CampoDeBatalha() {
        this.aliados = new ArrayList<>(4);
        this.inimigos = new ArrayList<>(4);
    }

    public String inserirAliado(Personagem personagem) {
        if (aliados.size() < 4) {
            aliados.add(personagem);
            return (personagem.getNome() + " foi adicionado aos aliados.");
        } 
        return ("O grupo de aliados está cheio. Não é possível adicionar mais personagens.");
        
    }

    public String inserirInimigo(Personagem personagem) {
        if (inimigos.size() < 4) {
            inimigos.add(personagem);
            return (personagem.getNome() + " foi adicionado aos inimigos.");
        } 
        return("O grupo de inimigos está cheio. Não é possível adicionar mais personagens.");
        
    }

    public ArrayList<Personagem> getAliados() {
        return aliados;
    }

    public ArrayList<Personagem> getInimigos() {
        return inimigos;
    }

    public String mostrarAliados() {
        String mensagem = "Aliados: \n";
        
        for (int i = 0; i < aliados.size(); i++) {
            mensagem +=("Posição " + (i + 1) + ": " + aliados.get(i).getNome());
        }
        return mensagem;
    }

    public String mostrarInimigos() {
        String mensagem = ("Inimigos:");
        for (int i = 0; i < inimigos.size(); i++) {
            mensagem +=("Posição " + (i + 1) + ": " + inimigos.get(i).getNome());
        }
        return mensagem;
    }
}
