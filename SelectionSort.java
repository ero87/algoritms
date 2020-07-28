package am.example.algoritms;

public class SelectionSort {

    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {12, 33, 5, 87, 11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }

    private void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    private void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
