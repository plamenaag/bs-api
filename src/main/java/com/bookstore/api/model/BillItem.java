package com.bookstore.api.model;

import com.bookstore.api.model.serializer.BillItemSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
@Table(name = "bill_item")
@JsonSerialize(using = BillItemSerializer.class)
@NamedQueries({
    @NamedQuery(name = "BillItem.findAll", query = "SELECT t FROM BillItem t")
    ,
    @NamedQuery(name = "BillItem.findById", query = "SELECT t FROM BillItem t Where t.id = :id")})

public class BillItem {

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

    @JoinColumn(name = "book_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @JoinColumn(name = "bill_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
