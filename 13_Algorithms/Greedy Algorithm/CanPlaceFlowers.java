public class CanPlaceFlowers {

    public static void main(String[] args) {

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        
        for (int i = 0; i < len;) {
            if (flowerbed[i] == 1) {
                // be greedy and skip 2 steps instead of one
                i += 2;
            } else {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1]) == 0;
                boolean rightEmpty = (i == len - 1) || (flowerbed[i + 1]) == 0;

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0)
                        return true; // early pause in case we fulfill the condition
                    i += 2;
                } else {
                    i++;
                }
            }
        }

        return n == 0;

    }

    public static boolean noEdgeCaseHandlingcanPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && n == 1) {
            return flowerbed[0] == 0;
        }

        for (int i = 0; i < flowerbed.length; i = i + 2) {

            if (flowerbed[i] == 1) {
                continue;
            } else if ((flowerbed[i] == 0)
                    && ((i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0)
                            || (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0))) {
                n--;
            }
        }
        return n == 0;
    }
}
