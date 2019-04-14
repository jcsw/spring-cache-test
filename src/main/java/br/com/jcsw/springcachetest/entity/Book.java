package br.com.jcsw.springcachetest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book implements Serializable {

  private String isbn;
  private String title;
  private String edition;
  private String author;

  @JsonProperty("release-date")
  private Date releaseDate;

  @JsonProperty("publishing-house")
  private String publishingHouse;

  @JsonProperty("digital-price")
  private Integer digitalPrice;

  @JsonProperty("physical-price")
  private Integer physicalPrice;

  @JsonProperty("registration-date")
  private Date registrationDate;

}
