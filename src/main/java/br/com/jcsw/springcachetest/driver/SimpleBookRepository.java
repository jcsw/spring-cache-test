package br.com.jcsw.springcachetest.driver;

import br.com.jcsw.springcachetest.entity.Book;
import br.com.jcsw.springcachetest.usecase.BookRepository;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

  private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);

  @Override
  @Cacheable("books")
  public Book getByIsbn(String isbn) {
    logger.info("method=getByIsbn isbn={}", isbn);

    simulateSlowService();
    return new Book( //
        isbn, //
        UUID.randomUUID().toString(), //
        UUID.randomUUID().toString(), //
        UUID.randomUUID().toString(), //
        new Date(), //
        UUID.randomUUID().toString(), //
        Integer.MAX_VALUE, //
        Integer.MAX_VALUE, //
        new Date());
  }

  private void simulateSlowService() {
    logger.info("method=simulateSlowService");
    try {
      long time = 200L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

}
