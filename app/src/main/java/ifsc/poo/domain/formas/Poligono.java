package ifsc.poo.domain.formas;

import ifsc.poo.domain.controllers.Relatorio;
import ifsc.poo.domain.enums.Cor;

import java.util.ArrayList;
import java.util.List;

public class Poligono extends Desenho implements FormaGeometrica{

    public Poligono(List<Linha> linhas, Cor cor) {
        super(linhas, cor);
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
