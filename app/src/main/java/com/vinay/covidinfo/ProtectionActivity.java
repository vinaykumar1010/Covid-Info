package com.vinay.covidinfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ProtectionActivity extends AppCompatActivity {
    private EditText textPincode;
    private EditText textDate;
    private int varPincode;
    private  String varDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);
    //    textPincode = findViewById(R.id.editTextPincode);
    //    textDate = findViewById(R.id.editTextDate);

        textPincode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // view type v object
                //  android.text.Editable   this is return type
                // imported this  android.text.Editable
                Editable abc = textPincode.getText();
                String stringpincode = abc.toString();
                varPincode = Integer.parseInt(stringpincode);
                Log.d("pincode", "stringpincode :" + stringpincode);

                // integer is a class in a java library, which contain static function (parseInt)
            }
        });

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable  xyz= textDate.getText();
                varDate = xyz.toString();
                Log.d("pincode","date is obtained varDate:" + varDate);

            }
        });
    }
}