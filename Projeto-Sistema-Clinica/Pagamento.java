public class Pagamento {
    public String nomePaciente;
    public String forma;
    public double valor;
    public int parcelas;

    public Pagamento() {
    }

    public Pagamento(String pNomePaciente, String pForma, double pValor) {
        nomePaciente = pNomePaciente;
        forma = pForma;
        valor = pValor;
    }

    public Pagamento(String pNomePaciente, String pForma, double pValor, int pParcelas) {
        nomePaciente = pNomePaciente;
        forma = pForma;
        valor = pValor;
        parcelas = pParcelas;
    }

    public void mostrarPagamento() {
        System.out.println("\n--- PAGAMENTO ---");
        System.out.println("Paciente: " + nomePaciente);
        System.out.println("Forma: " + forma);
        System.out.println("Valor: R$ " + valor);
        if (parcelas > 0) {
            System.out.println("Parcelas: " + parcelas);
            System.out.println("Valor por parcela: R$ " + (valor / parcelas));
        }
    }
}
