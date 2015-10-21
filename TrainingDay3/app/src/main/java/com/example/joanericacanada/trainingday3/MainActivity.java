package com.example.joanericacanada.trainingday3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView txtVwName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwName = (TextView)findViewById(R.id.tvName);
        Button btnName= (Button)findViewById(R.id.btnName);
        btnName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, NameActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null)
            return;

        String name = data.getStringExtra("name");
        txtVwName.setText("Your name is " + name);
    }
}
