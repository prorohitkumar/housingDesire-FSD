package com.stackroute.reviewservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="REVIEW")
public class Review {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String rating;
    private String suggestion;
}
