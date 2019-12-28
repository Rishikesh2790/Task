package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

public class SecondActivity extends AppCompatActivity {

    Spinner spinner;
    String[] type;
    LinearLayout linearLayout;
    TextView startTimer1,startTimer2,startTimer3,startTimer4;
    CheckBox checkBox;
    Chip chipsun,chipmon,chiptue,chipwed,chipthu,chipfri,chipsat;
    ChipGroup chipGroup1;

    RecyclerView recyclerView1;

    TextInputEditText passcodeName,passcodeCode,passcodeCodeReEnter;

    Button saveButton;

    String title,timer2,timer4;
    ArrayList<String> days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner = findViewById(R.id.passcodeType);

        linearLayout = findViewById(R.id.linearlayoutDialog);

        saveButton = findViewById(R.id.saveButton);

        days = new ArrayList<>();

        passcodeName = findViewById(R.id.passcodeName1);
        passcodeCode = findViewById(R.id.passcodeCode1);
        passcodeCodeReEnter = findViewById(R.id.passcodeCodeReEnter1);

        type = new String[]{"Permanant", "Time Bound"};
        spinner.setPrompt("TYPE");

        startTimer1 = findViewById(R.id.startTimer1);
        startTimer2 = findViewById(R.id.startTimer2);
        startTimer3 = findViewById(R.id.startTimer3);
        startTimer4 = findViewById(R.id.startTimer4);

        checkBox = findViewById(R.id.everyday);

        chipsun = findViewById(R.id.sun);
        chipmon = findViewById(R.id.mon);
        chiptue = findViewById(R.id.tue);
        chipwed = findViewById(R.id.wed);
        chipthu = findViewById(R.id.thu);
        chipfri = findViewById(R.id.fri);
        chipsat = findViewById(R.id.sat);

        chipGroup1 = findViewById(R.id.chipGroup);

        chipsun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chipsun.getText().toString());
                }
            }
        });
        chipmon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chipmon.getText().toString());
                }
            }
        });
        chiptue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chiptue.getText().toString());
                }
            }
        });
        chipwed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chipwed.getText().toString());
                }
            }
        });
        chipthu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chipthu.getText().toString());
                }
            }
        });
        chipfri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chipfri.getText().toString());
                }
            }
        });
        chipsat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    days.add(chipsat.getText().toString());
                }
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,type);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner.setSelection(position);
                title = parent.getItemAtPosition(position).toString();
                if (title.equals(type[0])){

                    linearLayout.setVisibility(View.GONE);

                }
                else if (title.equals(type[1]))
                {
                     linearLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        startTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(SecondActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        startTimer2.setText( selectedHour + ":" + selectedMinute);
                        timer2 = startTimer4.getText().toString().trim();
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        startTimer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(SecondActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        startTimer4.setText( selectedHour + ":" + selectedMinute);
                        timer4 = startTimer4.getText().toString().trim();
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (title.equals(type[1]) && timer2==null && timer4==null)
                {

                     timer2 = "09:30";

                     timer4 = "11:00";
                }
                else if(title.equals(type[1])) {

                    timer2 = startTimer2.getText().toString();
                    timer4 = startTimer4.getText().toString();
                }

                String code = passcodeCode.getText().toString().trim();
                String name = passcodeName.getText().toString().trim();

                OpenHelperMethod openHelperMethod = new OpenHelperMethod(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = openHelperMethod.getWritableDatabase();

                openHelperMethod.insertData(name,code,title,timer2,timer4,days,sqLiteDatabase);
                openHelperMethod.listContacts();
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
