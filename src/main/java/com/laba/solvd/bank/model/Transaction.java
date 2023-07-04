package com.laba.solvd.bank.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.laba.solvd.bank.parsers.DateAdapter;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "transaction")
public class Transaction {
    @XmlAttribute
    private Long id;
    @XmlElement
    @JsonProperty("transactionType")
    private String transactionType;
    @XmlElement
    private double amount;
    @JsonProperty("transactionDate")
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @XmlElement(name = "transactionDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date transactionDate;

    public Transaction() {

    }

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {

        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return id == that.id &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionType, amount, transactionDate);
    }


}
