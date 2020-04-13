package idwall.desafio;

import idwall.desafio.string.IdwallFormatter;
import idwall.desafio.string.IdwallJustify;
import idwall.desafio.string.StringFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Modified by Manuel Almeida  on 12/02/2018.
 */
public class TestFormatter {


    private static final String INPUT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

    private static final Integer LIMIT = 40;

    private static final StringFormatter resize = new IdwallFormatter(LIMIT);
    private static final StringFormatter justify = new IdwallJustify(LIMIT);

    @Test
    public void verifyLineGreaterThanLimit() {
        String result = resize.format(INPUT);
        System.out.println(result);
        String[] lines = result.split("\n");

        for (String line : lines) {
            Assertions.assertTrue(line.length() <= 40);
        }
    }

    @Test
    public void verifyAllLinesSizeEqualToLimit() {
        String resizeResult = resize.format(INPUT);
        String result = justify.format(resizeResult);
        System.out.println(result);
        String[] lines = result.split("\n");

        for (String line : lines) {

            Assertions.assertTrue(line.length() == 40 || line.length() == 0);
        }



    }

}
