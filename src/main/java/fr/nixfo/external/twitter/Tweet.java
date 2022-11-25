package fr.nixfo.external.twitter;

import java.util.List;

public class Tweet {
    /**
     * The unique identifier of the requested Tweet.
     */
    public long id;

    /**
     * The actual UTF-8 text of the Tweet. See twitter-text for details on what characters are currently considered valid.
     */
    public String text;

    /**
     * Unique identifiers indicating all versions of a Tweet. For Tweets with no edits, there will be one ID.
     * For Tweets with an edit history, there will be multiple IDs, arranged in ascending order reflecting the order of edits.
     * The most recent version is the last position of the array.
     */
    public long edit_history_tweet_ids;

    /**
     * Language of the Tweet, if detected by Twitter. Returned as a BCP47 language tag.
     */
    public String lang;

    /**
     * The name of the app the user Tweeted from.
     */
    public String source;

    /**
     * Entities that have been parsed out of the text of the Tweet. Additionally, see entities in Twitter Objects.
     * Entities are JSON objects that provide additional information about hashtags, urls, user mentions, and cashtags associated with a Tweet. Reference each respective entity for further details.
     * Please note that all start indices are inclusive. The majority of end indices are exclusive, except for entities.annotations.end, which is currently inclusive.
     * We will be changing this to exclusive with our v3 bump since it is a breaking change.
     */
    public List<Annotation> annotations;

    /**
     * If the represented Tweet is a reply, this field will contain the original Tweet’s author ID. This will not necessarily always be the user directly mentioned in the Tweet.
     */
    public long in_reply_to_user_id;

    /**
     * The unique identifier of the User who posted this Tweet.
     */
    public User user;

    /**
     * This field indicates content may be recognized as sensitive. The Tweet author can select within their own account preferences and choose “Mark media you tweet as having material that may be sensitive” so each Tweet created after has this flag set.
     * This may also be judged and labeled by an internal Twitter support agent.
     */
    public boolean possibly_sensitive;

    public Tweet includes;

    public Tweet(
        long id, String text, long edit_history_tweet_ids, String lang, String source, List<Annotation> annotations, long in_reply_to_user_id,
        User user,
        boolean possibly_sensitive, Tweet includes
    ) {
        this.id = id;
        this.text = text;
        this.edit_history_tweet_ids = edit_history_tweet_ids;
        this.lang = lang;
        this.source = source;
        this.annotations = annotations;
        this.in_reply_to_user_id = in_reply_to_user_id;
        this.user = user;
        this.possibly_sensitive = possibly_sensitive;
        this.includes = includes;
    }
}
