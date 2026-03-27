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

    /*MÉTODOS*/

    @Override
    public int size() {
        return sizeRecursivo(this);
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
        return searchRecursivo(element, this);
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
        return searchPositionRecursivo(position, this);
    }

    public T searchPositionIterativo(int position, SingleLinkedListImpl<T> head) {
        T result = null;
        if (position >= 0) {
            SingleLinkedListImpl<T> aux = head;
            while (aux != null && aux.getData() != null && position > 0) {
                position--;
                aux = aux.getNext(); //Até chegar onde eu quero
            }
            if (aux != null && !aux.isEmpty()) {
                result = aux.getData();
            }
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
        insertFirstRecursivo(element, this);
    }

    public void insertFirstIterativo(T element, SingleLinkedListImpl<T> head) {
        SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
        novo.setData(element);
        novo.setNext(head);
    }

    public void insertFirstRecursivo(T element, SingleLinkedListImpl<T> head) {
    if (element != null) {
        SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
        novo.setData(head.getData());
        novo.setNext(head.getNext());
        head.setData(element);
        head.setNext(novo);
    }
}

    @Override
    public void insertLast(T element) {
        insertLastRecursivo(element, this);
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
        if (head.isEmpty()) {
            head.setData(element);
        } 
        else if (head.getNext() == null) {
            SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
            novo.setData(element);
            head.setNext(novo);
        } 
        else {
            insertLastRecursivo(element, head.getNext());
        }
    }

    @Override
    public void insertPosition(int position, T element) {
        insertPositionRecursivo(position, element, this);
    }

    private void insertPositionRecursivo(int position, T element, SingleLinkedListImpl<T> head) {
        if (element != null && !head.isEmpty()) {
            if (position == 0) { //Cheguei onde eu quero
                SingleLinkedListImpl<T> novo = new SingleLinkedListImpl<>();
                novo.setData(element);
                novo.setNext(head.getNext());
                head.setNext(novo);
            } else {
                insertPositionRecursivo(position - 1, element, head.getNext());
            }
        }
    }

    @Override
    public void removePosition(int position) {
        removePositionRecursivo(position, this);
    }

    private void removePositionRecursivo(int position, SingleLinkedListImpl<T> head) {
        if (!head.isEmpty() && head.getNext() != null) { //meu nó não sendo vázio, e tendo o próximo
            if (position == 1) { //Cheguei onde eu queria, no antecessor dele
                head.setNext(head.getNext().getNext()); 
            } else {
                removePositionRecursivo(position -1, head.getNext()); //passo indutivo
            }
        }
        
    }

    @Override
    public T[] toArray() {
        return toArrayRecursivo();
    }

    private T[] toArrayIterativo() {
        int tamanho = sizeIterativo(this);
        T[] result = (T[]) new Object[tamanho];

        SingleLinkedListImpl<T> aux = this;
        int i = 0;

        while (aux != null && !aux.isEmpty()) {
            result[i] = aux.getData();
            aux = aux.getNext();
            i++;
        }
        return result;
    }

    private T[] toArrayRecursivo() {
        int tamanho = sizeRecursivo(this);
        T[] result = (T[]) new Object[tamanho];
        toArrayRecursivoAux(this, result, 0);
        return result;
    }


    private void toArrayRecursivoAux(SingleLinkedListImpl<T> head, T[] array, int index) {
        if (head != null && !head.isEmpty()) {
            array[index] = head.getData();
            toArrayRecursivoAux(head.getNext(), array, index + 1);
        }
    }

    @Override
    public boolean contains(T element) {
        return containsRecursivo(element);
    }

    public boolean containsIterativo(T element) {
        boolean result = false;

        SingleLinkedListImpl<T> aux = this;

        while (aux != null && !aux.isEmpty() && !result) {
            if (aux.getData().equals(element)) {
                result = true;
            }
            aux = aux.getNext();
        }

    return result;
    }

    public boolean containsRecursivo(T element) {
        boolean result = false;
        if (!this.isEmpty()) {
            if (this.getData().equals(element)) {
                result = true;
            } else if (this.getNext() != null) {
                result = this.getNext().containsRecursivo(element);
            }
        }
        return result;
    } 

    @Override
    public void removeFirst() {
        removeFirstRecursivo();
    }

    public void removeFirstRecursivo() {
        if (!this.isEmpty()) {
            if (this.getNext() != null) {
                this.setData(this.getNext().getData());
                this.setNext(this.getNext().getNext());
            } else {
                this.setData(null);
                this.setNext(null);
            }
        }
    }

    @Override
    public void removeLast() {
        removeLastAux(this);
    }

    private void removeLastAux(SingleLinkedListImpl<T> head) {
        if (!head.isEmpty() && head.getNext() != null) {

            if (head.getNext().getNext() == null) {
                head.setNext(null);
            } else {
                removeLastAux(head.getNext());
            }
        }
    }

    @Override
    public void removeValue(T element) {
        removeValueAux(element, this);
    }

    private void removeValueAux(T element, SingleLinkedListImpl<T> head) {
        if (!head.isEmpty() && head.getNext() != null) {
            if (head.getNext().getData().equals(element)) {
                head.setNext(head.getNext().getNext());
            } else {
                removeValueAux(element, head.getNext());
            }
        }
        if (!head.isEmpty() && head.getData().equals(element)) {
            if (head.getNext() != null) {
                head.setData(head.getNext().getData());
                head.setNext(head.getNext().getNext());
            } else {
                head.setData(null);
            }
        }
    }
}
