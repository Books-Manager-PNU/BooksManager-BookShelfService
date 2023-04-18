package com.example.booksManager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bookshelf_category_book", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "bookshelf_book_id", "bookshelf_category_id" })
})
public class BookShelfCategoryBook {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "bookshelf_book_id", nullable = false)
    private BookShelfBook bookshelfBookId;

    @ManyToOne
    @JoinColumn(name = "bookshelf_category_id", nullable = false)
    private BookShelfCategory bookShelfCategoryId;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @PrePersist
    public void createEntity() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void updateEntity() {
        updateDate = LocalDateTime.now();
    }
}
