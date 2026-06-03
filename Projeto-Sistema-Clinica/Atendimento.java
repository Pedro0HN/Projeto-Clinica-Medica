public class Atendimento {
    public Consulta consulta;
    public String observacoes;
    public String diagnostico;
    public String[] procedimentos = new String[10];
    public int qtdProcedimentos = 0;

    // Construtor simples (sem diagnostico)
    public Atendimento(Consulta c, String obs) {
        consulta = c;
        observacoes = obs;
        diagnostico = "Nao informado";
    }

    // Construtor com diagnostico
    public Atendimento(Consulta c, String obs, String diag) {
        consulta = c;
        observacoes = obs;
        diagnostico = diag;
    }

    // Adicionar um procedimento por vez
    public void adicionarProcedimento(String proc) {
        if (qtdProcedimentos < 10) {
            procedimentos[qtdProcedimentos] = proc;
            qtdProcedimentos++;
        } else {
            System.out.println("Limite de procedimentos atingido!");
        }
    }

    // Adicionar varios procedimentos de uma vez
    public void adicionarProcedimento(String[] procs) {
        for (int i = 0; i < procs.length; i++) {
            adicionarProcedimento(procs[i]);
        }
    }

    // Exibir resumo do atendimento
    public void exibirResumo() {
        System.out.println("\n=== Resumo do Atendimento ===");
        System.out.println("Paciente: " + consulta.paciente.nome);
        System.out.println("Profissional: " + consulta.profissional.nome);
        System.out.println("Observacoes: " + observacoes);
        System.out.println("Diagnostico: " + diagnostico);
        if (qtdProcedimentos > 0) {
            System.out.println("Procedimentos realizados:");
            for (int i = 0; i < qtdProcedimentos; i++) {
                System.out.println(" - " + procedimentos[i]);
            }
        } else {
            System.out.println("Nenhum procedimento realizado.");
        }
        System.out.println("=============================\n");
    }
}
