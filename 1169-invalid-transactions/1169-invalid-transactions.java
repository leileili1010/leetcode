class Solution {
    class Transaction {
        String name;
        String city;
        int time;
        int amount;

        Transaction(String s) {
            String[] parts = s.split(",");
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String s: transactions) {
            Transaction t = new Transaction(s);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for (String s: transactions) {
            Transaction t = new Transaction(s);
            if (!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))) 
                res.add(s);
        }

        return res;
    }

    private boolean isValid(Transaction t, List<Transaction> list) {
        if (t.amount > 1000) return false;

        for (Transaction transaction: list) {
            if (!t.city.equals(transaction.city) && Math.abs(t.time - transaction.time) <= 60) return false;
        }

        return true;
    }
}