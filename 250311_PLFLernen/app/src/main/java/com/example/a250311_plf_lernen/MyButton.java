package com.example.a250311_plf_lernen;

import android.content.Context;
import android.widget.Button;

public class MyButton extends Button {

    private int code = 0;

    public MyButton(Context context) {
        super(context);
    }

    public void setCode(int i){
        this.code = i + 1;
    }
    public int getCode(){
        return code;
    }
}
