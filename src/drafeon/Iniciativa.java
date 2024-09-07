package drafeon;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Iniciativa {
    private ArrayList<Personagem> ordem;
    private int indiceAtual;

    public Iniciativa(ArrayList<Personagem> aliados, ArrayList<Personagem> inimigos) {
        this.ordem = new ArrayList<>();
        this.ordem.addAll(aliados);
        this.ordem.addAll(inimigos);
        Collections.shuffle(this.ordem); // Embaralha a lista para uma ordem aleatória
        this.indiceAtual = 0;
    }

    public Personagem getAtual() {
        return ordem.get(indiceAtual);
    }

    public Personagem proximo() {
        indiceAtual = (indiceAtual + 1) % ordem.size();
        return ordem.get(indiceAtual);
    }

    public void mostrarOrdem() {
       String titulo = ("Ordem de iniciativa:");
       String ord = "";
        for (Personagem p : ordem) {
            ord += p.getNome()+"\n";
        }
        JOptionPane.showMessageDialog(null, ord, titulo, 1);
    }
}
