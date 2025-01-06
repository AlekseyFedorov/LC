public class LC242_isAnagram {

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new LC242_isAnagram().isAnagram("friend", "Finder"));
    }
}