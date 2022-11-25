package fr.nixfo.external.twitter;

public class User {
    /**
     * The unique identifier of this user.
     */
    public long id;

    /**
     * The name of the user, as they’ve defined it on their profile. Not necessarily a person’s name.
     * Typically capped at 50 characters, but subject to change.
     */
    public String name;

    /**
     * The Twitter screen name, handle, or alias that this user identifies themselves with. Usernames are unique but subject to change.
     * Typically, a maximum of 15 characters long, but some historical accounts may exist with longer names.
     */
    public String username;

    /**
     * The text of this user's profile description (also known as bio), if the user provided one.
     */
    public String description;

    /**
     * Indicates if this user is a verified Twitter User.
     */
    public boolean verified;

    public User(long id, String name, String username, String description, boolean verified) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.description = description;
        this.verified = verified;
    }
}
