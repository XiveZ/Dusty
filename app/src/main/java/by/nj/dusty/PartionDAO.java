package by.nj.dusty;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PartionDAO {
    @Query("SELECT * FROM Partion")
    List<Partion> getAll();


    @Query("SELECT * FROM PARTION WHERE _id IN (:userIds)")
    List<Partion> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Partion WHERE Number LIKE :first AND " +
            "Type LIKE :last LIMIT 1")
    Partion findByName(String first, String last);

    @Insert
    void insertAll(Partion... partions);

    @Delete
    void delete(Partion partion);

}
