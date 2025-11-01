class Transaction {
    String name;
    String city;
    int amount;
    int time;
    String raw;

    Transaction(String t) {
        String[] words = t.split(",");
        name = words[0];
        city = words[3];
        time = Integer.parseInt(words[1]);
        amount = Integer.parseInt(words[2]);
        raw = t;
    }
}

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String transaction: transactions) {
            Transaction t = new Transaction(transaction);
            map.computeIfAbsent(t.name, k -> new ArrayList<>()).add(t);
        }

        for (String transaction: transactions) {
            Transaction t = new Transaction(transaction);

            if (isInvalid(t, map)) res.add(transaction);
        }

        return res;
    }

    private boolean isInvalid(Transaction t, Map<String, List<Transaction>> map) {
        if (t.amount > 1000) return true;

        for (Transaction transaction: map.get(t.name)) {
            if (!transaction.city.equals(t.city) && Math.abs(transaction.time-t.time) <= 60) {
                return true; 
            }
        }
        return false;
    }
}