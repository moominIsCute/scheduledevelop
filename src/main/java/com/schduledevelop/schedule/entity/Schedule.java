package com.schduledevelop.schedule.entity;


import com.schduledevelop.entity.BaseEntity;
import com.schduledevelop.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String name;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Schedule(String title, String contents, String name, String password, User user) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.user = user;
    }

    public void updateScd(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
