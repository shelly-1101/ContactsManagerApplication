package com.example.contactsmanagerapplication;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private final ContactDao contactDao;
    ExecutorService executorService;
    Handler handler;
    public Repository(Application application)
    {

        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(application);
        this.contactDao = ContactsDatabase.getInstance(contactDao);

        executorService  = Executors.newSingleThreadExecutor();

        handler = new Handler(Looper.getMainLooper());
    }
    public void addContact(Contacts contact) {


        executorService.execute(new Runnable() {
            @Override
            public void run() {

                ContactDao.insert(contact);
            }
        });


    }
    public void delectContact(Contacts contact)

    {
        executorService.execute(new Runnable() {
            @Override
            public void run()
            {
                ContactDao.delete(contact);
            }
        });


    }

    public LiveData<List<Contacts>> getAllContacts(Contacts contact){
        return  ContactDao.getAllContacts();
    }
}
