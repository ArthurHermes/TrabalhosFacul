public abstract class ContaAbstrata implements IBancoGeral{
    private String NumeroConta;
    private Double Saldo;
    private Cliente cliente;

    public String getNumeroConta(){
        return NumeroConta;
    }

    public void setNumeroConta(String NumeroConta){
        this.NumeroConta = NumeroConta;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }



    public Double ObterLimite(){
        return null;
    }
    public void Depositar(Double valor){

    }
    public void Sacar(Double valor){

    }


}

