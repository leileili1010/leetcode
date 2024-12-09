class Solution {
    public String simplifyPath(String path) {
        String[] strPath = path.split("/+");
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

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

       for (String dir : stack) {
            res.append("/").append(dir);
        }

        return res.toString();
    }
}