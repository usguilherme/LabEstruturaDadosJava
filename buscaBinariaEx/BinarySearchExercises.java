public class BinarySearchExercises implements BinarySearchExercisesInterface { //Exercícios voltados para busca binária recursiva.

    // 1. Contar elementos menores que x
    public int countLess(Integer[] array, Integer x) {
        int last = -1;
        if (array != null && array.length > 0) {
            last = ultimaOcorrenciaMenor(array, x, 0, array.length - 1);
        }
        return last + 1;
    }

    private int ultimaOcorrenciaMenor(Integer[] array, int x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] < x && (mid == rightIndex || array[mid + 1] >= x)) { //Ultima ocorrencia
                result = mid;
            } else if (array[mid] < x) {
                result = ultimaOcorrenciaMenor(array, x, mid + 1, rightIndex);
            } else {
                result = ultimaOcorrenciaMenor(array, x, leftIndex, mid - 1);
            }  
        }
        return result;
    }

    // 2. Verificar se x existe
    public int exists(Integer[] array, Integer x) {
        int result = -1;
        if (array != null && array.length > 0) {
            result = auxExist(array, x, 0, array.length - 1);
        }
        return result;
    }

    private int auxExist(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] == x) {
                result = mid;
            } else if (array[mid] < x) {
                result = auxExist(array, x, mid + 1, rightIndex);
            } else {
                result = auxExist(array, x, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 3. Primeira ocorrência de x
    public int firstOccurrence(Integer[] array, Integer x) {
        int result = -1;
        if (array != null && array.length > 0) {
            result = auxFirst(array, x, 0, array.length - 1);
        }
        return result;
    }

    private int auxFirst(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] == x && (mid == 0 || array[mid - 1] < x)) {
                result = mid;
            } else if (array[mid] < x) {
                result = auxFirst(array, x, mid + 1, rightIndex);
            } else {
                result = auxFirst(array, x, leftIndex, mid - 1);
            }
        }
        return result;

    }

    // 4. Última ocorrência de x
    public int lastOccurrence(Integer[] array, Integer x) {
        int result = -1;
        if (array != null && array.length > 0) {
            result = auxLast(array, x, 0, array.length - 1);
        }
        return result;
    }

    private int auxLast(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
           int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] == x && (mid == rightIndex || array[mid + 1] != x)) {
                result = mid;
            } else if (array[mid] <= x) {
                result = auxLast(array, x, mid + 1, rightIndex);  
            } else {
                result = auxLast(array, x, leftIndex, mid - 1);
            } 
        }
        return result;
    }

    // --------------------------
    // Questões Intermediárias
    // --------------------------

    // 5. Contar elementos maiores ou iguais a x
    public int countGreaterOrEqual(Integer[] array, Integer x) {
        int result;
        int first = auxCountGreaterOrEqual(array, x, 0, array.length - 1);
        if (first == -1) {
            result = 0;
        } else {
            result = array.length - first;
        }
        return result;
    }

    public int auxCountGreaterOrEqual(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] >= x && (mid == 0 || array[mid - 1] < x)) { //Primeira ocorrencia ok
                result = mid;
            } else if (array[mid] < x) {
                result =  auxCountGreaterOrEqual(array, x, mid + 1, rightIndex);
            } else {
                result = auxCountGreaterOrEqual(array, x, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 6. Ceil: menor elemento >= x
    public int ceil(Integer[] array, Integer x) {
        int result = -1;
        if (array != null && array.length > 0) {
            result = auxCeil(array, x, 0, array.length - 1);
        }
        return result;
    }

    public int auxCeil(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] >= x && (mid == 0 || array[mid - 1] < x)) {
                result = mid;
            } else if (array[mid] < x ) {
                result = auxCeil(array, x, mid + 1, rightIndex);
            } else {
                result = auxCeil(array, x, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 7. Floor: maior elemento <= x
    public Integer floor(Integer[] array, Integer x) {
        int result = -1;
        if (array != null && array.length > 0) {
            result = auxFloor(array, x, 0, array.length - 1);
        }
        return result;
    }


    private int auxFloor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] <= x && (mid == rightIndex || array[mid + 1] > x)) {
                result = mid;
            } else if (array[mid] < x) {
                result = auxFloor(array, x, mid + 1, rightIndex);
            } else {
                result = auxFloor(array, x, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // --------------------------
    // Questões Avançadas
    // --------------------------

    // 10. Contar elementos dentro do intervalo [a, b]
    public int countInRange(Integer[] array, Integer a, Integer b) {
        int result = -1;
        int first = auxCountInRangeFirst(array, 0, array.length - 1, a, b);
        int last = auxCountInRangeLast(array, 0, array.length - 1, a, b);

        if (first == -1 || last == -1) {
            result = 0;
        } else {
            result = last - first + 1;
        }
        return result; 
    }

    private int auxCountInRangeFirst(Integer[] array, int leftIndex, int rightIndex, Integer a, Integer b) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] >= a && array[mid] <= b && (mid == 0 || array[mid - 1] < a || array[mid - 1] > b)) {
                result = mid;
            } else if (array[mid] < a) {
                result = auxCountInRangeFirst(array, mid + 1, rightIndex, a, b);
            } else {
                result = auxCountInRangeFirst(array, leftIndex, mid - 1, a, b);
            }
        }
        return result;
    }

     private int auxCountInRangeLast(Integer[] array, int leftIndex, int rightIndex, Integer a, Integer b) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] >= a && array[mid] <= b && (mid == rightIndex || array[mid + 1] < a || array[mid + 1] > b)) {
                result = mid;
            } else if (array[mid] < a) {
                result = auxCountInRangeLast(array, mid + 1, rightIndex, a, b);
            } else {
                result = auxCountInRangeLast(array, leftIndex, mid - 1, a, b);
            }
        }
        return result;
     }



    // 11. Primeiro elemento estritamente maior que x
    public Integer firstGreater(Integer[] array, Integer x) {
        int correct = auxFirstGreater(array, x, 0, array.length - 1);
        return correct;
    }

    private int auxFirstGreater(Integer[] array, Integer x, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] > x && (mid == 0 || array[mid - 1] <= x)) {
                result = array[mid];
            } else if (array[mid] <= x) {
                result = auxFirstGreater(array, x, mid + 1, rightIndex);
            } else {
                result = auxFirstGreater(array, x, leftIndex, mid - 1);
            }
        }
        return result;
    }

    // 12. Contar quantas vezes x aparece
    public int countOccurrences(Integer[] array, Integer x) {
        int result;
        int first = firstOccurrence(array, x);
        int last = lastOccurrence(array, x);
        if (first == -1 || last == -1) {
            result = 0;
        } else {
            result = last - first + 1;
        }
        return result;
    }

    
    // 13. Encontrar o ponto de mudança (primeira violação da ordenação)
    public int findChangePoint(Integer[] array) {
        return auxFindChangePoint(array, 0, array.length - 1);
    }

    private int auxFindChangePoint(Integer[] array, int leftIndex, int rightIndex) {
        int result = -1;
        if (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;

            if (mid + 1 < array.length && array[mid] > array[mid + 1]) {
                result = mid + 1;
            } else {
                if (array[leftIndex] <= array[mid]) {
                    result = auxFindChangePoint(array, mid + 1, rightIndex);
                } else {
                    result = auxFindChangePoint(array, leftIndex, mid - 1);
                }
            }
        }
        return result;

    }
}