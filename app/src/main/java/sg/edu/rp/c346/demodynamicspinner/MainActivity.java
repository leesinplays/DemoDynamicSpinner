package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        // Initiate the ArrayList
        alNumbers = new ArrayList<>();
        /*alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");*/

        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        // Get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        // Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        // Implement the button onClick() method
        // to load the correct list when it is clicked
        /*btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                // Apply either of the two approaches
                // to load the correct number list based on the selection of spn1
                if (pos == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(0);
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(0);
                }

                aaNumbers.notifyDataSetChanged();
            }
        }); */

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Your code for item 1 selected
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(2);
                        aaNumbers.notifyDataSetChanged();
                        break;
                    case 1:
                        // Your code for item 1 selected
                        String[] strNumber = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumber));
                        spn2.setSelection(1);
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
