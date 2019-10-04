package com.bookstore.api.model;

import com.bookstore.api.model.serializer.BillSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
@Table(name = "bill")
@JsonSerialize(using = BillSerializer.class)
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT t FROM Bill t")
    ,
    @NamedQuery(name = "Bill.findById", query = "SELECT t FROM Bill t Where t.id = :id")})

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "from_date")
    private Timestamp fromDate;

    @Column(name = "thru_date")
    private Timestamp thruDate;

    @Column(name = "total")
    private Double total;

    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "bill")
    @JoinFetch(value = JoinFetchType.OUTER)
    private List<BillItem> billItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

}
