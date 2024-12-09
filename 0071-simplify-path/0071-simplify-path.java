class Solution {
    public String simplifyPath(String path) {
        String[] strPath = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();
        String res = "";

        for (String s: strPath) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            String str = stack.pop();
            res = "/" + str + res;
        }

        return res;
    }
}