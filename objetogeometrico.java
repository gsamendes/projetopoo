class ObjetoGeometrico { 
    public double area; 
    private double perimetro; 
    protected String cor; 

    public ObjetoGeometrico(double area, double perimetro, String cor) { 
        this.area = area; 
        this.perimetro = perimetro; 
        this.cor = cor; 
    } 

    public double getArea() { 
        return area; 
    } 

    public double getPerimetro() { 
        return perimetro; 
    } 

    protected String getCor() { 
        return cor; 
    } 
} 

class Quadrado extends ObjetoGeometrico { 
    private double lado; 

    public Quadrado(double lado) { 
        super(lado * lado, 4 * lado, "sem cor"); 
        this.lado = lado; 
    } 

    public double getLado() { 
        return lado; 
    } 
} 

class Circunferencia extends ObjetoGeometrico { 
    private double raio; 
    public static final double PI = 3.141618; 

    public Circunferencia(double raio) { 
        super(PI * raio * raio, 2 * PI * raio, "sem cor"); 
        this.raio = raio; 
    } 

    public double getRaio() { 
        return raio; 
    } 
} 

class Retangulo extends ObjetoGeometrico { 
    private double comprimento; 
    private double altura; 

    public Retangulo(double comprimento, double altura) { 
        super(comprimento * altura, 2 * (comprimento + altura), "sem cor"); 
        this.comprimento = comprimento; 
        this.altura = altura; 
    } 

    public double getComprimento() { 
        return comprimento; 
    } 

    public double getAltura() { 
        return altura; 
    } 
} 

class Triangulo extends ObjetoGeometrico { 
    private double base; 
    private double altura; 

    public Triangulo(double base, double altura) { 
        super(0.5 * base * altura, base + 2 * altura, "sem cor"); 
        this.base = base; 
        this.altura = altura; 
    } 

    public double getBase() { 
        return base; 
    } 

    public double getAltura() { 
        return altura; 
    } 
} 

public class QuadroNegro { 
    private Quadrado quadrado; 
    private Retangulo retangulo; 
    private Circunferencia circunferencia; 
    private Triangulo triangulo; 

    public void criaQuadrado(double lado) { 
        quadrado = new Quadrado(lado); 
    } 

    public void criaRetangulo(double comprimento, double altura) { 
        retangulo = new Retangulo(comprimento, altura); 
    } 

    public void criaCircunferencia(double raio) { 
        circunferencia = new Circunferencia(raio); 
    } 

    public void criaTriangulo(double base, double altura) { 
        triangulo = new Triangulo(base, altura); 
    } 

    public void mostraAreaObjeto() { 
        if (quadrado != null) System.out.println("Área do Quadrado: " + quadrado.getArea()); 
        if (retangulo != null) System.out.println("Área do Retângulo: " + retangulo.getArea()); 
        if (circunferencia != null) System.out.println("Área da Circunferência: " + circunferencia.getArea()); 
        if (triangulo != null) System.out.println("Área do Triângulo: " + triangulo.getArea()); 
    } 

    public void mostraPerimetroObjeto() { 
        if (quadrado != null) System.out.println("Perímetro do Quadrado: " + quadrado.getPerimetro()); 
        if (retangulo != null) System.out.println("Perímetro do Retângulo: " + retangulo.getPerimetro()); 
        if (circunferencia != null) System.out.println("Perímetro da Circunferência: " + circunferencia.getPerimetro()); 
        if (triangulo != null) System.out.println("Perímetro do Triângulo: " + triangulo.getPerimetro()); 
    } 

    public void mostraCorObjeto() { 
        if (quadrado != null) System.out.println("Cor do Quadrado: " + quadrado.getCor()); 
        if (retangulo != null) System.out.println("Cor do Retângulo: " + retangulo.getCor()); 
        if (circunferencia != null) System.out.println("Cor da Circunferência: " + circunferencia.getCor()); 
        if (triangulo != null) System.out.println("Cor do Triângulo: " + triangulo.getCor()); 
    } 

    public static void main(String[] args) { 
        QuadroNegro quadroNegro = new QuadroNegro(); 

        quadroNegro.criaQuadrado(4); 
        quadroNegro.criaRetangulo(5, 3); 
        quadroNegro.criaCircunferencia(2); 
        quadroNegro.criaTriangulo(3, 4); 

        quadroNegro.mostraAreaObjeto(); 
        quadroNegro.mostraPerimetroObjeto(); 
        quadroNegro.mostraCorObjeto(); 
    }
}
