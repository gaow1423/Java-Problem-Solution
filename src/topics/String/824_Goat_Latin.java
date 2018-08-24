/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

*/

class Solution {
    public String toGoatLatin(String S) {
        String[] strArr = S.split(" ");
        StringBuilder strBld = new StringBuilder();

        Set<Character> vowel = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        StringBuilder aCounter = new StringBuilder();
        aCounter.append("a");

        for (int i = 0; i < strArr.length; i++) {
            if (vowel.contains(strArr[i].toLowerCase().charAt(0))) {
                strBld.append(strArr[i] + "ma");
            } else {
                strBld.append(strArr[i].substring(1, strArr[i].length()) + strArr[i].charAt(0) + "ma");
            }
            strBld.append(aCounter + " ");
            aCounter.append("a");
        }
        return strBld.toString().substring(0, strBld.length() - 1);
    }
}
