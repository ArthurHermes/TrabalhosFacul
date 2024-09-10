import java.util.NoSuchElementException;

class Pilha<T> {
    private Node<T> topo;

    private static class Node<T> {
        private T valor;
        private Node<T> proximo;

        public Node(T valor) {
            this.valor = valor;
            this.proximo = null; // Melhor prática para clareza
        }
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void empilhar(T valor) {
        Node<T> novoNode = new Node<>(valor);
        novoNode.proximo = topo;
        topo = novoNode;
    }

    public T desempilhar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        T valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public T topo() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        return topo.valor;
    }
}
