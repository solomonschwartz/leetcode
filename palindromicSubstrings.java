class palindromicSubstrings {
    public int countSubstrings(String s) {
        int total = 0;
        char[] chars = s.toCharArray();
        // compute odd length
        for (int i = 0; i < chars.length; i++) {
            // each char itself is a palnidrome so increment total
            total++;
            total += compute(chars, i - 1, i + 1);
        }
        // compute even length
        for (int i = 0; i + 1 < chars.length; i++) {
            // each char itself is a palnidrome so increment total
            if (chars[i] == chars[i + 1]) {
                total++;
                total += compute(chars, i - 1, i + 2);
            }
        }
        return total;
    }

    private int compute(char[] chars, int left, int right) {
        if (left < 0 || right >= chars.length) {
            return 0;
        } else {
            if (chars[left] == chars[right]) {
                return 1 + compute(chars, left - 1, right + 1);
            }
            return 0;
        }
    }
}