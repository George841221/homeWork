package model;

import java.sql.Timestamp;

public class Blogs {

    private int blogId;
    private String title;
    private String blogText;
    private final Timestamp WROTE_ON_DATE;

    public Blogs(int blogId, String title, String blogText, Timestamp WROTE_ON_DATE) {
        this.blogId = blogId;
        this.title = title;
        this.blogText = blogText;
        this.WROTE_ON_DATE = WROTE_ON_DATE;
    }

        @Override
        public String toString() {
            return blogId +
                    ", " + title +
                    ", " + blogText +
                    ", " + WROTE_ON_DATE;
    }
}
