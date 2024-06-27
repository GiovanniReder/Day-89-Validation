package giovanni.validation.Blog;

import lombok.Getter;

@Getter
public class NewBlogPayload {
    private int authorId;
    private String category;
    private String content;
    private double readingTime;
    private String title;
}
