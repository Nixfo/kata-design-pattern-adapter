package fr.nixfo.external.newspaper;

import java.awt.Image;
import java.util.Date;

public class NewspaperArticle {
    public String title;
    public Date newspaperDate;
    public String publishedBy;
    public Image image;

    public NewspaperArticle(String title, Date newspaperDate, String publishedBy, Image image) {
        this.title = title;
        this.newspaperDate = newspaperDate;
        this.publishedBy = publishedBy;
        this.image = image;
    }
}
