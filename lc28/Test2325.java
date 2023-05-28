public class Test2325 {
    public String decodeMessage(String key, String message) {
        char[] secret = new char[26];
        char c = 'a';
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) < 'a' || key.charAt(i) > 'z') {
                continue;
            }
            if (secret[key.charAt(i) - 'a'] == 0) {
                secret[key.charAt(i) - 'a'] = c++;
            }
        }
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < 'a' || charArray[i] > 'z') {
                continue;
            }
            charArray[i] = secret[charArray[i] - 'a'];
        }
        // return charArray.toString();
        return new String(charArray);
    }
    
    public static void main(String[] args) {
        // char[] cs = new char[] { 'a', 'b', 'c' };
        // System.out.println(cs.toString());
        // System.out.println(new String(cs));
        // "the quick brown fox jumps over the lazy dog"
        // "vkbs bs t suepuv"
        System.out.println(new Test2325()
                .decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"));
    }
}
