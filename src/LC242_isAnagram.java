public class LC242_isAnagram {

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new LC242_isAnagram().isAnagram("friend".toLowerCase(), "Finder".toLowerCase()));
        System.out.println(new LC242_isAnagram().isAnagram("rat".toLowerCase(), "car".toLowerCase()));
    }
}