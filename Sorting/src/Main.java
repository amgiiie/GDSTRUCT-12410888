public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        numbers[0] = 25;
        numbers[1] = -3;
        numbers[2] = 5;
        numbers[3] = 10;
        numbers[4] = 38;
        numbers[5] = 62;
        numbers[6] = 20;
        numbers[7] = -8;
        numbers[8] = 173;
        numbers[9] = 65;

        System.out.println("Before Selection Sort: ");
        printArrayElements(numbers);

        System.out.println("\n\nAfter Selection Sort: ");
        selectionSOrt(numbers);
        printArrayElements(numbers);
    }

    private static void bubbleSort(int[] arr){
        // in place algorithm
        // outer for-loop (n-1) iterations
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex  > 0; lastUnsortedIndex-- ) {
            for(int i = 0; i < lastUnsortedIndex; i++){
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSOrt(int[] arr) {
        // in place algorithm
        // unstable algorithm
        // O(n^2) time complexity
        // (n^2 - 2n + 1) iterations total
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
           // (n-1) iterations outer for-loop
            int largest = 0;

            for(int i = 1; i <= lastUnsortedIndex; i++) {
                // (n-1) iterations inner for-loop
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }

            if (largest != lastUnsortedIndex) {
                int temp = arr[largest];
                arr[largest] = arr[lastUnsortedIndex];
                arr[lastUnsortedIndex] = temp;
            }
        }
    }
    private static void printArrayElements(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");

        }
    }
}
