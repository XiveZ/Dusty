package by.nj.dusty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class DataBaseActivity extends AppCompatActivity {
private AppDataBase db;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_base_layout);
        db =  Room.databaseBuilder(getApplicationContext(), AppDataBase.class,"database-name").build();

    }
}
