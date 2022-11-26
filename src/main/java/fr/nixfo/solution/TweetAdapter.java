package fr.nixfo.solution;

import fr.nixfo.Author;
import fr.nixfo.News;
import fr.nixfo.external.twitter.Tweet;

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
        return "Tweet from @" + tweet.user.username;
    }

    @Override
    public String getContent() {
        return tweet.text;
    }

    @Override
    public List<String> getKeywords() {
        return tweet.annotations.stream().map(annotation -> annotation.normalized_text).collect(Collectors.toList());
    }
}
