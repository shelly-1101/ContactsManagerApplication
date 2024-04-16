package com.example.contactsmanagerapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Dao
public interface ContactDao {

    @Insert
    static ExecutorService insert(Contacts contact) {

        return null;
    }

    @Delete
    static void delete(Contacts contact){

    }


    @Query("SELECT * FROM CONTACTS_TABLE")
    static LiveData<List<Contacts>>  getAllContacts(){

        return getAllContacts();
    }
}
