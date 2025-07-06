public class kthCharacterInStringGame {
    public static void main(String[] args) {
        kthCharacter(5);
    }

    public static char kthCharacter(int k) {
        StringBuilder init = new StringBuilder("a");
        int len = 1;
        while (init.length() < k) {
            StringBuilder gen = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (init.charAt(i) == 'z') {
                    gen.append('a');
                    continue;
                }

                gen.append((char) (init.charAt(i) + 1));
            }
            init.append(gen);
            len = init.length();

        }

        return init.charAt(k - 1);
    }

}