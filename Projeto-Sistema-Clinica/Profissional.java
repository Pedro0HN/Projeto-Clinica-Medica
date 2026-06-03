public class Profissional {
    public String nome;
    public String especialidade;
    public String registro;
    public double valorConsulta;

    public String diasAtendimentos[];
    public int quantidadeDias;

    //Cadastro Simples
    public Profissional(String pNome,String pEspecialidade){
        nome = pNome;
        especialidade =  pEspecialidade;

        registro = "";
        valorConsulta = 0;

        diasAtendimentos = new String[7];
        quantidadeDias = 0;
    }
    //Cadastro Completo
    public Profissional(String pNome,String pEspecialidade,String pRegistro,double pValorConsulta
    ,String dias[]){
            nome = pNome;
            especialidade = pEspecialidade;
            registro = pRegistro;
            valorConsulta = pValorConsulta;

            diasAtendimentos = new String[7];

            quantidadeDias = 0;
        for (int i = 0; i < dias.length; i++) {
            diasAtendimentos[i] = dias[i];
            quantidadeDias++;

        }
    }
    //Atualização Simples
    public void atualizarDados(String pRegistro, double pValorConsulta){
        registro = pRegistro;
        valorConsulta = pValorConsulta;
    }
    //Atualizacao Completa
    public void atualizarDados(String pRegistro,double pValorConsulta,String dias[] ){
            registro = pRegistro;
            valorConsulta = pValorConsulta;
            quantidadeDias = 0;

        for (int i = 0; i < dias.length ; i++) {
            diasAtendimentos[i] = dias[i];
            quantidadeDias++;

        }
    }
    //Verificar disponibilidade
    public boolean atendNoDia(String dia){
        for (int i = 0; i < quantidadeDias; i++) {
            if (diasAtendimentos[i].equalsIgnoreCase(dia)){
                return  true;
            }
        }
        return false;
    }
    public void exibir() {

        System.out.println("\n PROFISSIONAL");

        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
        System.out.println("Valor Consulta: R$ " + valorConsulta);

        System.out.print("Dias Atendimento: ");

        for (int i = 0; i < quantidadeDias; i++) {
            System.out.println(diasAtendimentos[i] + " ");

        }
        System.out.println();

        }
}
