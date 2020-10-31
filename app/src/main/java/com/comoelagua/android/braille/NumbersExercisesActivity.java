package com.comoelagua.android.braille;

import com.comoelagua.android.braille.model.beans.ResultExercise;
import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;
import com.comoelagua.android.braille.module.exercises.ExercisesActivity;

public class NumbersExercisesActivity extends ExercisesActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_numbers_exercises;
    }

    @Override
    public void setWordType() {
        wordLabel.setText(R.string.number);
        resultExercise.setWordType(ResultExercise.NUMBER_TYPE);
    }

    @Override
    public void loadWordsList() {
        WordsDaoInterface numbersDao = ((BrailleApplication) getApplicationContext()).getWordsDao(DaosContainer.NUMBERS_DAO_TYPE);
        wordsList = numbersDao.readRandom(maxSize);
    }

}
