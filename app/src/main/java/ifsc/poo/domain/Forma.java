package ifsc.poo.domain;

public abstract class Forma implements Relatorio {
    private int tamanho;
    private Cor cor;
    private int area;
    private int perimetro;
    private int lados;
    private boolean prechimento;

    public Forma(int tamanho, Cor cor, int area, int perimetro, int lados, boolean prechimento) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.area = area;
        this.perimetro = perimetro;
        this.lados = lados;
        this.prechimento = prechimento;
    }

    public boolean isPrechimento() {
        return prechimento;
    }

    public void setPrechimento(boolean prechimento) {
        this.prechimento = prechimento;
    }

    public int getTotal() {
        return lados;
    }

    public void setTotal(int total) {
        this.lados = total;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(int perimetro) {
        this.perimetro = perimetro;
    }

    public abstract int calcularPerimetro();

    public abstract int calcularArea();
}
