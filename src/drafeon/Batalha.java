package drafeon;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Batalha {
    private CampoDeBatalha campo;
    private Iniciativa iniciativa;
    private boolean ataqueRealizado = false;

    public Batalha(CampoDeBatalha campo) {
        this.campo = campo;
        this.iniciativa = new Iniciativa(campo.getAliados(), campo.getInimigos());
    }

    public void iniciar(JLabel textoJogo, JTextField inputJogo, JButton botaoJogo) {
        SwingWorker<Void, String> batalhaWorker = new SwingWorker<Void, String>() {

            @Override
            protected Void doInBackground() throws Exception {
                boolean batalhaEmAndamento = true;

                while (batalhaEmAndamento) {
                    Personagem atual = iniciativa.getAtual();  // Pega o personagem atual

                    if (atual.getHP() > 0) {
                        ArrayList<Personagem> alvos = campo.getAliados().contains(atual) ? campo.getInimigos() : campo.getAliados();

                        // Verifica se todos os inimigos estão mortos
                        if (verificarTodosMortos(campo.getInimigos())) {
                            batalhaEmAndamento = false;
                            publish(formatarResultado("Aliados"));
                        } 
                        // Verifica se todos os aliados estão mortos
                        else if (verificarTodosMortos(campo.getAliados())) {
                            batalhaEmAndamento = false;
                            publish(formatarResultado("Inimigos"));
                        } 
                        // Se a batalha ainda está em andamento, processa o turno
                        else {
                            publish(atual.mostrarPersonagens(alvos));  // Atualiza a interface gráfica para mostrar os alvos

                            // Aguardando até que o ataque seja realizado
                            synchronized (this) {
                                while (!ataqueRealizado) {
                                    wait();  // Pausa o loop até o ataque ser realizado
                                }
                            }

                            ataqueRealizado = false;  // Reseta o estado para o próximo turno
                            iniciativa.proximo();  // Avança para o próximo personagem na lista de iniciativa
                        }
                    }
                    Thread.sleep(500);  // Adiciona um pequeno atraso para evitar loops rápidos demais
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                // Atualiza a interface com o texto da batalha
                for (String texto : chunks) {
                    textoJogo.setText(texto);
                }
            }

            @Override
            protected void done() {
                // O que acontece quando a batalha termina
                textoJogo.setText("Batalha finalizada!");
            }
        };

        batalhaWorker.execute();  // Inicia a thread em background

        // Configura o botão de ataque para realizar a ação
        botaoJogo.addActionListener(e -> {
            Personagem atual = iniciativa.getAtual();  // Pega o personagem atual da iniciativa
            ArrayList<Personagem> alvos = campo.getAliados().contains(atual) ? campo.getInimigos() : campo.getAliados();

            // Realiza o ataque
            atual.atacar(alvos, textoJogo, inputJogo);

            // Notifica a thread que o ataque foi realizado
            synchronized (batalhaWorker) {
                ataqueRealizado = true;
                batalhaWorker.notify();  // Continua o loop da batalha
            }
        });
    }

    // Método para verificar se todos os personagens de um time estão mortos
    private boolean verificarTodosMortos(ArrayList<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getHP() > 0) {
                return false;  // Se ao menos um personagem está vivo, retorna falso
            }
        }
        return true;  // Se todos estão mortos, retorna verdadeiro
    }

    // Método para formatar o resultado final da batalha
    private String formatarResultado(String vencedor) {
        String resultado = "<p>O time vencedor é: " + vencedor + "</p>";
        resultado += mostrarSobreviventes();
        return "<html><body>" + resultado + "</body></html>";
    }

    // Método para mostrar sobreviventes
    private String mostrarSobreviventes() {
        String sobreviventes = "<p>Personagens sobreviventes:</p>";

        for (Personagem aliado : campo.getAliados()) {
            if (aliado.getHP() > 0) {
                sobreviventes += "<p>Aliado: " + aliado.getNome() + "</p>";
            }
        }

        for (Personagem inimigo : campo.getInimigos()) {
            if (inimigo.getHP() > 0) {
                sobreviventes += "<p>Inimigo: " + inimigo.getNome() + "</p>";
            }
        }
        return sobreviventes;
    }
}