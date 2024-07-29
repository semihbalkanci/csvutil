package com.gerimedica.csvutil.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@lombok.Data
@Entity
public class CsvData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String source;
    private String codeListCode;
    private String code;
    private String displayValue;
    private String longDescription;
    private Date fromDate;
    private Date toDate;
    private Integer sortingPriority;
}
