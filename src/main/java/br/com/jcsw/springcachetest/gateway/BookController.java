package br.com.jcsw.springcachetest.gateway;

import br.com.jcsw.springcachetest.entity.Book;
import br.com.jcsw.springcachetest.usecase.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/books/{isbn}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Book> getByIsbn(@PathVariable String isbn) {
    return Mono.just(bookRepository.getByIsbn(isbn)) //
        .switchIfEmpty(Mono.error(new RuntimeException(String.format("isbn:%s not found", isbn))));
  }

}
