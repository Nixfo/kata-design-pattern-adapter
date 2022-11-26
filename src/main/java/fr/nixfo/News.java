package fr.nixfo;

import java.time.LocalDate;
import java.util.List;

public class News {
    private Author author;
    private String title;
    private String content;
    private String summary;
    private LocalDate date;
    private List<String> keywords;

    public News() {
    }

    public News(Author author, String title, String content, String summary, LocalDate date, List<String> keywords) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.date = date;
        this.keywords = keywords;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
