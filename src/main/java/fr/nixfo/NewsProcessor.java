package fr.nixfo;

import java.util.List;

public class NewsProcessor {
    private List<News> news;

    public NewsProcessor(List<News> news) {
        this.news = news;
    }

    public void process() {
        news.forEach(news -> {
            System.out.println("=====================");
            System.out.println("=== Breaking news ===");
            System.out.println("=====================");
            System.out.println(news.getTitle());
        });
    }
}
