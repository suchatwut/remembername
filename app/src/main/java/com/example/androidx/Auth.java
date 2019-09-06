package com.example.androidx;

import android.widget.Toast;

public class Auth {
    private static final String EMAIL = "suchatwut.np@gmail.com";
    private static final String PASSWORD = "1234";

    private String mEmail;
    private String mPassword;

    public Auth(String Email, String Password) {
        this.mEmail = Email;
        this.mPassword = Password;
    }

    public String getmEmail(){
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public boolean check() {
        if(getmEmail().equals(EMAIL) && getmPassword().equals(PASSWORD)){
            return true;
        }else{
            return false;
        }
    }
}
