package ifsc.poo;

import ifsc.poo.domain.controllers.GerenciadorGUI;

public class App {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao Editor de Desenho Vetorial");
        System.out.println("Iniciando interface gráfica...");

        try {
            new GerenciadorGUI();
        } catch (Exception e) {
            System.err.println("Erro ao iniciar a aplicação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}