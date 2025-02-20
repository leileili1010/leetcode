public class Codec {
    private List<Integer> list;
    // Encodes a list of strings to a single string.
    
    public Codec() {
        this.list = new ArrayList<>();
    }
    
    public String encode(List<String> strs) {
        list.clear();
        StringBuilder sb = new StringBuilder();
        
        for (String str: strs) {
            list.add(str.length());
            sb.append(str);
        }
        
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;

        for (int len : list) {
            if (index + len > s.length()) break; // Prevent out-of-bounds access
            String str = s.substring(index, index + len);
            res.add(str);
            index += len; // Move to the next word's start position
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));