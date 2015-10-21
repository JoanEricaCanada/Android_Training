package com.example.joanericacanada.trainingday3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by joanericacanada on 10/21/15.
 */
public class CheckListDialogActivity extends Activity implements View.OnClickListener{

    private final String[] color = {"Red", "Blue", "Green"};
    private boolean[] selected = {false, false, false};

    private ArrayList<String> isSelected = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_dialog_layout);

        Button btnAdd = (Button)findViewById(R.id.button3);
        btnAdd.setOnClickListener(this);
        
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, isSelected);
    }

    @Override
    public void onClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.me)
            .setMultiChoiceItems(color, selected, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked)
                        isSelected.add(color[which]);
                    else if (isSelected.contains(color[which]))
                        isSelected.remove(color[which]);
                }
            })
            .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    adapter.notifyDataSetChanged();
                }
            });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
