package com.example.memo.responce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Memo {

    private String id;

    private String title;

    private String text;

    private String created_at;

    private String updated_at;
}
