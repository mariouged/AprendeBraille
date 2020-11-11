/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact: <mario.ugedo@gmail.com>
 */
package com.comoelagua.android.braille;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public final static String WORD_TYPE = "com.comoelagua.android.braille.WORD_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkSdk();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAlphabet) {
            startActivity(new Intent(this, AlphabetActivity.class));
            return true;
        } else if (item.getItemId() == R.id.actionSettings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (item.getItemId() == R.id.actionHelp) {
            startActivity(new Intent(this, HelpActivity.class));
            return true;
        } else if (item.getItemId() == R.id.fontTest) {
            startActivity(new Intent(this, FontTestActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openAlphabetActivity(View view) {
        startActivity(new Intent(this, AlphabetActivity.class));
    }

    public void openCharactersExercises(View view) {
        startActivity(new Intent(this, CharactersExercisesActivity.class));
    }

    public  void openWordExercises(View view) {
        startActivity(new Intent(this, WordExercisesActivity.class));
    }

    public void openNumbersExercises(View view) {
        startActivity(new Intent(this, NumbersExercisesActivity.class));
    }

    public void openPhraseExercises(View view) {
        startActivity(new Intent(this, PhraseExercisesActivity.class));
    }

    public boolean checkSdk() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.sdk_dialog_message).setTitle(R.string.sdk_dialog_title);
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
        return true;
    }

    public void openBrailleCheatSheetAppOnGooglePlay(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.comoelagua.android.braille")));
        } catch (android.content.ActivityNotFoundException exception) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "com.comoelagua.android.braille")));
        }
    }
}
