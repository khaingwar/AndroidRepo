package ndmm.com.datetimepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity {
    TextView lblDateAndTime;
    Button btnDate;

    Calendar myCalendar = Calendar.getInstance();
    TimePicker time1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDate = (Button) findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dateDialog = new DatePickerDialog(MainActivity.this,datePicker,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                dateDialog.show();
            }
        });

        lblDateAndTime = (TextView) findViewById(R.id.lblDateAndTime);

        time1 = (TimePicker)findViewById(R.id.timePicker1);
        time1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
            String newTime = "Time\n"+ hourOfDay+":"+ minute;
                lblDateAndTime.setText(newTime);
            }
        });

    }

    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener(){
        public  void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            Date date = myCalendar.getTime();
            String strDate = DateFormat.getDateInstance().format(date);
            String strDateTime = DateFormat.getDateInstance().format(date);
            lblDateAndTime.setText(strDate+"\n"+strDateTime);

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
