public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for (String str: strs) {
            sb.append(str.length()).append('#').append(str);
       }
       return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int num = 0;
            while (i < n && s.charAt(i) != '#') {
                num = 10 * num + s.charAt(i)-'0';
                i++;
            }   
            
            res.add(s.substring(i+1, i+1+num));
            i = i + num;
        }
        return res;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));