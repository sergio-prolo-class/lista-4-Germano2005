package ifsc.poo.domain.formas;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.domain.enums.Cor;

public class Circulo extends FiguraBase {
    public Circulo(double x, double y, int tamanho, Cor cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void desenhar(Draw draw) {
        configurarCor(draw);
        if (preenchido) {
            draw.filledCircle(centro.getX(), centro.getY(), tamanho/2.0);
        } else {
            draw.circle(centro.getX(), centro.getY(), tamanho/2.0);
        }
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(tamanho/2.0, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * (tamanho/2.0);
    }
}