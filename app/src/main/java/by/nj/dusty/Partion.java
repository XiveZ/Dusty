package by.nj.dusty;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Partion {
    @PrimaryKey
    private int _id;

    @ColumnInfo(name = "Type")
    private String TypePartion;

    @ColumnInfo (name = "Number")
    private int NumberPartion;

    @ColumnInfo(name = "Description")
    private String Description;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTypePartion() {
        return TypePartion;
    }

    public void setTypePartion(String typePartion) {
        TypePartion = typePartion;
    }

    public int getNumberPartion() {
        return NumberPartion;
    }

    public void setNumberPartion(int numberPartion) {
        NumberPartion = numberPartion;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
