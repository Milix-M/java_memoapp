package com.example.memo.entities.common;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class CommonEntity {

    /** データ作成日時 */
    @Column(name = "crated_at")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt;

    /** データ更新日時 */
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date UpdatedAt;

    /**
     * データ登録時に自動的に実行されるメソッド
     */
    @PrePersist
    public void preInsert() {
        Date date = new Date();
        setCreatedAt(date);
        setUpdatedAt(date);
    }

    /**
     * データ更新時に自動的に実行されるメソッド
     */
    @PreUpdate
    public void preUpdate() {
        setUpdatedAt(new Date());
    }

}
