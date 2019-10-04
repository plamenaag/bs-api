package com.bookstore.api.dao;
public class BaseDao {

    protected String startsWith(String term) {
        return term + "%";
    }

    protected String endsWith(String term) {
        return "%" + term;
    }

    protected String contains(String term) {
        return "%" + term + "%";
    }

}
