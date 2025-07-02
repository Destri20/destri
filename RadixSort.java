public class RadixSort {

    // Fungsi untuk mendapatkan nilai maksimum dalam array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // Fungsi Counting Sort untuk mengurutkan array berdasarkan digit pada place tertentu
    public static void countingSort(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // digit 0-9

        // Hitung frekuensi digit
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        // Ubah count ke cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Susun output array secara stabil
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Salin hasil output ke array asli
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Fungsi utama Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Lakukan counting sort untuk setiap digit (place)
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }

    // Main method untuk testing
    public static void main(String[] args) {
        int[] dataKecil = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Data kecil sebelum sorting:");
        printArray(dataKecil);

        long startSmall = System.nanoTime();
        radixSort(dataKecil);
        long endSmall = System.nanoTime();

        System.out.println("Data kecil setelah sorting:");
        printArray(dataKecil);
        System.out.println("Durasi data kecil: " + (endSmall - startSmall) / 1_000_000.0 + " ms\n");

        // Generate data besar random 1000 elemen
        int[] dataBesar = new int[1000];
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 1000; i++) {
            dataBesar[i] = rand.nextInt(10_000); // angka 0 - 9999
        }

        System.out.println("Data besar (10 elemen pertama) sebelum sorting:");
        printPartialArray(dataBesar, 10);

        long startBig = System.nanoTime();
        radixSort(dataBesar);
        long endBig = System.nanoTime();

        System.out.println("Data besar (10 elemen pertama) setelah sorting:");
        printPartialArray(dataBesar, 10);
        System.out.println("Durasi data besar: " + (endBig - startBig) / 1_000_000.0 + " ms");
    }

    // Fungsi bantu print seluruh array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Fungsi bantu print sebagian array (misal 10 elemen pertama)
    public static void printPartialArray(int[] arr, int limit) {
        for (int i = 0; i < limit && i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
