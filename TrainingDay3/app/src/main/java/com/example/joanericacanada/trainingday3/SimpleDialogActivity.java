package com.example.joanericacanada.trainingday3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by joanericacanada on 10/21/15.
 */
public class SimpleDialogActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_dialog_layout);

        Button btnClickMe = (Button)findViewById(R.id.button);
        btnClickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle(R.string.me)
                .setMessage("Dialog Trial")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showToast(){
        Toast.makeText(this, "Ok button clicked", Toast.LENGTH_SHORT).show();
    }
}
