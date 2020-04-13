package idwall.desafio.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Manuel Almeida   on 12/02/2018.
 */
public class IdwallJustify extends StringFormatter {
    private Integer limit;

    /**
     * Instantiates a new Idwall justify.
     *
     * @param limit the limit
     */
    public IdwallJustify(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String format(String text) {
        Scanner scanner = new Scanner(text);
        String answer = "";
        String line;
        int lineSize = 0;
        String breakLine = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            lineSize = line.length();
            breakLine = scanner.hasNext() ? "\n" : "";

            if (line.isEmpty()) {
                answer += "\n";
            } else {

                if (lineSize < this.limit) {
                    answer = answer + justify(line) + breakLine;
                } else {
                    answer = answer + line + breakLine;
                }
            }
        }
        return answer;
    }

    private String justify(String line) {

        String[] words = line.split(" ");
        int numberOfWhiteSpaces = words.length - 1;
        int remainingCharacters = (this.limit - line.length()) +numberOfWhiteSpaces;
        String answer = "";
        int j = 0; //auxliar indice

        for (int i = 0; i < remainingCharacters; i++) {
            if (j >= words.length - 1) {
                j = 0;
            }
            words[j] = words[j] + " ";
            j++;
        }
        answer = aggregate(words);
        return answer;
    }

    //Turn a String array into a single String
    private String aggregate(String[] words) {
        return Arrays.asList(words)
                .stream()
                .collect(Collectors.joining());
    }
}
