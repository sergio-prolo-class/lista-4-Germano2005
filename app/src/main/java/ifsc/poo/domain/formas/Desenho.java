package ifsc.poo.domain.formas;

import ifsc.poo.domain.enums.Cor;

import java.util.List;

public abstract class Desenho {
    private List<Linha> linhas;
    private Cor cor;

    public Desenho(List<Linha> linhas, Cor cor) {
        this.linhas = linhas;
        this.cor = cor;
    }

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
