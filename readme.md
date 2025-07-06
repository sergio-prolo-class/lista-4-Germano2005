# Lista - 4 POO - Jogo de Desenho Vetorial

Nome: Germano D. Coelho

Um editor gráfico vetorial que permite desenhar diversas formas geométricas utilizando os princípios de Programação Orientada a Objetos.

## Funcionalidades

- Desenho de 4 figuras geométricas:
  - Círculo (F1)
  - Quadrado (F2)
  - Pentágono (F3)
  - Hexágono (F4)
  
- Controles:
  - **Teclas F1-F4**: Selecionar figura
  - **Teclas F5-F8**: Selecionar cor (Vermelho, Azul, Verde, Preto)
  - **Tecla F**: Alternar entre preenchido/vazado
  - **Teclas Q/W**: Diminuir/Aumentar tamanho
  - **Setas**: Mover todas as figuras
  - **Tecla C**: Limpar tela
  - **Tecla P**: Mostrar informações (quantidade, perímetro total, área média)
  - **Tecla H**: Mostrar ajuda

## Diagrama de Classes

```mermaid
classDiagram
    class App {
        +main(String[] args)
    }

    class GerenciadorGUI {
        -Draw draw
        -List~Figura~ figuras
        -Cor corAtual
        -boolean preenchido
        -int tamanhoAtual
        -int figuraAtual
        +mousePressed(double x, double y)
        +keyTyped(char c)
        +keyPressed(int keycode)
    }

    class Figura {
        <<interface>>
        +desenhar(Draw draw)
        +calcularArea() double
        +calcularPerimetro() double
        +mover(int dx, int dy)
        +setCor(Cor cor)
        +setPreenchido(boolean preenchido)
        +setTamanho(int tamanho)
    }

    class FiguraBase {
        <<abstract>>
        #Ponto centro
        #Cor cor
        #boolean preenchido
        #int tamanho
        +mover(int dx, int dy)
        +setCor(Cor cor)
        +setPreenchido(boolean preenchido)
        +setTamanho(int tamanho)
        #configurarCor(Draw draw)
    }

    class Circulo {
        +desenhar(Draw draw)
        +calcularArea() double
        +calcularPerimetro() double
    }

    class Quadrado {
        +desenhar(Draw draw)
        +calcularArea() double
        +calcularPerimetro() double
    }

    class Pentagono {
        +desenhar(Draw draw)
        +calcularArea() double
        +calcularPerimetro() double
    }

    class Hexagono {
        +desenhar(Draw draw)
        +calcularArea() double
        +calcularPerimetro() double
    }

    class Ponto {
        -double x
        -double y
        +getX() double
        +getY() double
        +mover(int dx, int dy)
    }

    class Cor {
        <<enum>>
        VERMELHO
        AZUL
        VERDE
        PRETO
    }

    App --> GerenciadorGUI
    GerenciadorGUI --> Figura
    Figura <|.. FiguraBase
    FiguraBase <|-- Circulo
    FiguraBase <|-- Quadrado
    FiguraBase <|-- Pentagono
    FiguraBase <|-- Hexagono
    FiguraBase --> Ponto
    FiguraBase --> Cor
```

abaixo encontra-se uma imagem de demostração da aplicação

![Captura de Tela](polimorfismo.png)
