import java.util.Random;

public class SortingPerformanceComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void measurePerformance(int size) {
        int[] arrayForBubbleSort = new Random().ints(size, 1, 10000).toArray();
        int[] arrayForSelectionSort = arrayForBubbleSort.clone(); // Clone to keep original

        long startTime = System.nanoTime();
        bubbleSort(arrayForBubbleSort);
        long bubbleSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        selectionSort(arrayForSelectionSort);
        long selectionSortTime = System.nanoTime() - startTime;

        System.out.println("Array size: " + size);
        System.out.println("Bubble Sort time: " + bubbleSortTime / 1000000 + " ms");
        System.out.println("Selection Sort time: " + selectionSortTime / 1000000 + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        for (int size : new int[]{100, 500, 1000, 5000, 10000}) {
            measurePerformance(size);
        }
    }
}
