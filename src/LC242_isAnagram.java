import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC242_isAnagram {

    //Optimal Approach: Count using a frequency array ------------------------------------------------------------------
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
    //------------------------------------------------------------------------------------------------------------------
    public boolean isAnagramWithHashMap(String s1, String s2) {
        Map<Character, Integer> s1Map = fillHashMapFromString(s1.toLowerCase());
        Map<Character, Integer> s2Map = fillHashMapFromString(s2.toLowerCase());

        return s1Map.equals(s2Map);
    }

    public HashMap<Character, Integer> fillHashMapFromString(String s) {
        HashMap<Character, Integer> resMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (resMap.containsKey(c)) {
                resMap.put(c, resMap.get(c) + 1);
            } else {
                resMap.put(c, 1);
            }
        }
        return resMap;
    }
    //------------------------------------------------------------------------------------------------------------------
    public boolean isAnagramWithArrays(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        return Arrays.equals(s1Arr, s2Arr);
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void main(final String... args) {

        //Optimal Approach: Count using a frequency array
        System.out.println(new LC242_isAnagram().isAnagram("friend".toLowerCase(), "Finder".toLowerCase()));
        //false
        System.out.println(new LC242_isAnagram().isAnagram("rat".toLowerCase(), "car".toLowerCase()));
        //Better Approach: Count using two HashMaps
        System.out.println(new LC242_isAnagram().isAnagramWithHashMap("friend".toLowerCase(), "Finder".toLowerCase()));
        //Brute force Approach: Sorting
        System.out.println(new LC242_isAnagram().isAnagramWithArrays("friend".toLowerCase(), "Finder".toLowerCase()));
    }
}

//Brute force Approach: Sorting
//https://medium.com/techsoftware/valid-anagram-leetcode-java-solution-e497872e5970#:~:text=If%20the%20sorted%20arrays%20of,are%20anagrams%2C%20and%20false%20otherwise.
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        char[] sc = s.toCharArray();
//        char[] tc = t.toCharArray();
//        Arrays.sort(sc);
//        Arrays.sort(tc);
//        if(new String(sc).equals(new String(tc)))
//            return true;
//        return false;
//    }
//}

//Better Approach: Count using two HashMaps
//https://medium.com/techsoftware/valid-anagram-leetcode-java-solution-e497872e5970#:~:text=If%20the%20sorted%20arrays%20of,are%20anagrams%2C%20and%20false%20otherwise.
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> count1 = new HashMap<>();
//        HashMap<Character, Integer> count2 = new HashMap<>();
//        count1 = count(count1, s);
//        count2 = count(count2, t);
//        return count1.equals(count2) ? true : false;
//    }
//    public HashMap<Character, Integer> count(HashMap<Character, Integer> count, String str) {
//        for(int i=0; i<str.length(); i++) {
//            Character c=str.charAt(i);
//            if(count.containsKey(c)) {
//                count.put(c, count.get(c)+1);
//                continue;
//            }
//            count.put(c, 1);
//        }
//        return count;
//    }
//}

//Optimal Approach: Count using a frequency array
//https://medium.com/techsoftware/valid-anagram-leetcode-java-solution-e497872e5970#:~:text=If%20the%20sorted%20arrays%20of,are%20anagrams%2C%20and%20false%20otherwise.
//public class Solution {
//    public boolean isAnagram(String s, String t) {
//        int[] alphabet = new int[26];
//        можно в один цикл сделать
//        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//        for (int i : alphabet) if (i != 0) return false;
//        return true;
//    }
//}


//тестирую возможность сравнения двух hashmap

// public void compareTwoHashMaps() {
//    Map<Character, Integer> s1map = new HashMap<>();
//    Map<Character, Integer> s2map = new HashMap<>();
//
//    s1map.put('f', 1);
//    s1map.put('r', 1);
//    s1map.put('i', 1);
//    s1map.put('e', 1);
//    s1map.put('n', 1);
//    s1map.put('d', 1);
//
//    s2map.put('f', 1);
//    s2map.put('i', 1);
//    s2map.put('n', 1);
//    s2map.put('d', 1);
//    s2map.put('e', 1);
//    s2map.put('r', 1);
//
//    System.out.println(s1map.equals(s2map));
//}

