package idwall.desafio.crawler;

import idwall.desafio.model.Thread;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Manuel Almeida   on 13/02/2018.
 */
public class RedditCrawler {


    /**
     * Nothing to do string.
     *
     * @param subredditList the subreddit list
     * @param cssQuery      the css query
     * @return the string
     */
    public String nothingToDo(String subredditList, String cssQuery) {

        List<List<Thread>> allReddits = Stream.of(subredditList.split(";"))
                .map(e -> getRedditFromURL(e, cssQuery))
                .collect(toList());

        return allReddits.stream().map(e -> e.toString()).collect(Collectors.joining("\n"));

    }

    /**
     * Gets reddit from url.
     *
     * @param subrredit the subrredit
     * @param cssQuery  the css query
     * @return the reddit from url
     */
    public List<Thread> getRedditFromURL(String subrredit, String cssQuery) {
        Document doc;
        List<Thread> reddits = new ArrayList<>();

        try {
            doc = Jsoup.connect("https://old.reddit.com/r/" + subrredit).get();
            Elements threads = doc.select(cssQuery);

            threads.stream().forEach(e -> reddits.add(
                    new Thread(e.attr("data-score"),
                            "r/" + subrredit,
                            e.select("a.title").text(),
                            e.attr("data-permalink")))
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
        return reddits;
    }
}
