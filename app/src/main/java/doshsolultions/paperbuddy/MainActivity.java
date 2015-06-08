package doshsolultions.paperbuddy;

/**
 * Created by Dosh for ITC303 project.
 */

import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        setContentView(R.layout.activity_main);

        ArrayList<Customer> runlist = loadArrayData(this);

        final ListView lv1 = (ListView) findViewById(R.id.ListView01);
        lv1.setAdapter(new RunSheetCreator(this, -1, runlist));


    }

    private ArrayList<Customer> loadArrayData(Context cont) {
        ArrayList<Customer> customerList = new ArrayList<>();

        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard,"runsheet.txt" );
            //InputStream is = cont.getAssets().open("runsheetcomma.txt");
            //InputStream is = cont.getResources().openRawResource(R.raw.runsheet);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] RowData = line.split(",");
                //if(RowData.length <5)
                //    continue;
                Customer current = new Customer();
                current.setAddress(RowData[0]+"--");
                current.setCourier(RowData[1]+" ");
                current.setAustralian(RowData[2]+" ");
                current.setFinreview(RowData[3]+" ");
                current.setSydneyHerald(RowData[4]+" ");

                customerList.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
 /*   RunSheetCreator itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView itemList = (ListView)findViewById(R.id.listView);

        itemAdapter = new RunSheetCreator(this, -1);

        itemList.setAdapter(itemAdapter);

    }
}*/


