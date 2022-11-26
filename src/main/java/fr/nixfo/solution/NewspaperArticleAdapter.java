package fr.nixfo.solution;

import fr.nixfo.Author;
import fr.nixfo.News;
import fr.nixfo.external.newspaper.NewspaperArticle;

import java.time.LocalDate;
import java.time.ZoneId;

public class NewspaperArticleAdapter extends News {
    private final NewspaperArticle newspaperArticle;

    public NewspaperArticleAdapter(NewspaperArticle newspaperArticle) {
        this.newspaperArticle = newspaperArticle;
    }

    @Override
    public Author getAuthor() {
        String[] author = newspaperArticle.publishedBy.trim().split("\\s+");
        return new Author(author[0], author[1]);
    }

    @Override
    public String getTitle() {
        return newspaperArticle.title;
    }

    @Override
    public String getContent() {
        return newspaperArticle.article;
    }

    @Override
    public LocalDate getDate() {
        return newspaperArticle.newspaperDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
