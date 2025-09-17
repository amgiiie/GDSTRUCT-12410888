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

        System.out.println("+--------ORIGINAL SORT--------+");
        printArrayElements(numbers);

        System.out.println("\n\n+--------BUBBLE SORTING-------+");
        System.out.println("[Ascending Order] After Bubble Sort: ");
        bubbleSortAscending(numbers);
        printArrayElements(numbers);

        System.out.println("\n\n[Descending Order] After Bubble Sort: ");
        bubbleSortDescending(numbers);
        printArrayElements(numbers);

        System.out.println("\n\n+--------SELECTION SORTING-------+");
        System.out.println("[Ascending Order] After Selection Sort: ");
        selectionSortAscending(numbers);
        printArrayElements(numbers);

        System.out.println("\n\n[Descending Order] After Selection Sort: ");
        selectionSortDescending(numbers);
        printArrayElements(numbers);
    }

    private static void bubbleSortAscending(int[] arr){
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
    private static void bubbleSortDescending(int[] arr){
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex  > 0; lastUnsortedIndex-- ) {
            for(int i = 0; i < lastUnsortedIndex; i++){
                if(arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
    private static void selectionSortAscending(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int largest = 0;

            for(int i = 1; i <= lastUnsortedIndex; i++) {

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
    private static void selectionSortDescending(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int smallest = 0;

            for(int i = 1; i <= lastUnsortedIndex; i++) {

                if (arr[i] < arr[smallest]) {
                    smallest = i;
                }
            }

            if (smallest != lastUnsortedIndex) {
                int temp = arr[smallest];
                arr[smallest] = arr[lastUnsortedIndex];
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



