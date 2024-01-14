import java.util.*;

public class SortMethods {


    // metoda pentru sortarea prin bule
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        return list;
    }
    
    // metoda pentru sortarea prin selectie
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        return list;
    }
    
    // metoda pentru sortarea prin insertie
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
    	for (int i = 1; i < list.size(); i++) {
    		int key = list.get(i);
    		int j = i - 1;
    		while (j >= 0 && list.get(j) > key) {
    		list.set(j + 1, list.get(j));
    		j--;
    		}
    		list.set(j + 1, key);
    		}
        	long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
    		return list;
    		}
 // metoda pentru sortarea radix
    public static ArrayList<Integer> radixSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        int max = Collections.max(list);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortRadix(list, exp);
        }
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        return list;
    }

    // metoda auxiliara pentru sortarea radix
    public static void countingSortRadix(ArrayList<Integer> list, int exp) {
        int[] count = new int[10];
        ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(list.size(), 0));
        for (int i = 0; i < list.size(); i++) {
            count[(list.get(i) / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            output.set(count[(list.get(i) / exp) % 10] - 1, list.get(i));
            count[(list.get(i) / exp) % 10]--;
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, output.get(i));
        }
    }

 // metoda pentru sortarea prin numarare
    public static ArrayList<Integer> countingSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        int max = Collections.max(list);
        int[] counts = new int[max + 1];
        for (int i = 0; i < list.size(); i++) {
            counts[list.get(i)]++;
        }
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedList.add(i);
            }
        }
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        return sortedList;
    }

 // metoda pentru sortarea prin shaker
    public static ArrayList<Integer> shakerSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            for (int i = left; i < right; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (list.get(i) < list.get(i - 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                }
            }
            left++;
        }
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        return list;
    }
    
 // metoda pentru sortarea prin shell
    public static ArrayList<Integer> shellSort(ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        int n = list.size();
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = list.get(i);
                int j;
                for (j = i; j >= gap && list.get(j - gap) > temp; j -= gap) {
                    list.set(j, list.get(j - gap));
                }
                list.set(j, temp);
            }
        }
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        return list;
    }
    
 // metoda pentru sortarea prin interclasare
    public static void test (ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        int mid = list.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<Integer>(list.subList(0, mid));
        ArrayList<Integer> rightList = new ArrayList<Integer>(list.subList(mid, list.size()));
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);
        merge(leftList, rightList);
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
        }
    
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list; }
        int mid = list.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<Integer>(list.subList(0, mid));
        ArrayList<Integer> rightList = new ArrayList<Integer>(list.subList(mid, list.size()));
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);
        return merge(leftList, rightList);
        
        }
    
 // metoda auxiliara pentru sortarea prin interclasare
    public static ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {

        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) < rightList.get(j)) {
                mergedList.add(leftList.get(i));
                i++;
            } else {
                mergedList.add(rightList.get(j));
                j++;
            }
        }
        mergedList.addAll(leftList.subList(i, leftList.size()));
        mergedList.addAll(rightList.subList(j, rightList.size()));

        return mergedList;
    }

    // metoda pentru sortarea prin quicksort
    
    public static void test2 (ArrayList<Integer> list) {
    	long startTime = System.nanoTime();
        quickSort(list);
        long elapsedTime = System.nanoTime() - startTime;System.out.println("Total execution time in millis: " + elapsedTime/1000000);
    }
    public static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int pivot = list.get(0);
        ArrayList<Integer> smallerList = new ArrayList<Integer>();
        ArrayList<Integer> largerList = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < pivot) {
                smallerList.add(list.get(i));
            } else {
                largerList.add(list.get(i));
            }
        }
        smallerList = quickSort(smallerList);
        largerList = quickSort(largerList);
        smallerList.add(pivot);
        smallerList.addAll(largerList);
        return smallerList;
    }

    // metoda auxiliara pentru a calcula numarul maxim de cifre din lista
    public static int getMaxDigits(ArrayList<Integer> list) {
        int max = Collections.max(list);
        int digits = 0;
        while (max > 0) {
            digits++;
            max /= 10;
        }
        return digits;
    }

    // metoda auxiliara pentru a obtine cifra la pozitia i a numarului x
    public static int getDigit(int x, int i) {
        return (int) (x / Math.pow(10, i)) % 10;
    }
    
    

}