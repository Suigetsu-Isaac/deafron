package drafeon;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Personagem {
    private String nome;
    // Vida Atual
    private int HP;
    //Defesa Atual
    private int DEF;
    //Ataque Atual
    private int ATK;  
    // Vida Total
    private int totalHP;
    // Defesa Total
    private int totalDEF;
    // Ataque Total
    private int TotalATK;


    //lista de stings com o nome de três habilidades
    private ArrayList<String> habilidades; 
    
    public Personagem(String nome, int HP, int DEF, int ATK){
        this.nome = nome;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.totalHP = HP;
        this.TotalATK = ATK;
        this.totalDEF = DEF;
    }

    public void adicionarHabilidade(String habilidade){
        if (this.habilidades.size() < 3)
         this.habilidades.add(habilidade);
    }
   public String retornaHabilidade(int indice){
        return this.habilidades.get(indice);
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
       this.HP = verificaSetagem(HP);
         
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        
        this.DEF = verificaSetagem(DEF);
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = verificaSetagem(ATK);
    }
    
    public int verificaSetagem(int valor){
        if (valor > 3){
            valor = 3;
        }else if (valor < 0){
            valor = 0;
        }
        return valor;
    }
    
    //método demonstrativo para ser retirado.
    
    public String mostrarPersonagens(ArrayList<Personagem> personagens){
        String desc = "<html> <body> <p> Escolha um personagem para atacar: </p>";
        for (int i = 0; i < personagens.size(); i++) {
            desc += "<p>"+(i + 1) + ". " + personagens.get(i).getNome()+"</p>";
           
        }
        desc += "</html> </body>";
        return desc;
    }
    public void atacar(ArrayList<Personagem> personagens, JLabel textoJogo, JTextField inputJogo) {
        
        
        String desc = "<html> <body>";
        
        int escolha = Integer.parseInt(inputJogo.getText());
        Personagem alvo = personagens.get(escolha - 1);

        if (alvo.DEF >= 1) {
            alvo.setDEF(alvo.getDEF() - ATK);
          
            desc += (alvo.getNome() + " bloqueia gastando " + ATK + " de defesa \n");
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                desc +=(alvo.getNome() + " é acertado, recebendo " + 1 + " de dano \n");
            }
        } else if (alvo.DEF <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            desc +=(alvo.getNome() + " é acertado, recebendo " + 1 + " de dano \n");
        }
            
            desc += "</body> </html>";
        textoJogo.setText(desc);
    }
    
    public void mostrarStatus() {
        System.out.println(nome + ": HP - " + HP + ", Defesa - " + DEF + ", Ataque - " + ATK + "\n");
    }
    public void MostrarHabilidades() {
        
    }
}
