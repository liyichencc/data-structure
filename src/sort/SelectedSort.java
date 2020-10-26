package sort;

public class SelectedSort {


    public static void main(String[] args) {


        int arrays[] = {24,354,353,24,243};


        int temp;

        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;

            for (int j = 0 + i; j < arrays.length; j++) {

                if (arrays[j] < arrays[minIndex]) {
                    minIndex = j;
                }
            }

            temp = arrays[i];
            arrays[i] = arrays[minIndex];
            arrays[minIndex] = temp;
        }

    }
}
