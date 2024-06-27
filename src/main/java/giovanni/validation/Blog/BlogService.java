package giovanni.validation.Blog;

import giovanni.validation.Author.Author;
import giovanni.validation.Author.AuthorService;
import giovanni.validation.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AuthorService authorService;

    public Blog save(NewBlogPayload body) {
        Author author = authorService.findById(body.getAuthorId());
        Blog newBlogPost = new Blog();
        newBlogPost.setReadingTime(body.getReadingTime());
        newBlogPost.setContent(body.getContent());
        newBlogPost.setTitle(body.getTitle());
        newBlogPost.setAuthor(author);
        newBlogPost.setCategory(body.getCategory());
        newBlogPost.setCover("http://picsum.photos/200/300");
        return blogRepository.save(newBlogPost);
    }

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public Blog findById(int id) {
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        Blog found = this.findById(id);
        blogRepository.delete(found);
    }

    public Blog findByIdAndUpdate(int id, NewBlogPayload body) {
        Blog found = this.findById(id);

        found.setReadingTime(body.getReadingTime());
        found.setContent(body.getContent());
        found.setTitle(body.getTitle());
        found.setCategory(body.getCategory());

        if(found.getAuthor().getId()!= body.getAuthorId()) {
            Author newAuthor = authorService.findById(body.getAuthorId());
            found.setAuthor(newAuthor);
        }

        return blogRepository.save(found);
    }

    public List<Blog> findByAuthor(int authorId){
        Author author = authorService.findById(authorId);
        return blogRepository.findByAuthor(author);
    }
}
