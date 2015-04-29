package kreu.morpion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ModesDeJeu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes_de_jeu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modes_de_jeu, menu);
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
     *
     * @param view
     * lance une nouvelle activité au click
     */
    public void onePlayer(View view) {
        Intent intent = new Intent(ModesDeJeu.this, OnePlayer.class);
        startActivity(intent);
    }

    /**
     *
     * @param view
     * lance une nouvelle activité au click
     */
    public void twoPlayers(View view) {
        Intent intent = new Intent(ModesDeJeu.this, TwoPlayers.class);
        startActivity(intent);
    }
}
