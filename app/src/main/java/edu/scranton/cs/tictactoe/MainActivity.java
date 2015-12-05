package edu.scranton.cs.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void pieceClicked (View v){
        // check status
        String rowStr = v.getResources().getResourceName(v.getId()).split("/")[1];
        int row = rowStr.charAt(5) - '0';
        String colStr = v.getResources().getResourceName(v.getId()).split("/")[1];
        int col = colStr.charAt(6) - '0';
        Coordinates c = new Coordinates(row, col);
        String toastStr = "Row: " + row + " | Col: " + col;
        Toast.makeText(MainActivity.this, toastStr, Toast.LENGTH_SHORT).show();
        // change picture to match symbol
    }

    public void connect (View v){
        Toast.makeText(MainActivity.this, "CONNECT BUTTON PRESSED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, Preferences.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
