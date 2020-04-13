package idwall.desafio;

import idwall.desafio.crawler.RedditCrawler;

/**
 * Created by Manuel Almeida   on 13/02/2018.
 */

public class Main {
    private static final String DEFAULT_SUBREDTIS = "askreddit;politics;facepalm";
    private static final String QUERY = "div[data-score~=[5-9]\\d{2,}].thing ";

    public static void main(String[] args) {

        RedditCrawler redditCrawler = new RedditCrawler();
        String subrredits = args.length > 0 ? args[0] : DEFAULT_SUBREDTIS;

        System.out.println(redditCrawler.nothingToDo(subrredits,QUERY));
    }
}
