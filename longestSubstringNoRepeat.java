import java.util.HashSet;
class longestSubstringNoRepeat{
    public int lengthOfLongestSubstring(String s) {
        // we can make a hashset of all characters
        // for each char in str, we add to hashset
        // character
        int longest = 0;
        HashSet<Character> current = new HashSet<>();
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if(!current.add(s.charAt(i))){
                while(s.charAt(left) != s.charAt(i)){
                    current.remove(s.charAt(left));
                    left++;
                }
                current.remove(s.charAt(left));
                left++;
                current.add(s.charAt(i));
            }
            if (current.size() > longest)
                longest = current.size();
        }
        return longest;
    }
}
