package ifsc.poo.domain.formas;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.domain.enums.Cor;

public class Pentagono extends FiguraBase {
    public Pentagono(double x, double y, int tamanho, Cor cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void desenhar(Draw draw) {
        configurarCor(draw);
        double raio = tamanho/2.0;
        double[] xs = new double[5];
        double[] ys = new double[5];

        for (int i = 0; i < 5; i++) {
            double angulo = 2 * Math.PI * i / 5;
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
        return (5.0/4.0) * Math.pow(tamanho, 2) * (1.0/Math.tan(Math.PI/5));
    }

    @Override
    public double calcularPerimetro() {
        return 5 * tamanho;
    }
}