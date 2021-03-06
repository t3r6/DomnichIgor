package lesson6.exercise19;

import java.util.Arrays;

public class SelectionSorter {
    public static void sort(int[] array) {
        boolean b = false;

        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = array[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    b = true;
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            if (b) {
                array[pos] = array[i];
                array[i] = min;    // меняем местами наименьший с array[i]
                System.out.println(Arrays.toString(array));
                b = false;
            }
        }
    }

    public static void main(String[] args) {
        sort(new int[]{2, 8, 4, 6, 5});
    }
}
