package com.example.memo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.memo.entities.memo.MemoEntity;
import com.example.memo.repository.MemoRepository;
import com.example.memo.responce.Memo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public Memo getMemobyId(String id) {
        MemoEntity entity = memoRepository.findById(Integer.parseInt(id)).get();
        Memo memo = new Memo();
        copyEntityToBean(entity, memo);
        return memo;
    }

    public List<Memo> getMemoList() {
        List<Memo> memos = new ArrayList<>();
        List<MemoEntity> memoEntitiesList = memoRepository.findAll();
        memoEntitiesList.forEach(entity -> {
            Memo memo = new Memo();
            copyEntityToBean(entity, memo);
            memos.add(memo);
        });
        return memos;
    }

    public Memo createMemo(Memo memo) {
        MemoEntity entity = new MemoEntity();
        copyBeanToEntityForInsert(memo, entity);
        MemoEntity createdEntity = memoRepository.save(entity);
        Memo newMemo = new Memo();
        copyEntityToBean(createdEntity, newMemo);
        return newMemo;
    }

    private void copyEntityToBean(MemoEntity entity, Memo memo) {
        memo.setId(String.valueOf(entity.getMemoId()));
        memo.setTitle(entity.getMemoTitle());
        memo.setText(entity.getMemoText());

        memo.setCreated_at(String.valueOf(entity.getCreatedAt()));
        memo.setUpdated_at(String.valueOf(entity.getUpdatedAt()));
    }

    private void copyBeanToEntityForInsert(Memo memo, MemoEntity entity) {
        if (!"".equals(memo.getTitle())) {
            entity.setMemoTitle(memo.getTitle());
        }
        if (!"".equals(memo.getText())) {
            entity.setMemoText(memo.getText());
        }
    }

}
