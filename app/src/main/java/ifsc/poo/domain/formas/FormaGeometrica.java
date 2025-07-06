package ifsc.poo.domain.formas;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.domain.enums.Cor;

public interface FormaGeometrica {
    void desenhar(Draw draw);
    double calcularArea(); //Método que faz o uso do conceito de polimorfismo
    double calcularPerimetro(); //Método que faz o uso do conceito de polimorfismo
    void mover(int dx, int dy); //Método que faz o uso do conceito de polimorfismo
    void setCor(Cor cor);
    void setPreenchido(boolean preenchido);
    void setTamanho(int tamanho);
}
