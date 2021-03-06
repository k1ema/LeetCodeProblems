package design.DesignTwitter_355;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 355. Design Twitter
 * https://leetcode.com/problems/design-twitter/
 *
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow
 * another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 * - postTweet(userId, tweetId): Compose a new tweet.
 * - getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the
 * user herself. Tweets must be ordered from most recent to least recent.
 * - follow(followerId, followeeId): Follower follows a followee.
 * - unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 * Example:
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {
    private final Map<Integer, User> usersMap;
    private static int timestamp = 0;

    private class Tweet {
        final int id;
        final int time;

        Tweet(int id) {
            this.id = id;
            time = timestamp++;
        }

        int getId() {
            return id;
        }

        long getTime() {
            return time;
        }
    }

    private class User {
        final int userId;
        final Stack<Tweet> tweets = new Stack<>();
        final Set<User> followers = new HashSet<>();

        User(int userId) {
            this.userId = userId;
        }

        void postTweet(int tweetId) {
            tweets.push(new Tweet(tweetId));
        }

        void follow(User followee) {
            followers.add(followee);
        }

        void unfollow(User followee) {
            followers.remove(followee);
        }

        List<Integer> getNewsFeed() {
            return Stream.concat(tweets.stream(), followers.stream().flatMap(user -> user.getTweets().stream()))
                    .distinct()
//                    .sorted(Comparator.comparingLong(Tweet::getTime).reversed())
                    .sorted((t1, t2) -> Long.compare(t2.time, t1.time))
                    .limit(10)
                    .map(Tweet::getId)
                    .collect(Collectors.toList());
        }

        public List<Tweet> getTweets() {
            return tweets;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return userId == user.userId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId);
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        usersMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        usersMap.computeIfAbsent(userId, f -> new User(userId)).postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news
     * feed must be posted by users who the user followed or by the user herself. Tweets must
     * be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
//        return usersMap.computeIfAbsent(userId, f -> new User(userId)).getNewsFeed();

        // better perfomance - 69ms vs 91ms with lambdas
        if (!usersMap.containsKey(userId)) {
            return new LinkedList<>();
        }

        User user = usersMap.get(userId);
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> b.time - a.time);
        queue.addAll(user.tweets);
        for (User follower : user.followers) {
            if (follower != user) {
                queue.addAll(follower.getTweets());
            }
        }

        List<Integer> result = new LinkedList<>();
        int n = 0;
        while (!queue.isEmpty() && n < 10) {
            Tweet tweet = queue.poll();
            result.add(tweet.id);
            n++;
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User followee = usersMap.computeIfAbsent(followeeId, f -> new User(followeeId));
        usersMap.computeIfAbsent(followerId, f -> new User(followerId)).follow(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User followee = usersMap.computeIfAbsent(followeeId, f -> new User(followeeId));
        usersMap.computeIfAbsent(followerId, f -> new User(followerId)).unfollow(followee);
    }
}
