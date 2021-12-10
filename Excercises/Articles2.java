package Excercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles2 {


    static class Article {
        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        String title;
        String content;
        String author;

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Article> articlesList = new ArrayList<>();


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");

            String title = input[0];
            String content = input[1];
            String author = input[2];

            Article article = new Article(title, content, author);
            articlesList.add(article);


        }
        String command = scanner.nextLine();

        switch (command){
            case "title":
                articlesList.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articlesList.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articlesList.sort(Comparator.comparing(Article::getAuthor));
                break;

        }

        for (Article a : articlesList) {
            System.out.println(a);
        }
    }
}
