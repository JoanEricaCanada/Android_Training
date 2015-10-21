package com.example.joanericacanada.trainingday3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by joanericacanada on 10/21/15.
 */
public class NameActivity extends Activity implements View.OnClickListener {

    private EditText edtTxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

        edtTxtName = (EditText)findViewById(R.id.etName);
        Button btnOk = (Button)findViewById(R.id.btnOK);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent = new Intent();
        intent.putExtra("name", edtTxtName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
