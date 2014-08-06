package com.example.HelloWord;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yiperu on 8/6/14.
 */
public class TableActivity extends Activity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        edtUsername = (EditText)findViewById(R.id.idEdtUsername);
        edtPassword = (EditText)findViewById(R.id.idEdtPassword);
        btnSubmit = (Button)findViewById(R.id.idBtnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtPassword.getText().toString().equals("admin") &&
                        edtUsername.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Los datos son Correctos",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),"Error!!!",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
