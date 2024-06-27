package giovanni.validation.Blog;

import giovanni.validation.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends JpaRepository<Blog , Integer> {
    List<Blog> findByAuthor(Author author);
}
