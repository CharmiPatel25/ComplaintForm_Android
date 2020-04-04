package com.example.c0768448_ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
    Button btnDatePicker;
    EditText txtDatePicker;
    Spinner spinempStatus,spinempDesignation;
    //TextView tvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         spinempStatus = (Spinner) findViewById(R.id.spinnerempsts);
        spinempDesignation = (Spinner) findViewById(R.id.spinnerDesigntn);

       //load employee status spinner
        ArrayAdapter<CharSequence> empStatusAdapter = ArrayAdapter.createFromResource(this,
                R.array.empstatus_array, android.R.layout.simple_spinner_item);
        empStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinempStatus.setAdapter(empStatusAdapter);

        //load designation spinner
        ArrayAdapter<CharSequence> empdesigAdapter = ArrayAdapter.createFromResource(this,
                R.array.empdesignation_array, android.R.layout.simple_spinner_item);
        empdesigAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinempDesignation.setAdapter(empdesigAdapter);

         // date Picker
        txtDatePicker=(EditText) findViewById(R.id.txtDatePicker);
        txtDatePicker.setInputType(InputType.TYPE_NULL);
        txtDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txtDatePicker.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

       /* btnDatePicker=(Button)findViewById(R.id.btnOpenDate);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ txtDatePicker.getText());
            }
        });*/
    }


}
