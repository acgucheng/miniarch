package me.brimon.cloud.miniarch.entity;

import com.mysql.cj.protocol.ColumnDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    private Integer id;
    private Integer listingId;
    private String date;
    private Integer reviewerId;
    private String reviewerName;
    @Column(columnDefinition = "TEXT")
    private String comments;
}
