import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Autenticar {
    boolean autenticar(String nome, String senha);
}

class Empresa implements Autenticar {
    private String nomeFantasia;
    private String CNPJ;
    private String nome;
    private String senha;

    public Empresa() {
        this.nomeFantasia = "UNICRENTE";
        this.CNPJ = "00.623.904/0001-73";
        this.nome = "Lucas Bastos";
        this.senha = "adm_control";
    }

    public Empresa(String nomeFantasia, String CNPJ, String nome, String senha) {
        this.nomeFantasia = nomeFantasia;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.senha = senha;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}

class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public void listar(int identificador, String nome) {
        System.out.println(identificador + " - " + nome);
    }
}

class Funcionario {
    protected String nome;
    protected Float salario;

    public Funcionario(String nome, Float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    void listar(int numero, String texto) {
        System.out.println("X: " + numero + " | NOME" + texto);
    }
}

class Atendimento extends Funcionario implements Autenticar {
    private String senha;

    public Atendimento(String nome, Float salario, String senha) {
        super(nome, salario);
        this.senha = senha;
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}

class Dentista extends Funcionario {
    private String sala;

    public Dentista(String nome, Float salario, String sala) {
        super(nome, salario);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    @Override
    void listar(int identificador, String nome) {
        System.out.println(identificador + " - " + nome);
    }
}

class Consulta {
    private static int contadorId = 1;
    private String dentistaNome;
    private String dentistaSala;
    private String clienteNome;
    private String clienteContato;
    private int idConsulta;
    private String dia;
    private String hora;
    private String tipoConsulta;
    private double valor;

    public Consulta(String dentistaNome, String dentistaSala, String clienteNome, String clienteContato, String dia, String hora, String tipoConsulta, double valor) {
        this.idConsulta = contadorId++;
        this.dentistaNome = dentistaNome;
        this.dentistaSala = dentistaSala;
        this.clienteNome = clienteNome;
        this.clienteContato = clienteContato;
        this.dia = dia;
        this.hora = hora;
        this.tipoConsulta = tipoConsulta;
        this.valor = valor;
    }

    public int ID() {
        return 1;
    }

    public double getValor() {
        return valor;
    }

    int somar(int a, int b) {
        return a + b;
    }

    double somar(double a, double b) {
        return a + b;
    }

    public String toString() {
        return "\t * * * ID Consulta: " + idConsulta + " * * * " +
               "\nDentista: " + dentistaNome + "\tSala: " + dentistaSala +
               "\nCliente: " + clienteNome + "\t\tContato: " + clienteContato +
               "\nDia: " + dia + "\t| Hora: " + hora + "\t| Tipo: " + tipoConsulta +
               "\n--------------------------------| valor: R$" + valor;
    }
}

public class PI_POO_C2 {
    private static final List<Dentista> dentistas = new ArrayList<>();
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        dentistas.add(new Dentista("Dr. Vinicius Silva", 3000.0f, "001"));
        dentistas.add(new Dentista("Dr. Down", 2500.0f, "002"));

        clientes.add(new Cliente("Gustavo Mendes", "99999-9999"));
        clientes.add(new Cliente("Gustavo Silva", "99999-9999"));
        clientes.add(new Cliente("Gustavo Anunciação", "99999-9999"));
        clientes.add(new Cliente("Gustavo Ferreira", "99999-9999"));

        Empresa empresa = new Empresa();
        Atendimento atendente01 = new Atendimento("Gustavo Silva", 1500.0f, "file18");
        Atendimento atendente02 = new Atendimento("Cabeça de Ovo", 1500.0f, "file24");

        System.out.println("\nNome Fantasia da empresa: ");
        String nomeFantasia = scanner.nextLine();
        empresa.setNomeFantasia(nomeFantasia);

        System.out.println("\nDigita o CNPJ da empresa: ");
        String CNPJ = scanner.nextLine();
        empresa.setCNPJ(CNPJ);

        System.out.println("\nNome do dono da empresa: ");
        String nome = scanner.nextLine();
        empresa.setNome(nome);

        System.out.println("\nSenha de acesso do dono: ");
        String senha = scanner.nextLine();
        empresa.setSenha(senha);

        System.out.println("\n\n * * * * * AUTENTICAÇÃO " + empresa.getNomeFantasia() + " * * * * * \n");

        while (true) {
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            System.out.print("Senha: ");
            senha = scanner.nextLine();

            boolean acessoPermitido = empresa.autenticar(nome, senha) || atendente01.autenticar(nome, senha) || atendente02.autenticar(nome, senha);

            if (!acessoPermitido) {
                System.out.println("\n\t ERROR: ACESSO NEGADO.\n");
            } else {
                System.out.println("\n\tLOGIN BEM-SUCEDIDO!");
                break;
            }
        }

        while (true) {
            System.out.println("\n\n * * * * * BEM-VINDO " + empresa.getNomeFantasia() + " * * * * * \n");
            System.out.println("1 - Cadastrar uma nova consulta");
            System.out.println("0 - Sair e Exibir todas consultas cadastradas");
            System.out.println("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("\n\n * * * * * CADASTRAR CONSULTA * * * * * \n");

                for (int i = 0; i < dentistas.size(); i++) {
                    dentistas.get(i).listar(i + 1, dentistas.get(i).getNome());
                }
                System.out.println("\nEscolha um dentista:");
                int dentistaEscolha = scanner.nextInt() - 1;
                scanner.nextLine();
                Dentista dentista = dentistas.get(dentistaEscolha);

                System.out.println("\n---------------------------------");
                for (int i = 0; i < clientes.size(); i++) {
                    clientes.get(i).listar(i + 1, clientes.get(i).getNome());
                }
                System.out.println("\nEscolha um cliente:");
                int clienteEscolha = scanner.nextInt() - 1;
                scanner.nextLine();
                Cliente cliente = clientes.get(clienteEscolha);

                System.out.println("\n---------------------------------");
                int dia;
                while (true) {
                    System.out.println("Dia da consulta (1 - 31): ");
                    dia = scanner.nextInt();
                    if (dia >= 1 && dia <= 31) {
                        break;
                    }
                    System.out.println("\n\tERROR: DIA INVÁLIDO\n");
                }

                System.out.println("\n");
                int mes;
                while (true) {
                    System.out.println("mês da consulta (1 - 12): ");
                    mes = scanner.nextInt();
                    if (mes >= 1 && mes <= 12) {
                        break;
                    }
                    System.out.println("\n\tERROR: MÊS INVÁLIDO\n");
                }

                System.out.println("\n");
                int ano;
                while (true) {
                    System.out.println("ano da consulta: ");
                    ano = scanner.nextInt();
                    if (ano >= 2024) {
                        break;
                    }
                    System.out.println("\n\tERROR: ANO INVÁLIDO\n");
                }

                System.out.println("\nInforme a hora da consulta (ex: 14:30): ");
                scanner.nextLine();
                String hora = scanner.nextLine();

                System.out.println("Qual o tipo da consulta: ");
                String tipoConsulta = scanner.nextLine();

                System.out.println("Valor da consulta: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                String diaFormatado = String.format("%02d/%02d/%d", dia, mes, ano);

                Consulta consulta = new Consulta(dentista.getNome(), dentista.getSala(), cliente.getNome(), cliente.getContato(), diaFormatado, hora, tipoConsulta, valor);

                consultas.add(consulta);
                System.out.println("\nCONSULTA CADASTRADA COM SUCESSO!\n");
            } else if (opcao == 0) {
                break;
            }
        }

        System.out.println("\n\n * * * LISTA DE CONSULTAS CADASTRADAS * * *\n\n");
        consultas.forEach(consulta -> System.out.println(consulta.toString()));
        scanner.close();
    }
}
