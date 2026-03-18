public class fixarExerciciosBB {

    // 1. Contar elementos menores que x
    public int countLess(Integer[] array, Integer x) {
        int result = lastOcor(array, x, 0, array.length - 1);
        return result + 1;
    }

    private int lastOcor(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] < valor && (mid == rightIndex || array[mid + 1] >= valor)) {
                result = mid;
            } else if (array[mid] >= valor) {
                result = lastOcor(array, valor, leftIndex, mid - 1);
            } else {
                result = lastOcor(array, valor, mid + 1, rightIndex);
            }
            }
        return result;
    }


    // 2. Verificar se x existe
    public int exists(Integer[] array, Integer x) {
        return exist(array, x, 0, array.length - 1);
    }


    private int exist(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] == valor) {
                result = mid;
            } else if (array[mid] < valor) {
                result = exist(array, valor, mid + 1, rightIndex);
            } else {
                result = exist(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }

     // 3. Primeira ocorrência de x
    public int firstOccurrence(Integer[] array, Integer x) {
        return firstOccurrenceAux(array, x, 0, array.length - 1);
    }

    private int firstOccurrenceAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid].equals(valor) && (mid == 0 || array[mid - 1] != valor)) {
                result = mid;
            } else if (array[mid] < valor) {
                result = firstOccurrenceAux(array, valor, mid + 1, rightIndex);
            } else {
                result = firstOccurrenceAux(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }








    

    // 4. Última ocorrência de x
    public int lastOccurrence(Integer[] array, Integer x) {
        throw new UnsupportedOperationException("Use lastOccurrenceIterativo");
    }

    // 5. Contar elementos >= x
    public int countGreaterOrEqual(Integer[] array, Integer x) {
        throw new UnsupportedOperationException("Use countGreaterOrEqualIterativo");
    }

    // 6. Ceil
    public int ceil(Integer[] array, Integer x) {
        throw new UnsupportedOperationException("Use ceilIterativo");
    }

    // 7. Floor
    public Integer floor(Integer[] array, Integer x) {
        throw new UnsupportedOperationException("Use floorIterativo");
    }

    // 10. Contar elementos no intervalo [a, b]
    public int countInRange(Integer[] array, Integer a, Integer b) {
        throw new UnsupportedOperationException("Use countInRangeIterativo");
    }

    // 11. Primeiro elemento > x
    public Integer firstGreater(Integer[] array, Integer x) {
        throw new UnsupportedOperationException("Use firstGreaterIterativo");
    }

    // 12. Contar ocorrências de x
    public int countOccurrences(Integer[] array, Integer x) {
        throw new UnsupportedOperationException("Use countOccurrencesIterativo");
    }

    // 13. Ponto de mudança
    public int findChangePoint(Integer[] array) {
        throw new UnsupportedOperationException("Use findChangePointIterativo");
    }

}
