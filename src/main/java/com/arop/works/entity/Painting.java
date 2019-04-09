package com.arop.works.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author bo.fan
 * @date 2019-04-09
 */

@Table(name = "painting")
@Entity
@Data
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String fileName;

    private String imgUrl;

    private LocalDateTime updateTime;
}
