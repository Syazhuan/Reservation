package sg.edu.rp.c346.id22043300.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayResult;
    TextView tvDisplay;
    Button btnReset;
    TextView editName;
    TextView editMob;
    TextView editNoOfP;
    RadioGroup rb_sb_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayResult = findViewById(R.id.buttonDisplayResult);
        tvDisplay = findViewById(R.id.textViewFinal);
        btnReset = findViewById(R.id.btnReset);
        editName = findViewById(R.id.editName);
        editMob = findViewById(R.id.editMob);
        editNoOfP = findViewById(R.id.editNoOfP);
        rb_sb_area = findViewById(R.id.rb_sb_area);

        tp.setIs24HourView(true);

        btnDisplayResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                String stringResponse;
                String name = editName.getText().toString();
                String mob = editMob.getText().toString();
                String NoOfP = editNoOfP.getText().toString();


                int checkedRadioId = rb_sb_area.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.rb_s){
                    // Smoking area selected
                    stringResponse = "Smoking area selected";
                }
                else{
                    // Non-smoking area selected
                    stringResponse = "Non-smoking area selected";
                }

                String time = String.format("%02d:%02d", hour, min);
                String date = String.format("Date is %02d/%02d/%02d", dp.getDayOfMonth(), dp.getMonth()+1, dp.getYear());

                String finalInfo = String.format("Reservation Successful: \n Name: %s \n Mobile Number: %s\n No. of guest: %s \n %s \n %s @ %s", name, mob, NoOfP, stringResponse,date, time);

                Toast toast = Toast.makeText(getApplicationContext(), finalInfo, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2023, 5, 1);

                editName.setText(null);
                editMob.setText(null);
                editNoOfP.setText(null);
                tvDisplay.setText("All cleared!");
                rb_sb_area.clearCheck();
            }
        });
    }
}
