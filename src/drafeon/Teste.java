package drafeon;

public class Teste {
    public static void main(String[] args) {
        CampoDeBatalha campo = new CampoDeBatalha();

        // Criando 8 personagens
        Personagem p1 = new Personagem("Guerreiro", 100, 50, 30);
        Personagem p2 = new Personagem("Arqueiro", 80, 40, 25);
        Personagem p3 = new Personagem("Mago", 70, 30, 35);
        Personagem p4 = new Personagem("Cavaleiro", 120, 60, 20);
        Personagem p5 = new Personagem("Assassino", 90, 45, 40);
        Personagem p6 = new Personagem("Clérigo", 85, 35, 15);
        Personagem p7 = new Personagem("Bárbaro", 110, 55, 25);
        Personagem p8 = new Personagem("Paladino", 95, 50, 30);

        // Adicionando 4 personagens aos aliados
        campo.inserirAliado(p1);
        campo.inserirAliado(p2);
        campo.inserirAliado(p3);
        campo.inserirAliado(p4);

        // Adicionando 4 personagens aos inimigos
        campo.inserirInimigo(p5);
        campo.inserirInimigo(p6);
        campo.inserirInimigo(p7);
        campo.inserirInimigo(p8);

        // Mostrando os nomes dos personagens no campo de batalha
        campo.mostrarAliados();
        campo.mostrarInimigos();

        // Criando a iniciativa e mostrando a ordem dos personagens
        Iniciativa iniciativa = new Iniciativa(campo.getAliados(), campo.getInimigos());
        iniciativa.mostrarOrdem();

        //testes da classe Interpretador()
        Interpretador interpretador = new Interpretador("guerreiro");
        System.out.println(interpretador.verificarPersonagem("guerreiro", campo.getAliados()));
        //System.out.println(interpretador.verificarAcao("asfdasf"));
    }
}
