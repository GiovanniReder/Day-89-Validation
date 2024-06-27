package giovanni.validation.Blog;

import giovanni.validation.payloads.NewBlogPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    // 1. - POST http://localhost:3001/blogs (+ req.body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Blog saveBlog(@RequestBody NewBlogPayload body) {
        return blogService.save(body);
    }

    // 2. - GET http://localhost:3001/blogs
    @GetMapping("")
    public List<Blog> getBlogs(@RequestParam(required = false) Integer authorId) {
        if(authorId != null) return blogService.findByAuthor(authorId);
        else return blogService.getBlogs();
    }

    // 3. - GET http://localhost:3001/blogs/{id}
    @GetMapping("/{blogId}")
    public Blog findById(@PathVariable int blogId) {
        return blogService.findById(blogId);
    }

    // 4. - PUT http://localhost:3001/blogs/{id} (+ req.body)
    @PutMapping("/{blogId}")
    public Blog findAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPayload body) {
        return blogService.findByIdAndUpdate(blogId, body);
    }

    // 5. - DELETE http://localhost:3001/blogs/{id
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int blogId) {
        blogService.findByIdAndDelete(blogId);
    }
}

