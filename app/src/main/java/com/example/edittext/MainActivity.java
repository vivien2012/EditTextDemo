package com.example.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.main_input_phone)
    EditText phoneEt;
    @Bind(R.id.main_input_pass)
    EditText passEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        InputFilter[] passfilters = {new EditPassFilter()};
        passEt.setFilters(passfilters);

        InputFilter[] phonefilters = {new EditPhoneFilter()};
        phoneEt.setFilters(phonefilters);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
