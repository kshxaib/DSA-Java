class Tweet implements Comparable<Tweet>{
    int tweetId;
    int time;

    Tweet(int tweetId, int time){
        this.tweetId = tweetId;
        this.time = time;
    }

    @Override
    public int compareTo(Tweet newTweet) {
        return newTweet.time - this.time;   // descending order
    }
}

class User {
    int userId;
    HashSet<Integer> followees;
    List<Tweet> tweets;

    User(int userId){
        this.userId = userId;
        followees = new HashSet<>();
        tweets = new LinkedList<>();
    }
}

class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        timeCounter++;
        Tweet newTweet = new Tweet(tweetId, timeCounter);
        user.tweets.add(0, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);

        for(int followee : user.followees){
            int count = 0;

            for(Tweet tweet : userMap.get(followee).tweets){
                pq.offer(tweet);
                count++;

                if(count == 10){
                    break;
                }
            }
        }

        int count = 0;
        for(Tweet tweet : user.tweets){
            pq.offer(tweet);
            count++;

            if(count == 10){
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        int countLatestTweets = 0;

        while(!pq.isEmpty() && countLatestTweets < 10){
            result.add(pq.poll().tweetId);
            countLatestTweets++;
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }

        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;
        }

        User user = userMap.get(followerId);
        user.followees.remove(followeeId);
    }
}