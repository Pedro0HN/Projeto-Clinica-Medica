public class Consulta {
    public Paciente paciente;
    public Profissional profissional;
    public String data;
    public String hora;
    public String tipo;   // inicial, retorno, avaliação
    public String status; // agendada, realizada, cancelada, remarcada

// Construtor simples
public Consulta(Paciente p, Profissional prof, String d, String h) {
        paciente = p;
        profissional = prof;
        data = d;
        hora = h;
        tipo = "inicial";   // padrão
        status = "agendada";
    }

// Construtor com tipo de consulta
public Consulta(Paciente p, Profissional prof, String d, String h, String t) {
        paciente = p;
        profissional = prof;
        data = d;
        hora = h;
        tipo = t;
        status = "agendada";
    }

// Cancelar consulta
public void cancelar(boolean multa) {
    if (status.equals("agendada")) {
        status = "cancelada";
        if (multa) {
            System.out.println("Consulta cancelada com multa de R$50,00.");
        } else {
             System.out.println("Consulta cancelada sem multa.");
        }
    } else {
            System.out.println("Não é possível cancelar. Status atual: " + status);
        }
    }

// Remarcar consulta
   public void remarcar(String novaData, String novaHora) {
       if (status.equals("agendada")) {
           status = "remarcada";
           data = novaData;
           hora = novaHora;
           System.out.println("Consulta remarcada para " + novaData + " às " + novaHora);
       } else {
           System.out.println("Não é possível remarcar. Status atual: " + status);
       }
   }

// Remarcar consulta (sobrecarga de método - apenas nova data, mantém hora)
   public void remarcar(String novaData) {
       if (status.equals("agendada")) {
           status = "remarcada";
           data = novaData;
           System.out.println("Consulta remarcada para " + novaData + " às " + hora);
       } else {
           System.out.println("Não é possível remarcar. Status atual: " + status);
       }
   }

// Mostrar resumo da consulta
public void mostrarResumo() {
    System.out.println("=== Resumo da Consulta ===");
    System.out.println("Paciente: " + paciente.nome + " (CPF: " + paciente.cpf + ")");
    System.out.println("Profissional: " + profissional.nome + " - " + profissional.especialidade);
    System.out.println("Data: " + data + " Hora: " + hora);
    System.out.println("Tipo: " + tipo);
    System.out.println("Status: " + status);
    }
}
