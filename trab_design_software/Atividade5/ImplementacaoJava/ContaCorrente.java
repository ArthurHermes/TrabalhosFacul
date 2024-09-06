public class ContaCorrente extends ContaAbstrata{
    private Double LimChequeEspecial; 



    public ContaAbstrata AbrirConta(Cliente c, String NumeroConta, Double SaldoInicial, String tipo){
        return null;
    }
    public boolean depositar(ContaAbstrata c, Double valor){
        return true;
    }
    public boolean sacar(ContaAbstrata c, Double valor){
        return true;
    }

    public Double ObterLimite(){
        return getSaldo() + LimChequeEspecial;
    }
    public void Depositar(Double valor){

    }
    public void Sacar(Double valor){

    }

}
