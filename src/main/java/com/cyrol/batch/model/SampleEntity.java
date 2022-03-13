package com.cyrol.batch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SampleEntity {

    @Id
    private Long id;

    private Long accountID;

    private Date transactionDate;
    @Transient
    private String strTransactionDate;

    private String transactionType;

    private Double amount;
}
