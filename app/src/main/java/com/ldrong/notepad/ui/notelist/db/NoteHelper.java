package com.ldrong.notepad.ui.notelist.db;

import com.ldrong.notepad.base.AppContext;
import com.ldrong.notepad.db.Note;
import com.ldrong.notepad.db.NoteDao;

/**
 * Created by Administrator on 2016/10/24.
 */

public class NoteHelper {
    private static NoteDao noteDao = AppContext.getGreenDaoSessino().getNoteDao();

    public static void insertNote(Note note) {
        noteDao.insert(note);
    }

    public static void deleteNote(Note note) {
        noteDao.deleteByKey(note.getId());

    }

    public static void forget(Note note) {
        noteDao.update(note);
    }


}
