package ifsc.poo.domain.formas;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.domain.enums.Cor;

public class Hexagono extends FiguraBase {
    public Hexagono(double x, double y, int tamanho, Cor cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void desenhar(Draw draw) {
        configurarCor(draw);
        double raio = tamanho/2.0;
        double[] xs = new double[6];
        double[] ys = new double[6];

        for (int i = 0; i < 6; i++) {
            double angulo = 2 * Math.PI * i / 6;
            xs[i] = centro.getX() + raio * Math.cos(angulo);
            ys[i] = centro.getY() + raio * Math.sin(angulo);
        }

        if (preenchido) {
            draw.filledPolygon(xs, ys);
        } else {
            draw.polygon(xs, ys);
        }
    }

    @Override
    public double calcularArea() {
        return (3 * Math.sqrt(3) / 2) * Math.pow(tamanho/2.0, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 6 * tamanho/2.0;
    }
}