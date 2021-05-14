package sg.edu.rp.c346.id20007649.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mobile;
    EditText group;
    RadioGroup location;
    DatePicker dp;
    TimePicker tp;
    CheckBox confirmed;
    Button btnReset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.etName);
        mobile = findViewById(R.id.etMobile);
        group = findViewById(R.id.etGroup);
        location = findViewById(R.id.rbplace);
        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        confirmed = findViewById(R.id.cbConfirm);
        btnReset = findViewById(R.id.btnReset);





        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int strRadio = location.getCheckedRadioButtonId();



                if(name != null && mobile.getText().toString().trim().length() != 0 && group.getText().toString().trim().length() != 0 && strRadio == R.id.rbSmoking && confirmed.isChecked()){

                    String phone = mobile.getText().toString();
                    int number = Integer.parseInt(phone);
                    String people = group.getText().toString();
                    int peoples = Integer.parseInt(people);
                    int day = dp.getDayOfMonth();
                    int month = dp.getMonth() + 1 ;
                    int year = dp.getYear();

                    String message = " ";
                    message += "Name : " + name;
                    message += "Mobile number : " + mobile;
                    message += "Group Size : " + group;
                    message += "Seating Area : Smoking ";
                    message += "Date : " + day + "/" + month + "/" + year;
                    message += "Time : " + tp.getCurrentHour() + tp.getCurrentMinute();

                    Toast.makeText(MainActivity.this, message , Toast.LENGTH_LONG).show();




                }

                else{

                    String phone = mobile.getText().toString();
                    int number = Integer.parseInt(phone);
                    String people = group.getText().toString();
                    int peoples = Integer.parseInt(people);
                    int day = dp.getDayOfMonth();
                    int month = dp.getMonth() + 1 ;
                    int year = dp.getYear();


                    String message = " ";
                    message += "Name : " + name;
                    message += "Mobile number : " + mobile;
                    message += "Group Size : " + group;
                    message += "Seating Area : Non-Smoking ";
                    message += "Date : " + day + "/" + month + "/" + year;
                    message += "Time : " + tp.getCurrentHour() + tp.getCurrentMinute();

                    Toast.makeText(MainActivity.this, message , Toast.LENGTH_LONG).show();



                }

            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int month = dp.getMonth() + 1 ;


                tp.setCurrentHour(12);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,6,1);



            }
        });








    }
}