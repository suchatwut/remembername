package com.example.androidx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast t = Toast.makeText(LoginActivity.this, "Hello", Toast.LENGTH_SHORT);
                t.show();
            }
        });*/

        //MyListenner Listenner = new MyListenner();

        Button LoginButton = findViewById(R.id.button);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailEditText = findViewById(R.id.editText);
                EditText passwordEditText = findViewById(R.id.editText2);
                CheckBox rememberPasswordCheckBox = findViewById(R.id.checkBox);

                if(rememberPasswordCheckBox.isChecked()){
                    Toast.makeText(LoginActivity.this, "คุณเลือกจำรหสผ่าน", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "คุณไม่ได้เลือกจำรหัสผ่าน", Toast.LENGTH_SHORT).show();
                }

                String inputEmail = emailEditText.getText().toString();
                int value;
                try{
                    value = Integer.parseInt(inputEmail);
                }catch (Exception e){
                    value = -1;
                }

                String inputPassword = passwordEditText.getText().toString();

                String success = getString(R.string.login_success);
                String failed = getString(R.string.login_failed);

                Auth auth = new Auth(inputEmail, inputPassword);
                //auth.setmEmail(inputEmail);
                //auth.setmPassword(inputPassword);

                boolean result = auth.check();

                if(result){
                    Toast.makeText(LoginActivity.this, success, Toast.LENGTH_SHORT).show();
                }else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage(R.string.login_failed);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
            }
        });
    }

    /*private class MyListenner implements View.OnClickListener{
        @Override
        public void onClick(View.v){

        }
    }*/

    /*implements View.OnClickListener
    @Override
    public void onClick(View v) {
        Toast t = Toast.makeText(LoginActivity.this, "Hello", Toast.LENGTH_SHORT);
        t.show();
    }*/
}