import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        String csvFile = "src\\aleatorio_100.csv";
        ArrayList<Integer> numbersList = new ArrayList<>();

        Bubblesort bubblesort = new Bubblesort();
        Quicksort quicksort = new Quicksort();
        InsertionSort insertionSort = new InsertionSort();



        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Ignora o cabeçalho
            String line;
            while ((line = br.readLine()) != null) {
                numbersList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();

       
        System.out.println("Original Array: ");


        int[] arrayBubble = numbers.clone();
        long startTime = System.nanoTime();
        bubblesort.sort(arrayBubble);
        long endTime = System.nanoTime();
        System.out.println("Tempo de execução do Bubble Sort: " + (endTime - startTime) + " ns");


        int[] arrayInsertion = numbers.clone();
        startTime = System.nanoTime();
        insertionSort.insertionSort(arrayInsertion);
        endTime = System.nanoTime();
        System.out.println("Tempo de execução do Insertion Sort: " + (endTime - startTime) + " ns");


        int[] arrayQuick = numbers.clone();
        startTime = System.nanoTime();
        quicksort.quickSort(arrayQuick, 0, arrayQuick.length - 1);
        endTime = System.nanoTime();
        System.out.println("Tempo de execução do QuickSort: " + (endTime - startTime) + " ns");

    }
}
