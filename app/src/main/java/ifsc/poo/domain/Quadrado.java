package ifsc.poo.domain;

public class Quadrado extends Forma{

    public Quadrado(int tamanho, Cor cor, int area, int perimetro, int total, boolean prechimento) {
        super(tamanho, cor, area, perimetro, total, prechimento);
    }

    @Override
    public String dados() {
        return "";
    }

    @Override
    public int calcularPerimetro() {
        return 0;
    }

    @Override
    public int calcularArea() {
        return 0;
    }
}
