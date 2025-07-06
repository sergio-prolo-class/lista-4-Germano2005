package ifsc.poo.domain.formas;

import ifsc.poo.domain.enums.Cor;
import edu.princeton.cs.algs4.Draw;

public abstract class FiguraBase implements FormaGeometrica {
    protected Ponto centro;
    protected Cor cor;
    protected boolean preenchido;
    protected int tamanho;

    public FiguraBase(double x, double y, int tamanho, Cor cor, boolean preenchido) {
        this.centro = new Ponto(x, y);
        this.tamanho = tamanho;
        this.cor = cor;
        this.preenchido = preenchido;
    }

    @Override
    public void mover(int dx, int dy) {
        centro.mover(dx, dy);
    }

    @Override
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }

    @Override
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    protected void configurarCor(Draw draw) {
        switch(cor) {
            case VERMELHO: draw.setPenColor(Draw.RED); break;
            case AZUL: draw.setPenColor(Draw.BLUE); break;
            case VERDE: draw.setPenColor(Draw.GREEN); break;
            case PRETO: draw.setPenColor(Draw.BLACK); break;
        }
    }
}