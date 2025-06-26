package ifsc.poo.domain;


public class Circulo extends Forma{
    private int raio;

    public Circulo(int tamanho, Cor cor, int area, int perimetro, int total, boolean prechimento, int raio) {
        super(tamanho, cor, area, perimetro, total, prechimento);
        this.raio = raio;
    }

    @Override
    public String dados() {
        return "";
    }

    @Override
    public int calcularArea() {
        return 0;
    }

    @Override
    public int calcularPerimetro() {
        return 0;
    }
}
