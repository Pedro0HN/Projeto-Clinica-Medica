import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Paciente pacientes[] = new Paciente[100];
        int qtdPacientes = 0;
        // opcao menu
        int opcao;
        // opcao cliente
        int opcaoc;
        int opcao_cadastro;
        int opcaof;
        // Paciente
        String nome;
        String cpf;
        int idade;
        String telefone;
        String convenio;

        // Profissional
        Profissional profissionais[] = new Profissional[50];
        int qtdProfissionais = 0;
        String nomeProf;
        String especialidade;
        String registro;
        double valorConsulta;

        // Consulta
        Consulta consultas[] = new Consulta[100];
        int qtdConsultas = 0;

        // Atendimento
        Atendimento atendimentos[] = new Atendimento[100];
        int qtdAtendimentos = 0;

        // Pagamentos
        Pagamento pagamentos[] = new Pagamento[100];
        int qtdPagamentos = 0;

        do {
            System.out.println("-----------------MENU----------------");
            System.out.println(
                    "1-Cadastrar paciente\n2-Funcionários\n3-Consultas\n4-Pagamentos\n5-Atendimentos\n6-Encerrar");
            System.out.println("informe a opção:");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao > 6 || opcao < 1) {
                System.out.println("opcao inserida invalida, tente novamente!");
            }
            switch (opcao) {
                case 1:
                    do {
                        System.out.println("--------Menu do cliente---------");
                        System.out.println(
                                "1-Cadastrar cliente\n2-Listar\n3-Buscar CPF\n4-Complementar Cadastro\n5-Desativar Paciente\n6-Voltar");
                        System.out.println("selecione a opção:");
                        opcaoc = sc.nextInt();
                        sc.nextLine();
                        if (opcaoc > 6 || opcaoc < 1) {
                            System.out.println("opcao inserida invalida, tente novamente!");
                        }
                        switch (opcaoc) {
                            case 1:
                                do {
                                    System.out.println("Escolha a opcao de Cadastro: ");
                                    System.out.println("1- Rapido\n2-Intermediario\n3-Completo");
                                    opcao_cadastro = sc.nextInt();
                                    sc.nextLine();
                                    if (opcao_cadastro > 3 || opcao_cadastro < 1) {
                                        System.out.println("opcao inserida invalida, tente novamente!");
                                    }
                                } while (opcao_cadastro > 3 || opcao_cadastro < 1);
                                switch (opcao_cadastro) {
                                    case 1:
                                        System.out.println("Insira seu nome: ");
                                        nome = sc.nextLine();
                                        System.out.println("insira seu CPF: ");
                                        cpf = sc.nextLine();
                                        boolean clienteExiste = false;
                                        for (int i = 0; i < qtdPacientes; i++) {
                                            if (pacientes[i].cpf.equals(cpf)) {
                                                clienteExiste = true;
                                            }
                                        }
                                        if (clienteExiste) {
                                            System.out.println("Cpf já Cadastrado");
                                        } else {
                                            pacientes[qtdPacientes] = new Paciente(nome, cpf);
                                            qtdPacientes++;
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Insira seu nome: ");
                                        nome = sc.nextLine();
                                        System.out.println("insira seu CPF: ");
                                        cpf = sc.nextLine();
                                        System.out.println("Digite sua idade: ");
                                        idade = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite seu telefone: ");
                                        telefone = sc.nextLine();
                                        boolean clienteExiste2 = false;
                                        for (int i = 0; i < qtdPacientes; i++) {
                                            if (pacientes[i].cpf.equals(cpf)) {
                                                clienteExiste2 = true;
                                            }
                                        }
                                        if (clienteExiste2) {
                                            System.out.println("Cpf já Cadastrado");
                                        } else {
                                            pacientes[qtdPacientes] = new Paciente(nome, cpf, idade, telefone);
                                            qtdPacientes++;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Insira seu nome: ");
                                        nome = sc.nextLine();
                                        System.out.println("insira seu CPF: ");
                                        cpf = sc.nextLine();
                                        System.out.println("Digite sua idade: ");
                                        idade = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite seu telefone: ");
                                        telefone = sc.nextLine();
                                        System.out.println("Digite o convenio: ");
                                        convenio = sc.nextLine();
                                        boolean clienteExiste3 = false;
                                        for (int i = 0; i < qtdPacientes; i++) {
                                            if (pacientes[i].cpf.equals(cpf)) {
                                                clienteExiste3 = true;
                                            }
                                        }
                                        if (clienteExiste3) {
                                            System.out.println("Cpf já Cadastrado");
                                        } else {
                                            pacientes[qtdPacientes] = new Paciente(nome, cpf, idade, telefone,
                                                    convenio);
                                            qtdPacientes++;
                                        }
                                        break;
                                }

                                break;

                            case 2:
                                for (int i = 0; i < qtdPacientes; i++) {
                                    pacientes[i].exibir();
                                }
                                break;

                            case 3:
                                System.out.println("Digite o CPF: ");
                                cpf = sc.nextLine();

                                boolean encontrarCpf = false;

                                for (int i = 0; i < qtdPacientes; i++) {
                                    if (pacientes[i].cpf.equals(cpf)) {
                                        pacientes[i].exibir();
                                        encontrarCpf = true;
                                    }
                                }
                                if (!encontrarCpf) {
                                    System.out.println("Cpf Não Cadastrado");
                                }
                                break;
                            case 4:
                                System.out.println("Digite o CPF: ");
                                cpf = sc.nextLine();

                                boolean encontrarCpf2 = false;
                                for (int i = 0; i < qtdPacientes; i++) {
                                    if (pacientes[i].cpf.equals(cpf)) {
                                        encontrarCpf2 = true;
                                        int tipo_complemento;
                                        do {
                                            System.out.println("Qual tipo de complemento: ");
                                            System.out.println("1-Sem convenio\n2-Com convenio");
                                            tipo_complemento = sc.nextInt();
                                            sc.nextLine();
                                            if (tipo_complemento < 1 || tipo_complemento > 2) {
                                                System.out.println("opcao inserida invalida, tente novamente!");
                                            }

                                        } while (tipo_complemento < 1 || tipo_complemento > 2);
                                        System.out.println("Digite a idade: ");
                                        idade = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite o telefone: ");
                                        telefone = sc.nextLine();
                                        if (tipo_complemento == 1) {
                                            pacientes[i].complementarDados(idade, telefone);
                                        } else {
                                            System.out.println("Convenio: ");
                                            convenio = sc.nextLine();
                                            pacientes[i].complementarDados(idade, telefone, convenio);
                                        }
                                        System.out.println("Cadastro atualizado");

                                    }

                                }
                                if (!encontrarCpf2) {
                                    System.out.println("CPF não encontrado");
                                }
                                break;
                            case 5:
                                System.out.println("Digite o CPF: ");
                                cpf = sc.nextLine();
                                boolean encontrarCpf3 = false;
                                for (int i = 0; i < qtdPacientes; i++) {
                                    if (pacientes[i].cpf.equals(cpf)) {
                                        pacientes[i].desativar();
                                        encontrarCpf3 = true;
                                        System.out.println("Paciente Desativado");
                                    }
                                }
                                if (!encontrarCpf3) {
                                    System.out.println("Paciente não encontrado");
                                }
                                break;

                            case 6:
                                System.out.println("Retornando ao Menu..");
                                break;
                        }
                    } while (opcaoc != 6);

                    break;
                case 2:

                    do {
                        System.out.println("----- MENU DE FUNCIONÁRIOS -----");
                        System.out.println("1- Cadastrar profissional");
                        System.out.println("2- Listar profissionais");
                        System.out.println("3- Buscar profissional por nome");
                        System.out.println("4- Atualizar profissional");
                        System.out.println("5- Remover profissional");
                        System.out.println("6- Voltar");

                        System.out.println("Selecione a opção:");
                        opcaof = sc.nextInt();
                        sc.nextLine();

                        switch (opcaof) {
                            case 1:
                                int tipoCadastro;
                                do {
                                    System.out.println("Tipo de cadastro:");
                                    System.out.println("1- Simples");
                                    System.out.println("2- Completo");
                                    tipoCadastro = sc.nextInt();
                                    sc.nextLine();
                                } while (tipoCadastro < 1 || tipoCadastro > 2);

                                System.out.println("Nome do profissional:");
                                nomeProf = sc.nextLine();
                                System.out.println("Especialidade:");
                                especialidade = sc.nextLine();

                                if (tipoCadastro == 1) {
                                    profissionais[qtdProfissionais++] = new Profissional(nomeProf, especialidade);
                                } else {
                                    System.out.println("Registro:");
                                    registro = sc.nextLine();
                                    System.out.println("Valor da consulta:");
                                    valorConsulta = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Quantos dias de atendimento?");
                                    int quantidadeDias = sc.nextInt();
                                    sc.nextLine();
                                    String diasAtendimento[] = new String[quantidadeDias];
                                    for (int i = 0; i < quantidadeDias; i++) {
                                        System.out.println("Digite o dia " + (i + 1) + ":");
                                        diasAtendimento[i] = sc.nextLine();
                                    }
                                    profissionais[qtdProfissionais++] = new Profissional(nomeProf, especialidade,
                                            registro, valorConsulta, diasAtendimento);
                                }
                                System.out.println("Profissional cadastrado com sucesso.");
                                break;

                            case 2:
                                if (qtdProfissionais == 0) {
                                    System.out.println("Nenhum profissional cadastrado.");
                                } else {
                                    for (int i = 0; i < qtdProfissionais; i++)
                                        profissionais[i].exibir();
                                }
                                break;

                            case 3:
                                if (qtdProfissionais == 0) {
                                    System.out.println("Nenhum profissional cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o profissional:");
                                for (int i = 0; i < qtdProfissionais; i++) {
                                    System.out.println((i + 1) + "- " + profissionais[i].nome);
                                }
                                int profBuscaIdx = sc.nextInt();
                                sc.nextLine();
                                if (profBuscaIdx >= 1 && profBuscaIdx <= qtdProfissionais) {
                                    profissionais[profBuscaIdx - 1].exibir();
                                } else {
                                    System.out.println("Opção inválida.");
                                }
                                break;

                            case 4:
                                if (qtdProfissionais == 0) {
                                    System.out.println("Nenhum profissional cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o profissional para atualizar:");
                                for (int i = 0; i < qtdProfissionais; i++) {
                                    System.out.println((i + 1) + "- " + profissionais[i].nome);
                                }
                                int profAtualizaIdx = sc.nextInt();
                                sc.nextLine();
                                if (profAtualizaIdx >= 1 && profAtualizaIdx <= qtdProfissionais) {
                                    int i = profAtualizaIdx - 1;
                                    System.out.println("Registro:");
                                    registro = sc.nextLine();
                                    System.out.println("Valor da consulta:");
                                    valorConsulta = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Deseja atualizar os dias de atendimento?");
                                    System.out.println("1- Sim");
                                    System.out.println("2- Não");
                                    int atualizarDias = sc.nextInt();
                                    sc.nextLine();
                                    if (atualizarDias == 1) {
                                        System.out.println("Quantos dias de atendimento?");
                                        int quantidadeDias = sc.nextInt();
                                        sc.nextLine();
                                        String diasAtendimento[] = new String[quantidadeDias];
                                        for (int j = 0; j < quantidadeDias; j++) {
                                            System.out.println("Digite o dia " + (j + 1) + ":");
                                            diasAtendimento[j] = sc.nextLine();
                                        }
                                        profissionais[i].atualizarDados(registro, valorConsulta, diasAtendimento);
                                    } else {
                                        profissionais[i].atualizarDados(registro, valorConsulta);
                                    }
                                    System.out.println("Profissional atualizado.");
                                } else {
                                    System.out.println("Opção inválida.");
                                }
                                break;

                            case 5:
                                if (qtdProfissionais == 0) {
                                    System.out.println("Nenhum profissional cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o profissional para remover:");
                                for (int i = 0; i < qtdProfissionais; i++) {
                                    System.out.println((i + 1) + "- " + profissionais[i].nome);
                                }
                                int profRemoveIdx = sc.nextInt();
                                sc.nextLine();
                                if (profRemoveIdx >= 1 && profRemoveIdx <= qtdProfissionais) {
                                    int i = profRemoveIdx - 1;
                                    for (int j = i; j < qtdProfissionais - 1; j++) {
                                        profissionais[j] = profissionais[j + 1];
                                    }
                                    profissionais[qtdProfissionais - 1] = null;
                                    qtdProfissionais--;
                                    System.out.println("Profissional removido.");
                                } else {
                                    System.out.println("Opção inválida.");
                                }
                                break;

                            case 6:
                                System.out.println("Voltando...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opcaof != 6);
                    break;

                case 3:

                    int opcaoConsulta;

                    do {

                        System.out.println("------ MENU CONSULTAS ------");
                        System.out.println("1- Agendar Consulta");
                        System.out.println("2- Listar Consultas");
                        System.out.println("3- Cancelar Consulta");
                        System.out.println("4- Remarcar Consulta");
                        System.out.println("5- Voltar");

                        opcaoConsulta = sc.nextInt();
                        sc.nextLine();

                        switch (opcaoConsulta) {

                            case 1:
                                if (qtdPacientes == 0) {
                                    System.out.println("Nenhum paciente cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o paciente:");
                                for (int i = 0; i < qtdPacientes; i++) {
                                    System.out.println(
                                            (i + 1) + "- " + pacientes[i].nome + " (CPF: " + pacientes[i].cpf + ")");
                                }
                                int pacIdx = sc.nextInt();
                                sc.nextLine();
                                Paciente pacienteConsulta = null;
                                if (pacIdx >= 1 && pacIdx <= qtdPacientes) {
                                    pacienteConsulta = pacientes[pacIdx - 1];
                                }
                                if (pacienteConsulta == null) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                if (qtdProfissionais == 0) {
                                    System.out.println("Nenhum profissional cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o profissional:");
                                for (int i = 0; i < qtdProfissionais; i++) {
                                    System.out.println((i + 1) + "- " + profissionais[i].nome);
                                }
                                int profIdx = sc.nextInt();
                                sc.nextLine();
                                Profissional profissionalConsulta = null;
                                if (profIdx >= 1 && profIdx <= qtdProfissionais) {
                                    profissionalConsulta = profissionais[profIdx - 1];
                                }
                                if (profissionalConsulta == null) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                String data = "";
                                boolean dataValida = false;
                                do {
                                    System.out.println("Data da consulta (dd/mm/aaaa):");
                                    data = sc.nextLine();
                                    // Validação simples como texto, sem usar LocalDate ou exceções
                                    if (data.length() == 10 && data.charAt(2) == '/' && data.charAt(5) == '/') {
                                        dataValida = true;
                                    } else {
                                        System.out.println("Formato de data inválido. Use dd/mm/aaaa.");
                                    }
                                } while (!dataValida);
                                System.out.println("Hora da consulta:");
                                String hora = sc.nextLine();
                                System.out.println("Tipo da consulta:");
                                String tipo = sc.nextLine();

                                consultas[qtdConsultas++] = new Consulta(pacienteConsulta, profissionalConsulta, data,
                                        hora, tipo);
                                System.out.println("Consulta agendada!");
                                break;

                            case 2:
                                for (int i = 0; i < qtdConsultas; i++) {
                                    System.out.println("Índice: " + i);
                                    consultas[i].mostrarResumo();
                                }
                                break;

                            case 3:
                                System.out.println("Digite o índice da consulta:");
                                int cancelar = sc.nextInt();
                                sc.nextLine();
                                if (cancelar >= 0 && cancelar < qtdConsultas) {
                                    System.out.println("Aplicar multa?");
                                    System.out.println("1-Sim");
                                    System.out.println("2-Não");
                                    int multa = sc.nextInt();
                                    sc.nextLine();
                                    consultas[cancelar].cancelar(multa == 1);
                                } else {
                                    System.out.println("Consulta inválida.");
                                }
                                break;

                            case 4:
                                System.out.println("Digite o índice da consulta:");
                                int remarcar = sc.nextInt();
                                sc.nextLine();
                                if (remarcar >= 0 && remarcar < qtdConsultas) {
                                    System.out.println("Nova data:");
                                    String novaData = sc.nextLine();
                                    System.out.println("Nova hora:");
                                    String novaHora = sc.nextLine();
                                    consultas[remarcar].remarcar(novaData, novaHora);
                                } else {
                                    System.out.println("Consulta inválida.");
                                }
                                break;

                            case 5:
                                System.out.println("Voltando...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }

                    } while (opcaoConsulta != 5);
                    break;

                case 4:

                    if (qtdConsultas == 0) {
                        System.out.println("Nenhuma consulta cadastrada.");
                        break;
                    }

                    int opcaoPagamento;

                    do {

                        System.out.println("------ MENU PAGAMENTOS ------");
                        System.out.println("1- Realizar pagamento de consulta");
                        System.out.println("2- Listar consultas disponíveis");
                        System.out.println("3- Listar pagamentos realizados");
                        System.out.println("4- Voltar");

                        opcaoPagamento = sc.nextInt();
                        sc.nextLine();

                        switch (opcaoPagamento) {

                            case 1:

                                System.out.println("------ CONSULTAS DISPONÍVEIS ------");
                                for (int i = 0; i < qtdConsultas; i++) {
                                    System.out.println("[" + i + "]");
                                    consultas[i].mostrarResumo();
                                }

                                System.out.println("Digite o índice da consulta:");
                                int idxConsulta = sc.nextInt();
                                sc.nextLine();

                                if (idxConsulta < 0 || idxConsulta >= qtdConsultas) {
                                    System.out.println("Índice inválido.");
                                    break;
                                }

                                Consulta consultaSelecionada = consultas[idxConsulta];

                                System.out.print("Digite o valor da consulta: R$ ");
                                double valorConsultaPag = sc.nextDouble();
                                sc.nextLine();

                                String convenioPaciente = consultaSelecionada.paciente.convenio;
                                double percentualDesconto = 0;

                                if (convenioPaciente != null) {
                                    if (convenioPaciente.equals("Unimed")) {
                                        percentualDesconto = 30;
                                    } else if (convenioPaciente.equals("Hapvida")) {
                                        percentualDesconto = 20;
                                    } else if (convenioPaciente.equals("SUS")) {
                                        percentualDesconto = 15;
                                    }
                                }

                                double valorFinalPag = valorConsultaPag - (valorConsultaPag * percentualDesconto / 100);

                                if (percentualDesconto > 0) {
                                    System.out.println("Desconto aplicado (" + convenioPaciente + "): "
                                            + (int) percentualDesconto + "%");
                                }

                                System.out.println("Valor final: R$ " + valorFinalPag);

                                System.out.println("\nEscolha a forma de pagamento:");
                                System.out.println("1 - Cartao");
                                System.out.println("2 - Dinheiro");
                                System.out.println("3 - Pix");

                                int opcaoFormaPag = sc.nextInt();
                                sc.nextLine();

                                String formaPag = "";
                                if (opcaoFormaPag == 1) {
                                    formaPag = "Cartao";
                                } else if (opcaoFormaPag == 2) {
                                    formaPag = "Dinheiro";
                                } else if (opcaoFormaPag == 3) {
                                    formaPag = "Pix";
                                } else {
                                    System.out.println("Opção inválida. Definindo como Dinheiro.");
                                    formaPag = "Dinheiro";
                                }

                                int parcelas = 0;
                                if (opcaoFormaPag == 1) {
                                    System.out.print("Digite o numero de parcelas (1 para a vista): ");
                                    parcelas = sc.nextInt();
                                    sc.nextLine();
                                }

                                Pagamento pagamento = new Pagamento(
                                        consultaSelecionada.paciente.nome,
                                        formaPag,
                                        valorFinalPag,
                                        parcelas);

                                pagamentos[qtdPagamentos++] = pagamento;

                                System.out.println("\n----- COMPROVANTE DE PAGAMENTO -----");
                                System.out.println("CPF: " + consultaSelecionada.paciente.cpf);
                                System.out.println("Profissional: " + consultaSelecionada.profissional.nome);
                                System.out.println("Data da consulta: " + consultaSelecionada.data);
                                pagamento.mostrarPagamento();
                                System.out.println("------------------------------------");
                                break;

                            case 2:
                                System.out.println("------ CONSULTAS CADASTRADAS ------");
                                for (int i = 0; i < qtdConsultas; i++) {
                                    System.out.println("[" + i + "]");
                                    consultas[i].mostrarResumo();
                                }
                                break;

                            case 3:
                                System.out.println("------ PAGAMENTOS REALIZADOS ------");
                                if (qtdPagamentos == 0) {
                                    System.out.println("Nenhum pagamento realizado.");
                                } else {
                                    for (int i = 0; i < qtdPagamentos; i++) {
                                        System.out.println("[" + i + "]");
                                        pagamentos[i].mostrarPagamento();
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Voltando...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }

                    } while (opcaoPagamento != 4);
                    break;
                case 5:
                    int opcaoAtend;
                    do {
                        System.out.println("--------Menu de Atendimento---------");
                        System.out
                                .println("1-Registrar Atendimento\n2-Listar Atendimentos\n3-Buscar por CPF\n4-Voltar");
                        System.out.println("selecione a opcao:");
                        opcaoAtend = sc.nextInt();
                        sc.nextLine();
                        if (opcaoAtend < 1 || opcaoAtend > 4) {
                            System.out.println("opcao inserida invalida, tente novamente!");
                        }
                        switch (opcaoAtend) {

                            case 1:
                                // Buscar consulta pelo CPF do paciente
                                if (qtdPacientes == 0) {
                                    System.out.println("Nenhum paciente cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o paciente:");
                                for (int i = 0; i < qtdPacientes; i++) {
                                    System.out.println(
                                            (i + 1) + "- " + pacientes[i].nome + " (CPF: " + pacientes[i].cpf + ")");
                                }
                                int pacAtendIdx = sc.nextInt();
                                sc.nextLine();
                                if (pacAtendIdx < 1 || pacAtendIdx > qtdPacientes) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }
                                String cpfAtend = pacientes[pacAtendIdx - 1].cpf;
                                int indiceConsulta = -1;
                                for (int i = 0; i < qtdConsultas; i++) {
                                    if (consultas[i].paciente.cpf.equals(cpfAtend)
                                            && consultas[i].status.equals("agendada")) {
                                        indiceConsulta = i;
                                        System.out.println("[" + i + "] " + consultas[i].data + " " + consultas[i].hora
                                                + " - " + consultas[i].profissional.nome);
                                    }
                                }
                                if (indiceConsulta == -1) {
                                    System.out.println("Nenhuma consulta agendada encontrada para este CPF.");
                                    break;
                                }
                                System.out.println("Digite o numero da consulta:");
                                int numConsulta = sc.nextInt();
                                sc.nextLine();
                                if (numConsulta < 0 || numConsulta >= qtdConsultas
                                        || !consultas[numConsulta].paciente.cpf.equals(cpfAtend)) {
                                    System.out.println("Consulta invalida.");
                                    break;
                                }
                                if (!consultas[numConsulta].status.equals("agendada")) {
                                    System.out.println("Consulta nao esta agendada. Status atual: "
                                            + consultas[numConsulta].status);
                                    break;
                                }

                                // Escolher tipo de registro
                                int tipoRegistro;
                                do {
                                    System.out.println("Tipo de registro:");
                                    System.out.println(
                                            "1-Simples (so observacoes)\n2-Com diagnostico\n3-Completo (observacoes + diagnostico + procedimentos)");
                                    tipoRegistro = sc.nextInt();
                                    sc.nextLine();
                                    if (tipoRegistro < 1 || tipoRegistro > 3) {
                                        System.out.println("opcao inserida invalida, tente novamente!");
                                    }
                                } while (tipoRegistro < 1 || tipoRegistro > 3);

                                System.out.println("Digite as observacoes:");
                                String obs = sc.nextLine();

                                if (tipoRegistro == 1) {
                                    // Construtor simples
                                    atendimentos[qtdAtendimentos] = new Atendimento(consultas[numConsulta], obs);
                                    qtdAtendimentos++;
                                    consultas[numConsulta].status = "realizada";
                                    atendimentos[qtdAtendimentos - 1].exibirResumo();

                                } else if (tipoRegistro == 2) {
                                    // Construtor com diagnostico
                                    System.out.println("Digite o diagnostico:");
                                    String diag = sc.nextLine();
                                    atendimentos[qtdAtendimentos] = new Atendimento(consultas[numConsulta], obs, diag);
                                    qtdAtendimentos++;
                                    consultas[numConsulta].status = "realizada";
                                    atendimentos[qtdAtendimentos - 1].exibirResumo();

                                } else {
                                    // Construtor completo — com procedimentos
                                    System.out.println("Digite o diagnostico:");
                                    String diagComp = sc.nextLine();

                                    int tipoProcedimento;
                                    do {
                                        System.out.println("Como deseja informar os procedimentos?");
                                        System.out.println("1-Um por vez\n2-Todos de uma vez");
                                        tipoProcedimento = sc.nextInt();
                                        sc.nextLine();
                                        if (tipoProcedimento < 1 || tipoProcedimento > 2) {
                                            System.out.println("opcao inserida invalida, tente novamente!");
                                        }
                                    } while (tipoProcedimento < 1 || tipoProcedimento > 2);

                                    atendimentos[qtdAtendimentos] = new Atendimento(consultas[numConsulta], obs,
                                            diagComp);
                                    qtdAtendimentos++;
                                    consultas[numConsulta].status = "realizada";

                                    if (tipoProcedimento == 1) {
                                        // Um procedimento por vez
                                        String maisProc = "s";
                                        while (maisProc.equalsIgnoreCase("s")
                                                && atendimentos[qtdAtendimentos - 1].qtdProcedimentos < 10) {
                                            System.out.println("Digite o procedimento:");
                                            String proc = sc.nextLine();
                                            atendimentos[qtdAtendimentos - 1].adicionarProcedimento(proc);
                                            System.out.println("Adicionar outro procedimento? (s/n)");
                                            maisProc = sc.nextLine();
                                        }
                                    } else {
                                        // Todos de uma vez
                                        System.out.println("Quantos procedimentos? (maximo 10)");
                                        int qtdProcs = sc.nextInt();
                                        sc.nextLine();
                                        if (qtdProcs > 10)
                                            qtdProcs = 10;
                                        String[] procs = new String[qtdProcs];
                                        for (int i = 0; i < qtdProcs; i++) {
                                            System.out.println("Procedimento " + (i + 1) + ":");
                                            procs[i] = sc.nextLine();
                                        }
                                        atendimentos[qtdAtendimentos - 1].adicionarProcedimento(procs);
                                    }
                                    atendimentos[qtdAtendimentos - 1].exibirResumo();
                                }
                                break;

                            case 2:
                                // Listar todos os atendimentos
                                if (qtdAtendimentos == 0) {
                                    System.out.println("Nenhum atendimento registrado.");
                                } else {
                                    for (int i = 0; i < qtdAtendimentos; i++) {
                                        atendimentos[i].exibirResumo();
                                        System.out.println("---");
                                    }
                                }
                                break;

                            case 3:
                                // Buscar atendimentos por CPF
                                if (qtdPacientes == 0) {
                                    System.out.println("Nenhum paciente cadastrado.");
                                    break;
                                }
                                System.out.println("Selecione o paciente:");
                                for (int i = 0; i < qtdPacientes; i++) {
                                    System.out.println(
                                            (i + 1) + "- " + pacientes[i].nome + " (CPF: " + pacientes[i].cpf + ")");
                                }
                                int pacBuscaIdx = sc.nextInt();
                                sc.nextLine();
                                if (pacBuscaIdx < 1 || pacBuscaIdx > qtdPacientes) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }
                                String cpfBusca = pacientes[pacBuscaIdx - 1].cpf;
                                boolean achouAtend = false;
                                for (int i = 0; i < qtdAtendimentos; i++) {
                                    if (atendimentos[i].consulta.paciente.cpf.equals(cpfBusca)) {
                                        atendimentos[i].exibirResumo();
                                        System.out.println("---");
                                        achouAtend = true;
                                    }
                                }
                                if (!achouAtend) {
                                    System.out.println("Nenhum atendimento encontrado para este CPF.");
                                }
                                break;

                            case 4:
                                System.out.println("Retornando ao Menu..");
                                break;
                        }
                    } while (opcaoAtend != 4);
                    break;

                case 6:
                    System.out.println("Obrigado! Programa encerrado.");
            }
        } while (opcao != 6);
    }
}