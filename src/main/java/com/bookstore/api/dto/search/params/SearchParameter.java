package com.bookstore.api.dto.param.search;

import com.bookstore.api.Constants;
import java.util.ArrayList;
import java.util.List;

public class SearchParameter {

    

    private Integer pageNumber;
    private Integer pageSize;

    private Integer id;
    private Integer userId;
    private Long fromDate;
    private Long editDate;
    private Long thruDate;

    private Boolean noRefs;
    private Boolean refresh;
    private String serializationCase;

    private Boolean showActive;
    private Boolean showExpired;
    private Boolean showInactive;
    private Boolean deleted;

    private Integer accommodationId;
    private Integer bookingId;
    private Integer clientId;
    private Integer statusId;
    private Integer statusTypeId;
    private Integer resourceBookingId;
    private Integer accommodationClientId;
    
    private String code;
    private String settings;
    private String username;
    private String name;
    private String text;
    
    private String sortBy;
    private String orderBy;
    private String searchText;
    
    private Long startDateFrom;
    private Long startDateTo;
    private Long endDateFrom;
    private Long endDateTo;

    public SearchParameter(){
        this.pageNumber = 0;
        this.pageSize = 10;

        this.noRefs = false;
        this.refresh = false;
        this.showActive = true;
        this.showExpired = false;
        this.showInactive = true;
        this.deleted = false;
        this.orderBy = Constants.PARAM_ASCENDING_ORDER;
        this.sortBy = Constants.PARAM_ID;
    }

    public Integer getPageNumber() {
        return pageNumber*pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        if(pageNumber==null){
            pageNumber = 0;
        }else{
            pageNumber = pageNumber - 1; 
        }
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize==null){
            pageSize = 10;
        }
       
        this.pageSize = pageSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFromDate() {
        return fromDate;
    }

    public void setFromDate(Long fromDate) {
        this.fromDate = fromDate;
    }

    public Long getEditDate() {
        return editDate;
    }

    public void setEditDate(Long editDate) {
        this.editDate = editDate;
    }

    public Long getThruDate() {
        return thruDate;
    }

    public void setThruDate(Long thruDate) {
        this.thruDate = thruDate;
    }

    public Boolean getNoRefs() {
        return noRefs;
    }

    public void setNoRefs(Boolean noRefs) {
        this.noRefs = noRefs;
    }

    public Boolean getRefresh() {
        return refresh;
    }

    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }

    public Boolean getShowActive() {
        return showActive;
    }

    public void setShowActive(Boolean showActive) {
        this.showActive = showActive;
    }

    public Boolean getShowExpired() {
        return showExpired;
    }

    public void setShowExpired(Boolean showExpired) {
        this.showExpired = showExpired;
    }

    public Boolean getShowInactive() {
        return showInactive;
    }

    public void setShowInactive(Boolean showInactive) {
        this.showInactive = showInactive;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        if(sortBy!=null){
            this.sortBy = sortBy;
        }
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        if(orderBy!=null){
            this.orderBy = orderBy;
        }
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSerializationCase() {
        return serializationCase;
    }

    public void setSerializationCase(String serializationCase) {
        this.serializationCase = serializationCase;
    }
    
    public Integer getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Integer accommodationId) {
        this.accommodationId = accommodationId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getResourceBookingId() {
        return resourceBookingId;
    }

    public void setResourceBookingId(Integer resourceBookingId) {
        this.resourceBookingId = resourceBookingId;
    }

    public Integer getAccommodationClientId() {
        return accommodationClientId;
    }

    public void setAccommodationClientId(Integer accommodationClientId) {
        this.accommodationClientId = accommodationClientId;
    }

    public Integer getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }
    
    public List getSettingsList(){
        List arr = new ArrayList<>();
        if(settings!=null && !settings.equals(Constants.EMPTY_STRING)){
            for( String str : settings.split(",")){
                arr.add(str);
            }
        }
        return arr;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getStartDateFrom() {
        return startDateFrom;
    }

    public void setStartDateFrom(Long startDateFrom) {
        this.startDateFrom = startDateFrom;
    }

    public Long getStartDateTo() {
        return startDateTo;
    }

    public void setStartDateTo(Long startDateTo) {
        this.startDateTo = startDateTo;
    }

    public Long getEndDateFrom() {
        return endDateFrom;
    }

    public void setEndDateFrom(Long endDateFrom) {
        this.endDateFrom = endDateFrom;
    }

    public Long getEndDateTo() {
        return endDateTo;
    }

    public void setEndDateTo(Long endDateTo) {
        this.endDateTo = endDateTo;
    }
}
