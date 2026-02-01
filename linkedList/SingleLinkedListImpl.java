public class SingleLinkedListImpl<T> implements LinkedList<T> {

    protected T data;
    protected SingleLinkedListImpl<T> next;

    public SingleLinkedListImpl() {
        this.data = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleLinkedListImpl<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedListImpl<T> next) {
        this.next = next;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    /* ===================== MÉTODOS DA INTERFACE ===================== */

    @Override
    public int size() {
        throw new UnsupportedOperationException("Escolha sizeIterativo ou sizeRecursivo");
    }

    public int sizeIterativo(SingleLinkedListImpl<T> head) {
        int count = 0;
        SingleLinkedListImpl<T> aux = head;
        while (aux != null && !aux.isEmpty()) {
            count++;
            aux = aux.getNext(); //Atualizando meu auxiliar
        }
        return count;
    }

    public int sizeRecursivo(SingleLinkedListImpl<T> head) {
        int result = 0;
        if (head != null && !head.isEmpty()) {
            result = 1 + sizeRecursivo(head.getNext());
        }
        return result;
    }

    @Override
    public T search(T element) {
        throw new UnsupportedOperationException("Escolha searchIterativo ou searchRecursivo");
    }

    public T searchIterativo(T element, SingleLinkedListImpl<T> head ) {
        T result = null;
        SingleLinkedListImpl<T> aux = head;
        while (aux != null && !aux.isEmpty() && result == null) {
            if (aux.getData().equals(element)) {
                result = aux.getData();
            }
            aux = aux.getNext(); //passo indutivo
        }
        return result;

    }

    public T searchRecursivo(T element, SingleLinkedListImpl<T> head) {
        T result = null;
        if (head != null && head.getData() != null) {
            if (head.getData().equals(element)) {
                result = head.getData();
            } else {
                result = searchRecursivo(element, head.getNext());
            }
        }
        return result;
    }

    @Override
    public T searchPosition(int position) {
        throw new UnsupportedOperationException("Escolha searchPositionIterativo ou searchPositionRecursivo");
    }

    public T searchPositionIterativo(int position, SingleLinkedListImpl<T> head) {
        T result = null;
        if (position >= 0) {
            SingleLinkedListImpl<T> aux = head;
            while (aux != null && aux.getData() != null && position > 0) {
                position--;
                aux = aux.getNext(); //Até chegar onde eu quero
            }
            result = aux.getData();
        }
        return result;
    }

    public T searchPositionRecursivo(int position, SingleLinkedListImpl<T> head) {
        T result = null;
        if (head != null && !head.isEmpty()) {
            if (position == 0) {
                result = head.getData();
            } else {
                result = searchPositionRecursivo(position - 1, head.getNext());
            }
        }

        return result;
    }

    @Override
    public void insertFirst(T element) {
        throw new UnsupportedOperationException("Escolha insertFirstIterativo ou insertFirstRecursivo");
    }

    public void insertFirstIterativo(T element, SingleLinkedListImpl<T> head) {
        SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
        novo.setData(element);
        novo.setNext(head);
    }

    public void insertFirstRecursivo(T element, SingleLinkedListImpl<T> head) {
        SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
        novo.setData(element);
        novo.setNext(head);
    }

    @Override
    public void insertLast(T element) {
        throw new UnsupportedOperationException("Escolha insertLastIterativo ou insertLastRecursivo");
    }

    public void insertLastIterativo(T element, SingleLinkedListImpl<T> head) {
        SingleLinkedListImpl<T> aux = head;
        while (aux != null && !aux.isEmpty() && aux.getNext() != null) {
            aux = aux.next;
        }
        SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
        novo.data = element;
        novo.setNext(aux.getNext());
        aux.setNext(novo);

        
        
    }

    public void insertLastRecursivo(T element, SingleLinkedListImpl<T> head) {
        if (head == null || head.isEmpty()) { //Lista vázia
            SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
            novo.setData(element);
            novo.setNext(null);
        } else if (head.getNext() == null) {
            //novo.next = atual.next, atual.next = novo
            SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
            novo.setData(element);
            novo.setNext(head);
            head.setNext(novo);
        }
        insertLastRecursivo(element, head.next);
    }

    @Override
    public void insertPosition(int position, T element) {
        throw new UnsupportedOperationException("Escolha insertPositionIterativo ou insertPositionRecursivo");
    }

    public void insertPositionIterativo(int position, T element) {
        throw new UnsupportedOperationException("Unimplemented method 'insertPositionIterativo'");
    }

    public void insertPositionRecursivo(int position, T element) {
        throw new UnsupportedOperationException("Unimplemented method 'insertPositionRecursivo'");
    }

    @Override
    public void removeFirst() {
        throw new UnsupportedOperationException("Escolha removeFirstIterativo ou removeFirstRecursivo");
    }

    public void removeFirstIterativo() {
        throw new UnsupportedOperationException("Unimplemented method 'removeFirstIterativo'");
    }

    public void removeFirstRecursivo() {
        throw new UnsupportedOperationException("Unimplemented method 'removeFirstRecursivo'");
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Escolha removeLastIterativo ou removeLastRecursivo");
    }

    public void removeLastIterativo() {
        throw new UnsupportedOperationException("Unimplemented method 'removeLastIterativo'");
    }

    public void removeLastRecursivo() {
        throw new UnsupportedOperationException("Unimplemented method 'removeLastRecursivo'");
    }

    @Override
    public void removeValue(T element) {
        throw new UnsupportedOperationException("Escolha removeValueIterativo ou removeValueRecursivo");
    }

    public void removeValueIterativo(T element) {
        throw new UnsupportedOperationException("Unimplemented method 'removeValueIterativo'");
    }

    public void removeValueRecursivo(T element) {
        throw new UnsupportedOperationException("Unimplemented method 'removeValueRecursivo'");
    }

    @Override
    public void removePosition(int position) {
        throw new UnsupportedOperationException("Escolha removePositionIterativo ou removePositionRecursivo");
    }

    public void removePositionIterativo(int position) {
        throw new UnsupportedOperationException("Unimplemented method 'removePositionIterativo'");
    }

    public void removePositionRecursivo(int position) {
        throw new UnsupportedOperationException("Unimplemented method 'removePositionRecursivo'");
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Escolha toArrayIterativo ou toArrayRecursivo");
    }

    public T[] toArrayIterativo() {
        throw new UnsupportedOperationException("Unimplemented method 'toArrayIterativo'");
    }

    public T[] toArrayRecursivo() {
        throw new UnsupportedOperationException("Unimplemented method 'toArrayRecursivo'");
    }

    @Override
    public boolean contains(T element) {
        throw new UnsupportedOperationException("Escolha containsIterativo ou containsRecursivo");
    }

    public boolean containsIterativo(T element) {
        throw new UnsupportedOperationException("Unimplemented method 'containsIterativo'");
    }

    public boolean containsRecursivo(T element) {
        throw new UnsupportedOperationException("Unimplemented method 'containsRecursivo'");
    }

    /* ===== os outros métodos da interface seguem o MESMO PADRÃO ===== */
}
