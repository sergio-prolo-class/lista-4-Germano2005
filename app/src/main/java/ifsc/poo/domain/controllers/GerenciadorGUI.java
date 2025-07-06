package ifsc.poo.domain.controllers;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.domain.enums.Cor;
import ifsc.poo.domain.formas.*;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorGUI implements DrawListener {
    private final Draw draw;
    private final List<FormaGeometrica> figuras;
    private Cor corAtual;
    private boolean preenchido;
    private int tamanhoAtual;
    private int figuraAtual;

    private static final int LARGURA_TELA = 800;
    private static final int ALTURA_TELA = 600;
    private static final int TAMANHO_MIN = 10;
    private static final int TAMANHO_MAX = 140;

    private final Cor[] coresDisponiveis = {Cor.VERMELHO, Cor.AZUL, Cor.VERDE, Cor.PRETO};
    private final String[] nomesFiguras = {"Círculo", "Quadrado", "Pentágono", "Hexágono"};

    public GerenciadorGUI() {
        figuras = new ArrayList<>();
        corAtual = Cor.PRETO;
        preenchido = false;
        tamanhoAtual = 50;
        figuraAtual = 0;

        draw = new Draw();
        draw.setCanvasSize(LARGURA_TELA, ALTURA_TELA);
        draw.setXscale(0, LARGURA_TELA);
        draw.setYscale(0, ALTURA_TELA);
        draw.addListener(this);
        draw.enableDoubleBuffering();

        desenharInterface();
        mostrarInstrucoes();
    }

    private void desenharInterface() {
        draw.clear(Draw.WHITE);

        for (FormaGeometrica figura : figuras) {
            figura.desenhar(draw);
        }

        draw.setPenColor(Draw.BLACK);
        draw.textLeft(10, ALTURA_TELA - 20, "Figura: " + nomesFiguras[figuraAtual]);
        draw.textLeft(10, ALTURA_TELA - 40, "Cor: " + corAtual);
        draw.textLeft(10, ALTURA_TELA - 60, "Modo: " + (preenchido ? "Preenchido" : "Vazado"));
        draw.textLeft(10, ALTURA_TELA - 80, "Tamanho: " + tamanhoAtual);
        draw.textLeft(10, 20, "Clique para desenhar | Tecla 'H' para Ajuda");

        draw.show();
    }

    private void mostrarInstrucoes() {
        System.out.println("\n=== Controles do Editor ===");
        System.out.println("Teclas F1-F4: Selecionar figura");
        System.out.println("Teclas F5-F8: Selecionar cor");
        System.out.println("Tecla F: Alternar entre preenchido/vazado");
        System.out.println("Teclas Q/W: Diminuir/Aumentar tamanho");
        System.out.println("Setas: Mover todas as figuras");
        System.out.println("Tecla C: Limpar tela");
        System.out.println("Tecla P: Mostrar informações das figuras");
        System.out.println("Tecla H: Mostrar esta ajuda novamente");
    }

    @Override
    public void mousePressed(double x, double y) {
        FormaGeometrica novaFigura = criarFigura(x, y);
        figuras.add(novaFigura);
        desenharInterface();
        System.out.println(nomesFiguras[figuraAtual] + " desenhado em (" + (int)x + ", " + (int)y + ")");
    }

    private FormaGeometrica criarFigura(double x, double y) {
        return switch (figuraAtual) {
            case 1 -> new Quadrado(x, y, tamanhoAtual, corAtual, preenchido);
            case 2 -> new Pentagono(x, y, tamanhoAtual, corAtual, preenchido);
            case 3 -> new Hexagono(x, y, tamanhoAtual, corAtual, preenchido);
            default -> new Circulo(x, y, tamanhoAtual, corAtual, preenchido);
        };
    }

    @Override
    public void keyTyped(char c) {
        switch (Character.toUpperCase(c)) {
            case 'F' -> {
                preenchido = !preenchido;
                System.out.println("Modo alterado para: " + (preenchido ? "Preenchido" : "Vazado"));
            }
            case 'C' -> {
                figuras.clear();
                System.out.println("Tela limpa - todas as figuras removidas");
            }
            case 'P' -> processarFiguras();
            case 'Q' -> {
                tamanhoAtual = Math.max(TAMANHO_MIN, tamanhoAtual - 10);
                System.out.println("Tamanho diminuído para: " + tamanhoAtual);
            }
            case 'W' -> {
                tamanhoAtual = Math.min(TAMANHO_MAX, tamanhoAtual + 10);
                System.out.println("Tamanho aumentado para: " + tamanhoAtual);
            }
            case 'H' -> mostrarInstrucoes();
        }
        desenharInterface();
    }

    @Override
    public void keyPressed(int keycode) {
        if (keycode >= 112 && keycode <= 119) {
            if (keycode <= 115) {
                figuraAtual = keycode - 112;
                System.out.println("Figura selecionada: " + nomesFiguras[figuraAtual]);
            } else {
                corAtual = coresDisponiveis[keycode - 116];
                System.out.println("Cor selecionada: " + corAtual);
            }
        }
        else if (keycode >= 37 && keycode <= 40) {
            int dx = 0, dy = 0;
            switch (keycode) {
                case 37 -> dx = -10;
                case 38 -> dy = 10;
                case 39 -> dx = 10;
                case 40 -> dy = -10;
            }
            moverTodasFiguras(dx, dy);
        }
        desenharInterface();
    }

    private void moverTodasFiguras(int dx, int dy) {
        for (FormaGeometrica f : figuras) {
            f.mover(dx, dy);
        }
        System.out.println("Figuras movidas: dx=" + dx + ", dy=" + dy);
    }

    private void processarFiguras() {
        int total = figuras.size();
        double somaPerimetros = 0;
        double somaAreas = 0;

        for (FormaGeometrica f : figuras) {
            somaPerimetros += f.calcularPerimetro();
            somaAreas += f.calcularArea();
        }

        System.out.println("\n=== Estatísticas das Figuras ===");
        System.out.println("Total de figuras: " + total);
        System.out.printf("Soma dos perímetros: %.2f\n", somaPerimetros);
        System.out.printf("Área média: %.2f\n", (total > 0 ? somaAreas / total : 0));
    }

    @Override public void mouseDragged(double x, double y) {}
    @Override public void mouseReleased(double x, double y) {}
    @Override public void mouseClicked(double x, double y) {}
    @Override public void keyReleased(int keycode) {}
}