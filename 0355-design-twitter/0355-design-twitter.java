class Twitter {
    
    private static int timeStamp=0;
	private Map<Integer, User> userMap;
    
    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId){
            this.tweetId = tweetId;
            this.time = timeStamp++;
            next = null;
        }
    }
    
    class User {
        int userId;
        Set<Integer> followedUsers;
        Tweet tweetHead;

        User(int userId) {
            this.userId = userId;
            followedUsers = new HashSet<>();
            follow(userId);
            tweetHead = null;
        }

        public void follow (int userId){
            followedUsers.add(userId);
        }

        public void unfollow (int userId) {
            followedUsers.remove(userId);
        }


        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    public Twitter() {
        
        this.userMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if(userMap.containsKey(userId) == false) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        
        if(userMap.containsKey(userId) == false) return result;
        
        Set<Integer> users = userMap.get(userId).followedUsers;
        
        PriorityQueue<Tweet> maxPQ = new PriorityQueue<>((a,b) -> (b.time - a.time));
        
        for(int user : users){
            Tweet tweet = userMap.get(user).tweetHead;
            
            if(tweet != null){
                maxPQ.add(tweet);
            }
        }
        
        int k = 0;
        
        while(maxPQ.size() > 0 && k < 10){
            Tweet tweet = maxPQ.poll();
            result.add(tweet.tweetId);
            
            if(tweet.next != null){
                maxPQ.add(tweet.next);
            }
            k++;  
        }
        
        return result;
        
        
        
        
        
    }
    
    public void follow(int followerId, int followeeId) {
        
         if(userMap.containsKey(followerId) == false) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        
         if(userMap.containsKey(followeeId) == false) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        
        userMap.get(followerId).follow(followeeId);
        
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(userMap.containsKey(followerId) == false || followeeId == followerId)
            return;
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