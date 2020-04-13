package idwall.desafio;

import idwall.desafio.crawler.RedditCrawler;
import idwall.desafio.model.Thread;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
/**
 * Created by Manuel Almeida   on 13/02/2018.
 */

public class TestCrawler {
    private static final String SUBREDTIS = "askreddit";
    private static final String QUERY = "div[data-score~=[5-9]\\d{2,}].thing ";
    private static final List<Thread> threads = new RedditCrawler().getRedditFromURL("askreddit", QUERY);

    @Test
    public void verifyIfScoresAreGreaterThan500() {

        threads.stream()
                .filter(e-> e!=null)
                .forEach(e -> Assertions
                        .assertTrue(Integer.parseInt(e.getScore()) > 500 ));
    }
}





