package com.pernix.ejemplotoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EjemploToastActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button;
        button = (Button) findViewById(R.id.text_only_button);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //textOnlyToast(getString(R.string.text_only_msg), Toast.LENGTH_SHORT);
            	textOnlyToast(getString(R.string.text_only_msg), R.string.toast_short);
            }
        });
        
        button = (Button) findViewById(R.id.icon_only_button);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                iconOnlyToast(android.R.drawable.ic_menu_info_details, Toast.LENGTH_SHORT);
            }
        });
        
        button = (Button) findViewById(R.id.text_icon_button);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
//                textIconToast(getString(R.string.text_icon_msg), 
//                        android.R.drawable.ic_menu_info_details, Toast.LENGTH_SHORT);
                textIconToast(R.layout.text_icon_toast, Toast.LENGTH_SHORT);
            }
        });
    }
    
    private void textOnlyToast(String message, int duration) {
        Toast toast = Toast.makeText(getApplicationContext(), message, duration);
        toast.show();
    }
    
    private void iconOnlyToast(int icon, int duration) {
        Toast toast = new Toast(getApplicationContext());
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(icon);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }
    
    private void textIconToast(String message, int icon, int duration) {
        Toast toast = Toast.makeText(getApplicationContext(), message, duration);
        View textView = toast.getView();
        LinearLayout lay = new LinearLayout(getApplicationContext());
        lay.setOrientation(LinearLayout.HORIZONTAL);
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(icon);
        lay.addView(view);
        lay.addView(textView);
        toast.setView(lay);
        toast.show();
    }
    
    private void textIconToast(int layout, int duration) {
        LayoutInflater inflater = getLayoutInflater();
        View layoutView = inflater.inflate(layout, null);        
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(duration);
        toast.setView(layoutView);
        toast.show();
    }
}