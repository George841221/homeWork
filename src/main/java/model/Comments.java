package model;

import java.sql.Timestamp;

public class Comments {

    private int commentId;
    private String commenterName;
    private String commentText;
    private final Timestamp WROTE_ON_DATE;

    public Comments(int commentId, String commenterName, String commentText, Timestamp WROTE_ON_DATE) {
        this.commentId = commentId;
        this.commenterName = commenterName;
        this.commentText = commentText;
        this.WROTE_ON_DATE = WROTE_ON_DATE;
    }
}
