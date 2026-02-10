public class Sorter {
    private int[] numbers;

    public Sorter(int bound) {
        numbers = new int[bound];
    }
    public void selectionSort() {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
        }
    }
}
