package linkedlistInterativo;

public class SingleLinkedListImplInterativo<T> implements LinkedList2<T> {

    protected T data;
    protected SingleLinkedListImplInterativo<T> next;

    public SingleLinkedListImplInterativo() {
        this.data = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleLinkedListImplInterativo<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedListImplInterativo<T> next) {
        this.next = next;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    /* ===================== MÉTODOS DA INTERFACE ===================== */

    @Override
    public int size() {
        throw new UnsupportedOperationException("Escolha sizeIterativo");
    }

    public int sizeIterativo(SingleLinkedListImplInterativo<T> head) {
        int count = 0;
        SingleLinkedListImplInterativo<T> aux = head;
        while (aux != null && aux.getData() != null) { //Ultima posição
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    @Override
    public T search(T element) {
        throw new UnsupportedOperationException("Escolha searchIterativo");
    }

    public T searchIterativo(T element, SingleLinkedListImplInterativo<T> head) {
        boolean find = false;
        T result = null;
        SingleLinkedListImplInterativo<T> aux = head;
        while (aux != null && aux.getData() != null && !find) {
           if (aux.getData().equals(element)) {
                result = aux.getData();
                find = true;
           }
           aux = aux.getNext(); 
        }
        return result;
    }

    @Override
    public T searchPosition(int position) {
        throw new UnsupportedOperationException("Escolha searchPositionIterativo");
    }

    public T searchPositionIterativo(int position, SingleLinkedListImplInterativo<T> head) {
        T result = null;
        SingleLinkedListImplInterativo<T> aux = head;
        while (aux != null && aux.getData() != null && position > 0) {
            position--;
            aux = aux.getNext();
        }
        result = aux.getData();
        return result;
    }

    @Override
    public void insertFirst(T element) {
        throw new UnsupportedOperationException("Escolha insertFirstIterativo");
    }

    public void insertFirstIterativo(T element, SingleLinkedListImplInterativo<T> head) {
        SingleLinkedListImplInterativo<T> novo = new SingleLinkedListImplInterativo<>();
        novo.setData(element);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    @Override
    public void insertLast(T element) {
        throw new UnsupportedOperationException("Escolha insertLastIterativo");
    }

    public void insertLastIterativo(T element, SingleLinkedListImplInterativo<T> head) {
        SingleLinkedListImplInterativo<T> aux = head;
        if (aux != null) {
            while (aux.getNext() != null && aux.getNext().getData() != null) {
                aux = aux.getNext();
            }
            SingleLinkedListImplInterativo<T> novo = new SingleLinkedListImplInterativo<>();
            novo.setData(element);
            novo.setNext(aux.getNext());
            aux.setNext(novo); 
        }
    }

    public String imprimir(SingleLinkedListImplInterativo<Integer> head) {
        String result = "";
        SingleLinkedListImplInterativo<Integer> aux = head.getNext();
        while (aux != null && aux.getData() != null) {
            result = result + aux.getData().toString() + " ";
            aux = aux.getNext();
        }
        return result;
    }


    @Override
    public void insertPosition(int position, T element) {
        throw new UnsupportedOperationException("Escolha insertPositionIterativo");
    }

    public void insertPositionIterativo(int position, T element, SingleLinkedListImplInterativo<T> head) {
        SingleLinkedListImplInterativo<T> aux = head;
        while (position > 0 && aux.getNext() != null) {
            aux = aux.getNext();
            position--;
        }
        //novo.next = atual.next, atual.next = novo
        SingleLinkedListImplInterativo<T> novo = new SingleLinkedListImplInterativo<>();
        novo.setData(element);

        novo.setNext(aux.getNext());
        aux.setNext(novo);

    }

    @Override
    public void removeFirst() {
        throw new UnsupportedOperationException("Escolha removeFirstIterativo");
    }

    public void removeFirstIterativo(SingleLinkedListImplInterativo<T> head) {
        head.setNext(head.getNext().getNext());
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Escolha removeLastIterativo");
    }

    public void removeLastIterativo(SingleLinkedListImplInterativo<T> head) {
        SingleLinkedListImplInterativo<T> aux = head;
        while (aux.getNext().getNext().getData() != null) {
            aux = aux.getNext();
        }
        aux.setNext(head.getNext().getNext());
    }

    @Override
    public void removeValue(T element) {
        throw new UnsupportedOperationException("Escolha removeValueIterativo");
    }

    public void removeValueIterativo(T element, SingleLinkedListImplInterativo<T> head) {
        throw new UnsupportedOperationException("Unimplemented method 'removeValueIterativo'");
    }

    @Override
    public void removePosition(int position) {
        throw new UnsupportedOperationException("Escolha removePositionIterativo");
    }

    public void removePositionIterativo(int position, SingleLinkedListImplInterativo<T> head) {
        throw new UnsupportedOperationException("Unimplemented method 'removePositionIterativo'");
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Escolha toArrayIterativo");
    }

    public T[] toArrayIterativo(SingleLinkedListImplInterativo<T> head) {
        throw new UnsupportedOperationException("Unimplemented method 'toArrayIterativo'");
    }

    @Override
    public boolean contains(T element) {
        throw new UnsupportedOperationException("Escolha containsIterativo");
    }

    public boolean containsIterativo(T element, SingleLinkedListImplInterativo<T> head) {
        throw new UnsupportedOperationException("Unimplemented method 'containsIterativo'");
    }

    /* ===== outros métodos seguem exatamente o mesmo padrão ===== */
}
