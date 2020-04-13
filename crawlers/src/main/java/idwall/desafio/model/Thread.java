package idwall.desafio.model;

/**
 * Created by Manuel Almeida   on 13/02/2018.
 */
public class Thread {
    private String score;
    private String subrreddit;
    private String title;
    private String commentLink;

    /**
     * Instantiates a new Reddit.
     *
     * @param score       the score
     * @param subrreddit  the subrreddit
     * @param title       the title
     * @param commentLink the comment link
     */
    public Thread(String score, String subrreddit, String title, String commentLink) {
        this.score = score;
        this.subrreddit = subrreddit;
        this.title = title;
        this.commentLink = commentLink;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSubrreddit() {
        return subrreddit;
    }

    public void setSubrreddit(String subrreddit) {
        this.subrreddit = subrreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentLink() {
        return commentLink;
    }

    public void setCommentLink(String commentLink) {
        this.commentLink = commentLink;
    }

    @Override
    public String toString() {
        return "Thread{" +
                "SCORE= " + score +
                ",SUB_REDDIT=' " + subrreddit + '\'' +
                ",TITLE=' " + title + '\'' +
                ", LINK=' " + commentLink + '\'' +
                '}'+"\n";
    }
}
