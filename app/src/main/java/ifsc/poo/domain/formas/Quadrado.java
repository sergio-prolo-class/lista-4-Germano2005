package ifsc.poo.domain.formas;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.domain.enums.Cor;

public class Quadrado extends FiguraBase {
    public Quadrado(double x, double y, int tamanho, Cor cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void desenhar(Draw draw) {
        configurarCor(draw);
        double meioLado = tamanho/2.0;
        double[] xs = {
                centro.getX() - meioLado,
                centro.getX() + meioLado,
                centro.getX() + meioLado,
                centro.getX() - meioLado
        };
        double[] ys = {
                centro.getY() - meioLado,
                centro.getY() - meioLado,
                centro.getY() + meioLado,
                centro.getY() + meioLado
        };

        if (preenchido) {
            draw.filledPolygon(xs, ys);
        } else {
            draw.polygon(xs, ys);
        }
    }

    @Override
    public double calcularArea() {
        return tamanho * tamanho;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * tamanho;
    }
}