package by.nj.dusty;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Partion.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PartionDAO partionDAO();
}
