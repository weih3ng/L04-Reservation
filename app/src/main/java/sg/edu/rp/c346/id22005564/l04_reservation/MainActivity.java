package sg.edu.rp.c346.id22005564.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextMobile, editTextGroupSize;
    DatePicker datePicker;
    TimePicker timePicker;
    RadioGroup radioGroup;
    Button bookButton, resetButton;
    TextView textViewReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextText);
        editTextMobile = findViewById(R.id.editTextText3);
        editTextGroupSize = findViewById(R.id.editTextText4);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        radioGroup = findViewById(R.id.RadioGroup);
        bookButton = findViewById(R.id.bookingBtn);
        resetButton = findViewById(R.id.buttonRst);
        textViewReservation = findViewById(R.id.textView6);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JUNE, 1);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);
        timePicker.setHour(19);
        timePicker.setMinute(30);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String mobile = editTextMobile.getText().toString();
                String groupSize = editTextGroupSize.getText().toString();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String areaSelection = selectedRadioButton.getText().toString();

                String reservationInfo = "Name: " + name + "\n" +
                        "Mobile No.: " + mobile + "\n" +
                        "Group Size: " + groupSize + "\n" +
                        "Booking Date: " + day + "/" + month + "/" + year + "\n" +
                        "Booking Time: " + String.format(Locale.ENGLISH, "%02d:%02d", hour, minute) + "\n" +
                        "Area Selection: " + areaSelection;

                textViewReservation.setText(reservationInfo);
                Toast.makeText(MainActivity.this, "Reservation Confirmed", Toast.LENGTH_SHORT).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setText("");
                editTextMobile.setText("");
                editTextGroupSize.setText("");

                Calendar calendar = Calendar.getInstance();
                calendar.set(2020, Calendar.JUNE, 1);
                datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                timePicker.setHour(19);
                timePicker.setMinute(30);
                radioGroup.clearCheck();
                textViewReservation.setText("Options has been reset.");
            }
        });
    }
}
