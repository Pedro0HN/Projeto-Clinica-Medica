public class Paciente {
    public String nome;
    public String cpf;
    public int idade;
    public String telefone;
    public String convenio;
    public boolean status;

        // cadastro minimo
        public Paciente(String pNome,String pCpf){
            nome = pNome;
            cpf = pCpf;

            idade = 0;
            telefone = "";
            convenio = "";
            status = true;
        }
        // cadastro intermediario
        public Paciente(String pNome,String pCpf,int pIdade,String pTelefone){
            nome = pNome;
            cpf = pCpf;
            idade = pIdade;
            telefone = pTelefone;

            convenio = "";

            status = true;
        }
        // Cadastro Completo
        public Paciente(String pNome,String pCpf,int pIdade,String pTelefone,String pConvenio){
            nome = pNome;
            cpf = pCpf;
            idade = pIdade;
            telefone = pTelefone;
            convenio = pConvenio;

            status = true;
        }
        // Complementar sem convenio
        public void complementarDados(int pIdade, String pTelefone){

            idade = pIdade;
            telefone = pTelefone;
        }
        // Complementar com convenio
        public void complementarDados(int pIdade, String pTelefone, String pConvenio){
            idade = pIdade;
            telefone = pTelefone;
            convenio = pConvenio;
        }
        public void desativar(){
            status = false;
        }

        // exibir
        public void exibir(){
            System.out.println("PACIENTE: ");
            System.out.println("Nome: " + nome);
            System.out.println("Cpf: " + cpf);
            System.out.println("Idade: " + idade);
            System.out.println("Telefone: " + telefone);
            System.out.println("Convenio: " + convenio);

            if(status){
                System.out.println("Status: ativo");
            }else {
                System.out.println("Status: inativo");
            }

        }


}
