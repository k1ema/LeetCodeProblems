package design.DesignTwitter_355;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwitterTest {
    @Test
    public void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        assertEquals(Collections.singletonList(5), twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        assertEquals(Arrays.asList(6, 5), twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        assertEquals(Collections.singletonList(5), twitter.getNewsFeed(1));

        twitter.postTweet(1, 3);
        assertEquals(Arrays.asList(3, 5), twitter.getNewsFeed(1));

        twitter.follow(1, 1);
        assertEquals(Arrays.asList(3, 5), twitter.getNewsFeed(1));
    }
}
