package drafeon;

public class Teste2 {

    public static void main(String[] args){
        Personagem p1 = new Personagem("p1",3,3,3);
        Personagem p2 = new Personagem("p2",2,3,1);
        Habilidades h = new Habilidades();

        System.out.println(h.cortelaminar(p1,p2));
        System.err.println("Personagem atacante: "+p1.getATK());

        System.out.println("Personagem defensor: "+p2.getDEF());

        System.out.println(h.recuperecao(p1, p2));
         System.err.println("Personagem agente: "+p1.getDEF());

        System.out.println("Personagem alvo: "+p2.getHP());

    }
    
}
