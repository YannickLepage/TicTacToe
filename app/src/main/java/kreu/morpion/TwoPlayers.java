package kreu.morpion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TwoPlayers extends ActionBarActivity {

    private Button[] buttons;
    private int player;
    private int compteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);

        buttons = new Button[]{(Button)findViewById(R.id.button_0),
                (Button)findViewById(R.id.button_1),
                (Button)findViewById(R.id.button_2),
                (Button)findViewById(R.id.button_3),
                (Button)findViewById(R.id.button_4),
                (Button)findViewById(R.id.button_5),
                (Button)findViewById(R.id.button_6),
                (Button)findViewById(R.id.button_7),
                (Button)findViewById(R.id.button_8)
        };

        compteur = 1;
        Utils.enable(buttons);
        ((TextView)findViewById(R.id.text_view_current_player)).setText("Joueur 1, à vous");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_players, menu);
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
     * au clique sur rejouer lance une nouvelle fois l'activité
     */
    public void newGame(View view) {
        Intent intent = new Intent(TwoPlayers.this,TwoPlayers.class);
        startActivity(intent);
    }

    /**
     * détruit l'activité pour éviter de créer un pile importante lorsqu'on utilise rejouer.
     */
    public void onStop(){
        super.onStop();
        finish();
    }

    /**
     * @param view
     * au click, coche la case cliquée en fonction du joueur,
     * vérifie s'il y a un gagnant ou match nul indique que
     * c'est le tour du joueur suivant le  cas échéant
     */
    public void check(View view) {
        player = Utils.getPlayer(compteur);
        Utils.check(view, player, buttons);
        if(Utils.won(buttons)){
            Utils.endGame(buttons, player, ((TextView) findViewById(R.id.text_view_who_wins)), ((Button) findViewById(R.id.button_new_game)), false);
            ((TextView)findViewById(R.id.text_view_current_player)).setText("");
        }else{
            if (Utils.even(buttons)){
                Utils.tieGame(((TextView)findViewById(R.id.text_view_who_wins)),((Button)findViewById(R.id.button_new_game)));
                ((TextView)findViewById(R.id.text_view_current_player)).setText("");
            }else{
                compteur++;
                player = Utils.getPlayer(compteur);
                if(player == 1){
                    ((TextView)findViewById(R.id.text_view_current_player)).setText("Joueur 1, à vous !");
                }else{
                    ((TextView)findViewById(R.id.text_view_current_player)).setText("Joueur 2, à vous !");

                }
            }
        }
    }
}
