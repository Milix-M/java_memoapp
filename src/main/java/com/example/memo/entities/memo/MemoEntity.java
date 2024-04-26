package com.example.memo.entities.memo;

import com.example.memo.entities.common.CommonEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "memo")
@Getter
@Setter
public class MemoEntity extends CommonEntity{

    /* メモID */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memoId;

    /* メモタイトル */
    @Column(name = "title")
    private String memoTitle;

    /* メモ本文 */
    @Column(name = "text")
    private String memoText;
}
