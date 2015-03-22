package com.manolovindustries.netsechelloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> sAdapter;
    Button button;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (TextView)findViewById(R.id.textView);

        // Get logical list, adapter, and set to UI spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        sAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_values,
                android.R.layout.simple_spinner_item
        );

        spinner.setAdapter(sAdapter);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeDisplayText();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Changes the UI text to display a message.
     */
    public void changeDisplayText() {

        message.setText(spinner.getSelectedItem().toString());
        sAdapter.notifyDataSetChanged();
    }
}
