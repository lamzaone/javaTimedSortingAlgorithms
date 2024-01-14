import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("numere.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(new File("numere.txt"));
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fisierul nu a fost gasit.");
			return;
		}
    	// afisarea listei initiale
        System.out.println("Lista initiala:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("Numere in lista:" +list.size());
        System.out.println();
        
        // sortarea listei folosind fiecare metoda de sortare si afisarea rezultatelor
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind Bubblesort:");
        SortMethods.bubbleSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind Selection sort:");
        SortMethods.selectionSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind Insertion sort:");
        SortMethods.insertionSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind radix sort:");
        SortMethods.radixSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind counting sort:");
        SortMethods.countingSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind shaker sort:");
        SortMethods.shakerSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind shell sort:");
        SortMethods.shellSort(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind merge sort:");
        SortMethods.test(new ArrayList<Integer>(list));
        System.out.println();System.out.println();
        System.out.println("Sortarea folosind quick sort:");
        SortMethods.test2(new ArrayList<Integer>(list));
    }

	}


