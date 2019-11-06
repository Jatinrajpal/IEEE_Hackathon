package com.jatin.vjm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b,b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            validate(e1.getText().toString(),e2.getText().toString());
            }
        });
        b11=(Button)findViewById(R.id.button11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });
    }
    private void validate(String userName,String userPassword)
    {
        if((userName.equals("341593904181"))&&(userPassword.equals("9799193203")))
        {
            startActivity(new Intent(MainActivity.this,second.class));
        }
        else
        {
            Toast.makeText(this,"INCORRECT CREDENTIALS",Toast.LENGTH_SHORT).show();
        }


    }

}
