package com.bookstore.api.model;

import com.bookstore.api.model.serializer.UserSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
@Table(name = "user")
@JsonSerialize(using=UserSerializer.class)
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT t FROM User t"),
    @NamedQuery(name = "User.findById", query = "SELECT t FROM User t Where t.id = :id")})


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

    @Column(name = "from_date")
    private Timestamp fromDate;
    
    @Column(name = "thru_date")
    private Timestamp thruDate;
   
    
    @OneToMany(mappedBy = "user")
    @JoinFetch(value = JoinFetchType.OUTER)
    private List<Bill> bills;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
    
}
