public class Codec {
    List<Integer> list;

    public Codec() {
        list = new ArrayList<>();
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        list.clear(); // must clear first
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str);
            list.add(str.length());
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int n = list.size();
        List<String> res = new ArrayList<>();
        int start = 0;

        for (int len: list) {
            res.add(s.substring(start, start+len));
            start = start + len;
        }

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));