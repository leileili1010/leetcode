class Twitter {
    private static int timestamp = 0;

    // Tweet class to store tweet id and time
    private static class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // userId -> list of tweets (in reverse chronological order)
    private Map<Integer, List<Tweet>> tweets;

    // userId -> set of followees
    private Map<Integer, Set<Integer>> followees;

    public Twitter() {
        tweets = new HashMap<>();
        followees = new HashMap<>();
    }

    // Post a new tweet
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    // Get the 10 most recent tweet ids in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.time, b.time) // min-heap by time
        );

        // Ensure user follows themselves
        followees.putIfAbsent(userId, new HashSet<>());
        followees.get(userId).add(userId);

        for (int followeeId : followees.get(userId)) {
            List<Tweet> tweetList = tweets.getOrDefault(followeeId, new ArrayList<>());
            for (int i = tweetList.size() - 1; i >= 0 && i >= tweetList.size() - 10; i--) {
                pq.offer(tweetList.get(i));
                if (pq.size() > 10) {
                    pq.poll(); // keep only top 10 recent
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().id);
        }

        Collections.reverse(result); // latest tweets first
        return result;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (followeeId != followerId && followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}
