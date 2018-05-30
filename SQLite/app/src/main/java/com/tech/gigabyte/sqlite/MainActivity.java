package com.tech.gigabyte.sqlite;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[]  empFirstName, empLastName, empSex, empAge;
    TextView textView;
    Employee employee;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data
        empFirstName = new String[]{"Ashutosh", "Antrikch", "Preetika", "Rozina", "Vrushali"};
        empLastName = new String[]{"Dubey","Nair","Kaur","Darediya","Bhoite"};
        empAge = new String[]{"22","28","25","24","24"};
        empSex = new String[]{"Male","Male","Female","Female","Female"};

        textView = (TextView) findViewById(R.id.tv_report);
        Log.d("Insert: ", "Inserting ..");
        // Saving to Database...
        dbHelper = new DBHelper(this);
        if(dbHelper.numberOfRows()>0){
            Log.e("MA ","Database already exist.");
        }
        else{
            saveDataInDB();
            Log.e("MA ","Data Saved in Database.");

        }

        //blob to image conversion
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loadDataFromDB()) {
                    Log.e("MA ","Data Loaded from Database.");
                }
            }
        }, 0);

    }

    //Save Data
    Boolean saveDataInDB() {
        employee = new Employee();
        for (int i=0;i<empFirstName.length;i++){
            employee.setEmployeeFirstName(empFirstName[i]);
            employee.setEmployeeLasttName(empLastName[i]);
            employee.setEmployeeAge(empAge[i]);
            employee.setEmployeeSex(empSex[i]);

            Log.d("Insert: ", "Inserting ..");
            dbHelper.insertEmployee(employee);
        }

        return true;

    }

    //Load Data
    Boolean loadDataFromDB() {
        try {
            ArrayList array_list = dbHelper.getAllEmployee();
            Log.e("Employee Size ", String.valueOf(array_list.size()));

            if(!array_list.isEmpty()){

                StringBuilder stringBuilderFull,stringBuilderEmployee;
                stringBuilderFull = new StringBuilder();


                for (int i=0;i<array_list.size();i++){
                    Employee employee1 = (Employee) array_list.get(i);
                    stringBuilderEmployee=  new StringBuilder().append("Emp Id : ").append(employee1.getId()).append(", ")
                            .append("First Name: ").append(employee1.getEmployeeFirstName()).append(", ")
                            .append("Last Name: ").append(employee1.getEmployeeLasttName()).append(", ")
                            .append("Age: ").append(employee1.getEmployeeAge()).append(", ")
                            .append("Sex: ").append(employee1.getEmployeeSex()).append(".")
                            .append("\n").append("\n");
                    stringBuilderFull.append(stringBuilderEmployee);
                }

                textView.setText(stringBuilderFull);
                Log.e("MA ", "Full details displayed.");
            }else {
                Log.e("MA ", "No Employee available.");
            }

            return true;
        } catch (Exception e) {
            Log.e("MA ", "<loadImageFromDB> Error : " + e.getLocalizedMessage());

            return false;
        }
    }


}
