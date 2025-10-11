class Solution {
    class Transaction {
        String name;
        String city;
        int time;
        int amount;

        Transaction(String s) {
            String[] arr = s.split(",");
            name = arr[0];
            time = Integer.parseInt(arr[1]);
            amount = Integer.parseInt(arr[2]);
            city = arr[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        for (String s: transactions) {
            Transaction t = new Transaction(s);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for (String s: transactions) {
            Transaction t = new Transaction(s);
            if (!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))) res.add(s);
        }

        return res;
    }

    private boolean isValid(Transaction t, List<Transaction> list) {
        if (t.amount > 1000) return false;

        for (Transaction transaction: list) {
            if (!t.city.equals(transaction.city) && Math.abs(t.time-transaction.time) <= 60) {
                return false;
            }
        }

        return true;
    }
}