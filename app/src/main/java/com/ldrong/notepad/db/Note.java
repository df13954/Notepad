package com.ldrong.notepad.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/10/24.
 */
@Entity
public class Note {
    @Id(autoincrement = true)
    private Long id;

    private String title;

    private String content;

    private boolean isCompComplete;

    private String time;

    @Generated(hash = 1866917722)
    public Note(Long id, String title, String content, boolean isCompComplete,
            String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isCompComplete = isCompComplete;
        this.time = time;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsCompComplete() {
        return this.isCompComplete;
    }

    public void setIsCompComplete(boolean isCompComplete) {
        this.isCompComplete = isCompComplete;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
