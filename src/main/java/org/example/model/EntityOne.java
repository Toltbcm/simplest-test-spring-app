package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "entity_one")
public class EntityOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "column_1")
    private String columnOne;

    @Column(name = "column_2")
    private Integer columnTwo;

    @CreationTimestamp
    @Column(name = "column_3")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnOne() {
        return columnOne;
    }

    public void setColumnOne(String columnOne) {
        this.columnOne = columnOne;
    }

    public Integer getColumnTwo() {
        return columnTwo;
    }

    public void setColumnTwo(Integer columnTwo) {
        this.columnTwo = columnTwo;
    }

    @Override
    public String toString() {
        return "EntityOne{" +
                "id=" + id +
                ", columnOne='" + columnOne + '\'' +
                ", columnTwo='" + columnTwo + '\'' +
                '}';
    }
}
