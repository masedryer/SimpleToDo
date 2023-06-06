package sg.edu.rp.c346.id22020860.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvList;

    Button btnClear;

    Button btnDelete;
    ArrayList<String> alList;

    ArrayAdapter<String> aaColours;

    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("ArrayList");

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvList = findViewById(R.id.listView);
        spin = findViewById(R.id.spinner2);
        btnClear = findViewById(R.id.buttonClearItem);
        btnDelete = findViewById(R.id.buttonDeleteItem);
        alList= new ArrayList<String>();



        aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alList);

        lvList.setAdapter(aaColours);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String list = etElement.getText().toString();
                alList.add(list);
                aaColours.notifyDataSetChanged();
                etElement.setHint("Type in a new task here");

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aaColours.clear();
                etElement.setHint("Clear all the task");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etElement.setHint("Type in the index of the task to be removed");


//          alColours.add
                if (alList.isEmpty()){
                    Toast.makeText(getApplicationContext(),"You don't have any task to remove",Toast.LENGTH_SHORT).show();

                }
                else {
                    int pos = Integer.parseInt(etElement.getText().toString());


                    if(pos < 0 || pos >= alList.size()) {
                        Toast.makeText(getApplicationContext(),"Wrong Index Number",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        alList.remove(pos);
                        aaColours.notifyDataSetChanged();
                    }
                }







                //if (list == alList)
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);

                        break;
                    case 1:
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









    }
}