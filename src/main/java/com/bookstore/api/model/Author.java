package com.bookstore.api.model;

import com.bookstore.api.model.serializer.AuthorSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
@Table(name = "author")
@JsonSerialize(using = AuthorSerializer.class)
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT t FROM Author t"),
    @NamedQuery(name = "Author.findById", query = "SELECT t FROM Author t Where t.id = :id")})

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "from_date")
    private Timestamp fromDate;

    @Column(name = "thru_date")
    private Timestamp thruDate;

    @Column(name = "egn")
    private String egn;

    @OneToMany(mappedBy = "author")
    @JoinFetch(value = JoinFetchType.OUTER)
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getThruDate() {
        return thruDate;
    }

    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
