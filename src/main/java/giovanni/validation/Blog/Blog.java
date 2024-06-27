package giovanni.validation.Blog;

import giovanni.validation.Author.Author;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
}
