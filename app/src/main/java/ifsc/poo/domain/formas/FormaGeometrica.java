package ifsc.poo.domain.formas;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.domain.enums.Cor;

public interface FormaGeometrica {
    void desenhar(Draw draw);
    double calcularArea();
    double calcularPerimetro();
    void mover(int dx, int dy);
    void setCor(Cor cor);
    void setPreenchido(boolean preenchido);
    void setTamanho(int tamanho);
}
