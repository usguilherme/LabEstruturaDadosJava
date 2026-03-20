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
        return lastOccurrenceAux(array, x, 0, array.length - 1);
    }

    private int lastOccurrenceAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid].equals(valor) && (mid == rightIndex || !array[mid + 1].equals(valor))) {
                result = mid;
            } else if (array[mid] <= valor) {
                result = lastOccurrenceAux(array, valor, mid + 1, rightIndex);
            } else {
                result = lastOccurrenceAux(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 5. Contar elementos >= x
    public int countGreaterOrEqual(Integer[] array, Integer x) {
        int valor = 0;
        int result = countGreaterOrEqualAux(array, x, 0, array.length - 1);
        if (result != -1) {
            valor = array.length - result;
        } 
        return valor;
    }

    private int countGreaterOrEqualAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] >= valor && (mid == 0 || array[mid -1] < valor)) {
                result = mid;
            } else if (array[mid] >= valor) {
                result = countGreaterOrEqualAux(array, valor, leftIndex, mid - 1);
            } else {
                result = countGreaterOrEqualAux(array, valor, mid + 1, rightIndex);
            }
        }
        return result;
    }

    // 6. Ceil
    public int ceil(Integer[] array, Integer x) {
        return ceilAux(array, x, 0, array.length - 1);
    }

    private int ceilAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] >= valor && (mid == 0 || array[mid - 1] < valor)) {
                result = mid;
            } else if (array[mid] < valor) {
                result = ceilAux(array, valor, mid + 1, rightIndex);
            } else {
                result = ceilAux(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 7. Floor
    public Integer floor(Integer[] array, Integer x) {
        return floorAux(array, x, 0, array.length - 1);
    }

    private int floorAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] <= valor && (mid == rightIndex || array[mid + 1] > valor)) {
                result = mid;
            } else if (array[mid] <= valor) {
                result = floorAux(array, valor, mid + 1, rightIndex);
            } else {
                result = floorAux(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 11. Primeiro elemento > x
    public Integer firstGreater(Integer[] array, Integer x) {
        return firstGreaterAux(array, x, 0, array.length - 1);
    }

    private int firstGreaterAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] > valor && (mid == 0 || array[mid + 1] <= valor)) {
                result = mid;
            } else if (array[mid] < valor) {
                result = firstOccurrenceAux(array, valor, mid + 1, rightIndex);
            } else {
                result = firstGreaterAux(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 12. Contar ocorrências de x
    public int countOccurrences(Integer[] array, Integer x) {
        int result = 0;
        int last = countLastOcorrenceAux(array, x, 0, array.length - 1);
        int first = countFirstOcorrenceAux(array, x, 0, array.length - 1);
        if (last != -1 && first != -1) {
            result = last - first + 1;
        }
        return result;
    }


    private int countFirstOcorrenceAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid].equals(valor) && (mid == 0 || !array[mid -1].equals(valor))) {
                result = mid;
            } else if (array[mid] >= valor) {
                result = countFirstOcorrenceAux(array, valor, leftIndex, mid - 1);
            } else {
                result = countFirstOcorrenceAux(array, valor, mid + 1, rightIndex);
            }
        }
        return result;
    }

    private int countLastOcorrenceAux(Integer[] array, Integer valor, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid].equals(valor) && (mid == rightIndex || !array[mid + 1].equals(valor))) {
                result = mid;
            } else if (array[mid] <= valor) {
                result = countLastOcorrenceAux(array, valor, mid + 1, rightIndex);
            } else {
                result = countLastOcorrenceAux(array, valor, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 12. Contar elementos no intervalo [a, b]
    public int countInRange(Integer[] array, Integer a, Integer b) {
        throw new UnsupportedOperationException("Use countInRangeIterativo");
    }


    // 13. Ponto de mudança
    public int findChangePoint(Integer[] array) {
        throw new UnsupportedOperationException("Use findChangePointIterativo");
    }

}
