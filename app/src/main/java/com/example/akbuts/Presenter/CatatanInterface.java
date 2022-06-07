package com.example.akbuts.Presenter;

import android.database.Cursor;

import com.example.akbuts.Model.Catatan;
/**
 Rezha Satria SP
 10119281
 IF7
 **/
public interface CatatanInterface {
    public Cursor read();
    public boolean save(Catatan catatan);
    public boolean update(Catatan catatan);
    public boolean delete(String id_catatan);

}
