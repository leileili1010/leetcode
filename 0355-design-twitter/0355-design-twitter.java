

class Twitter {
    private static int timeStamp = 0;
    private Map<Integer, User> userMap;
    
    // Tweet class to store tweet information
    private class Tweet {
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }
    
    // User class to manage user data
    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;
        
        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id); // follow itself
            this.tweetHead = null;
        }
        
        public void follow(int id) {
            followed.add(id);
        }
        
        public void unfollow(int id) {
            followed.remove(id);
        }
        
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }
    
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        
        if (!userMap.containsKey(userId)) {
            return res;
        }
        
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        
        // Add the head tweet of each followed user to the priority queue
        for (int user : users) {
            if (userMap.containsKey(user)) {
                Tweet t = userMap.get(user).tweetHead;
                if (t != null) {
                    pq.add(t);
                }
            }
        }
        
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            
            // Add the next tweet from the same user
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        
        return res;
    }
    
    /** Follower follows a followee */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */