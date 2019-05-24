package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/allBooks")
    public List<Book> allBooks(){
        List<Book> allBooks = memoryBookService.getList();
        return allBooks;
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id){
        return memoryBookService.getList().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().orElse(null);
    }

    /*
    {"id":10,
    "isbn":"943446",
    "title":"Best Book Ever",
    "author":"Krzysztof Jaczewski",
    "publisher":"Osprey Publishing",
    "type":"lifestyle"}
     */
    @PostMapping
    public void addBook(@RequestBody Book book){
        memoryBookService.addBook(book);
    }
}
