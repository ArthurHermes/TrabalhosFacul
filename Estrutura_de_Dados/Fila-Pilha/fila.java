import java.util.NoSuchElementException;

class Fila<T> {
    private Node<T> inicio, fim;

    private static class Node<T> {
        private T valor;
        private Node<T> proximo;

        public Node(T valor) {
            this.valor = valor;
            this.proximo = null; // Boa prática para explicitar o valor
        }
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void enfileirar(T valor) {
        Node<T> novoNode = new Node<>(valor);
        if (fim != null) {
            fim.proximo = novoNode;
        }
        fim = novoNode;
        if (inicio == null) {
            inicio = fim;
        }
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia");
        }
        T valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return valor;
    }
}
