
public class FruitsIntoBasket_2 {
    public static void main(String[] args) {

    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    count++;
                    break;
                }
            }
        }

        return baskets.length - count;

    }
}
