package idwall.desafio.string;

import java.util.Scanner;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 * Modified by Manuel Almeida on 12/0/2020
 */
public class IdwallFormatter extends StringFormatter {
    private Integer limit;
    private Boolean justify;

    public IdwallFormatter(Integer limit) {
        this.limit = limit;
    }

    /**
     * Should format as described in the challenge
     *
     * @param text
     * @return
     */
    @Override
    public String format(String text) {
        Scanner scanner = new Scanner(text);
        String answer = "";
        String line;
        while (scanner.hasNext()) {
            line= scanner.nextLine();
            if (line.isEmpty()) {
                answer += "\n\n";
            } else {
                answer += breakLine(line);
            }
        }
        return answer;
    }

    private String breakLine(String text) {
        String[] words = text.split(" ");
        String answer = "";
        String buffer = "";

        for (int i = 0; i < words.length; i++) {

            buffer = incrementBuffer(buffer, words[i]);

            if (buffer.length() > this.limit) {
                //Remove the last word that doesn't fit in the buffer
                buffer = removeLastWord(buffer, " " + words[i]);
                answer = answer + buffer + "\n";
                buffer = words[i];
            } else if (buffer.length() < this.limit) {
                //last buffer should be included to the answer
                if (i == words.length - 1)
                    answer = answer + buffer;

            } else {
                answer = answer + buffer + "\n";
                buffer = "";
            }
        }
        return answer;
    }

    //Increments a new word to the buffer and whitespace properly
    private String incrementBuffer(String text, String increment) {
        if (!text.isEmpty()) {
            return text + " " + increment;
        }
        return text + increment;
    }

    //Increments a new word to the buffer and whitespace properly
    private static String removeLastWord(String text, String lastWord) {
        return text.substring(0, text.length() - lastWord.length());
    }


}
