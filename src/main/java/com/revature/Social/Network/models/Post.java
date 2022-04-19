package com.revature.Social.Network.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String message;
    @Column
    private String pictureURL;

    @OneToMany
    private List<User> users = new ArrayList<>();

    @CreationTimestamp
    @Column
    private java.sql.Timestamp date;

    @ManyToOne
    private User user;
}
