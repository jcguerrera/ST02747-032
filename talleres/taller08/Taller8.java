package taller8;

/**
 * @author spulgarinv, jcguerrera, jjesucderv
 */
public class Taller8 {

	public static void mergesort(int[] arr) {
		mergesort(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static void mergesort(int[] arr, int[] aux, int a, int b) {
		if (b <= a)
			return;
		int mitad = a + (b - a) / 2;
		mergesort(arr, aux, a, mitad);
		mergesort(arr, aux, mitad + 1, b);
		merge(arr, aux, a, mitad, b);
	}

	private static void merge(int[] arr, int[] aux, int a, int mitad, int b) {
		for (int l = a; l <= b; ++l)
			aux[l] = arr[l];
		int i = a, j = mitad + 1;
		for (int l = a; l <= b; ++l) {
			if (i > mitad)
				arr[l] = aux[j++];
			else if (j > b)
				arr[l] = aux[i++];
			else if (aux[j] < aux[i])
				arr[l] = aux[j++];
			else
				arr[l] = aux[i++];
		}
	}

	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}
        
	private static void quicksort(int[] arr, int a, int b) {
		if (a >= b)
			return;
		int id = partition(arr, a, b);
		quicksort(arr, a, id - 1);
		quicksort(arr, id + 1, b);
	}
        
	private static int partition(int[] arr, int a, int b) {
		int id = arr[b];
		int i = a - 1;
		for (int j = a; j < b; ++j)
			if (arr[j] <= id)
				swap(arr, ++i, j);
		++i;
		swap(arr, i, b);
		return i;
	}

	private static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

}