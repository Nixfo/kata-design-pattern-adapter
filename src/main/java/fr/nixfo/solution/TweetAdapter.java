package fr.nixfo.solution;

import fr.nixfo.Author;
import fr.nixfo.News;
import fr.nixfo.external.twitter.Tweet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TweetAdapter extends News {
    private final Tweet tweet;

    public TweetAdapter(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public Author getAuthor() {
        return new Author(tweet.user.name + " (@" + tweet.user.username + ")", "");
    }

    @Override
    public String getTitle() {
        String text;
        if (tweet.includes != null) {
            text = "Thread";
        } else {
            text = "Tweet";
        }
        return text + " from @" + tweet.user.username;
    }

    @Override
    public String getContent() {
        StringBuilder content = new StringBuilder();
        Tweet actualTweet = tweet;

        do {
            content.append(actualTweet.text);
            actualTweet = actualTweet.includes;
        } while (actualTweet != null);

        return content.toString();
    }

    @Override
    public List<String> getKeywords() {
        List<String> keywords = new ArrayList<>();
        Tweet actualTweet = tweet;

        do {
            keywords.addAll(
                    actualTweet.annotations.stream()
                            .filter(annotation -> annotation.probability > 0.5)
                            .map(annotation -> annotation.normalized_text)
                            .collect(Collectors.toList())
            );

            actualTweet = actualTweet.includes;
        } while (actualTweet != null);


        return keywords;
    }
}
