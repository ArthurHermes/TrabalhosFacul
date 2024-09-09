public class BancoItau implements IBancoGeral{
    
    public ContaAbstrata AbrirConta(Cliente c, String NumeroConta, Double SaldoInicial, String tipo){
        return ContaAbstrata;
    }
    public boolean depositar(ContaAbstrata c, Double valor){
        return true;
    }
    public boolean sacar(ContaAbstrata c, Double valor){
        return true;
    }
}