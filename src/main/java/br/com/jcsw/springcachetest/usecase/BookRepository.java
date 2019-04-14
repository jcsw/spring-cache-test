package br.com.jcsw.springcachetest.usecase;

import br.com.jcsw.springcachetest.entity.Book;

public interface BookRepository {

  Book getByIsbn(String isbn);

}
