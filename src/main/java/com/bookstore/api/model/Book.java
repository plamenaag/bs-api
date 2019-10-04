package com.bookstore.api.model;

import com.bookstore.api.model.serializer.BookSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
@Table(name = "book")
@JsonSerialize(using = BookSerializer.class)
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT t FROM Book t"),
    @NamedQuery(name = "Book.findById", query = "SELECT t FROM Book t Where t.id = :id")})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;
    
    @Column(name = "count")
    private Integer count;
    
    @Column(name = "from_date")
    private Timestamp fromDate;
    
    @Column(name = "thru_date")
    private Timestamp thruDate;
    
    @JoinColumn(name = "author_id")
    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    private Author author;
    
    @OneToMany(mappedBy = "book")
    @JoinFetch(value = JoinFetchType.OUTER)
    private List<BillItem> billItems;
    
   public Book(){
       
   }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Timestamp getThruDate() {
        return thruDate;
    }

    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }
}
