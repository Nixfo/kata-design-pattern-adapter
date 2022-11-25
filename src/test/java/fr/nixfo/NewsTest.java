package fr.nixfo;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static org.junit.jupiter.api.Assertions.*;

import fr.nixfo.external.newspaper.NewspaperArticle;
import fr.nixfo.external.twitter.Annotation;
import fr.nixfo.external.twitter.User;
import fr.nixfo.external.twitter.Tweet;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

class NewsTest {

    @Test
    public void adapt_newspaper_article() {
        NewspaperArticle newspaperArticle = new NewspaperArticle("Article's title", new Date(), "John Doe", new BufferedImage(640, 480, TYPE_INT_RGB));


    }

    @Test
    public void adapt_one_tweet_from_twitter() {
        Tweet tweet = new Tweet(
            1050118621198921728L,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget risus est. Aliquam erat volutpat. Pellentesque quis orci libero.",
            1584717154800521216L,
            "latin",
            "Twitter Web App",
            List.of(
                new Annotation(0, 11, 1,  "Other", "Lorem ipsum"),
                new Annotation(79, 91, 0.6,  "Other", "Aliquam erat")
            ),
            0,
            new User(2244994945L, "Twitter Dev", "TwitterDev", "My bio", false),
            false,
            null
        );

    }

    @Test
    public void adapt_mutiples_tweets_from_twitter() {
        Tweet tweet2 = new Tweet(
                1050118621198921728L,
                "Nam arcu ante, molestie nec dignissim et, malesuada eget dui.",
                1584717154800521216L,
                "latin",
                "Twitter Web App",
                List.of(
                        new Annotation(28, 37, 0.2,  "Other", "dignissim")
                ),
                0,
                new User(2244994945L, "Twitter Dev", "TwitterDev", "My bio", false),
                false,
                null
        );

        Tweet tweet1 = new Tweet(
                1050118621198921728L,
                "Pellentesque quis orci libero.",
                1584717154800521216L,
                "latin",
                "Twitter Web App",
                List.of(
                        new Annotation(0, 12, 1,  "Other", "Pellentesque")
                ),
                0,
                new User(2244994945L, "Twitter Dev", "TwitterDev", "My bio", false),
                false,
                tweet2
        );


        Tweet tweet = new Tweet(
            1050118621198921728L,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget risus est. Aliquam erat volutpat.",
            1584717154800521216L,
            "latin",
            "Twitter Web App",
            List.of(
                new Annotation(0, 11, 1,  "Other", "Lorem ipsum"),
                new Annotation(79, 91, 0.6,  "Other", "Aliquam erat")
            ),
            0,
            new User(2244994945L, "Twitter Dev", "TwitterDev", "My bio", false),
            false,
            tweet1
        );


        News newsAdapted = null;
        assertEquals(newsAdapted.getAuthor(), "Twitter Dev (@TwitterDev)");
        assertEquals(newsAdapted.getContent(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget risus est. Aliquam erat volutpat." +
                        "Pellentesque quis orci libero." +
                        "Nam arcu ante, molestie nec dignissim et, malesuada eget dui.");
    }

}
