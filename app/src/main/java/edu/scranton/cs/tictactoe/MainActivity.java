package edu.scranton.cs.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateGameboard();
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

    private void updateGameboard (){
        char[][] gameboard = new char[Constant.ACTUAL_SIZE][Constant.ACTUAL_SIZE];

        for (int i = 0; i < Constant.ACTUAL_SIZE; i++){
            gameboard[i][0] = Constant.EMBED_SYM;
            gameboard[0][i] = Constant.EMBED_SYM;
            gameboard[Constant.ACTUAL_SIZE-1][i] = Constant.EMBED_SYM;
            gameboard[i][Constant.ACTUAL_SIZE-1] = Constant.EMBED_SYM;
        }

        for (int i = 1; i <= Constant.LOGICAL_SIZE; i++){
            for (int j = 1; j <= Constant.LOGICAL_SIZE; j++){
                gameboard[i][j] = Constant.EMPTY_SYM;
            }
        }
        gameboard[1][1] = 'X';
        gameboard[2][2] = 'O';
        gameboard[3][3] = 'X';
        gameboard[3][1] = 'O';

        for (int i = 1; i <= Constant.LOGICAL_SIZE; i++){
            for (int j = 1; j <= Constant.LOGICAL_SIZE; j++){
                if (gameboard[i][j] != Constant.EMPTY_SYM){
                    int resId = getResources().getIdentifier("piece" + (i-1) + (j-1), "id", getPackageName());
                    TextView tvPiece = (TextView) findViewById(resId);
                    tvPiece.setBackgroundResource(getPieceId(gameboard[i][j]));
                }
            }
        }
    }

    private int getPieceId (char symbol){
        switch(symbol){
            case 'X':
                return R.drawable.x_80;
            case 'O':
                return R.drawable.o_80;
            default:
                return -1;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, Preferences.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
