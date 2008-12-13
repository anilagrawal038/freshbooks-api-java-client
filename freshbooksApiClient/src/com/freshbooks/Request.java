package com.freshbooks;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("request")
public class Request extends Message {
    @XStreamAsAttribute
    String method;
    
    // Filter parameters
    String email;
    String username;
    Integer page;
    @XStreamAlias("per_page")
    Integer perPage;
    
    @XStreamAlias("recurring_id")
    Long recurringId;
    String status;
    
    @XStreamAlias("date_from")
    Date dateFrom;
    @XStreamAlias("date_to")
    Date dateTo;
    
    
    public Request() {
    }

    public Request(RequestMethod method) {
        this(method.id);
    }
    public Request(RequestMethod method, String id) {
        this(method.id);
        switch(method) {
        case CLIENT_DELETE:
        case CLIENT_GET:
            this.clientId = id;
            break;
        case INVOICE_DELETE:
        case INVOICE_GET:
            this.invoiceId = id;
            break;
        case PAYMENT_DELETE:
        case PAYMENT_GET:
            this.paymentId = id;
            break;
        default:
            throw new UnsupportedOperationException("Don't know what to do with an id for method "+method);
        }
    }
    public Request(RequestMethod method, Client client) {
        this(method.id);
        this.client = client;
    }
    public Request(RequestMethod method, Invoice invoice) {
        this(method.id);
        this.invoice = invoice;
    }
    public Request(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Long getRecurringId() {
        return recurringId;
    }

    public void setRecurringId(Long recurringId) {
        this.recurringId = recurringId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }    
    
    
}
