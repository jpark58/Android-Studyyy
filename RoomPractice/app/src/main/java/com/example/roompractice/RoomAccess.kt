package com.example.roompractice

import android.content.Context
import androidx.room.Room

class RoomAccess(context: Context) {

    val db = Room.databaseBuilder(context,
        AppDatabase::class.java, "db").build()

    fun insertAll(user: User){
        val insertThread = Thread(Runnable{
            db.userDao().insertAll(user)
        })

        insertThread.start()
    }

    fun getById(id: Int): List<User>{
        var userInfo = listOf<User>()
        val getThread = Thread(Runnable{
            userInfo = db.userDao().loadAllByIds(id)
        })

        getThread.start()
        getThread.join()
        return userInfo
    }

}