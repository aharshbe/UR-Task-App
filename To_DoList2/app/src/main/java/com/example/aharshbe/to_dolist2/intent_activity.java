package com.example.aharshbe.to_dolist2;

import android.content.Intent;

/**
 * Created by aharshbe on 4/14/16.
 */


public class intent_activity {
    Intent intent = getIntent();
    int importedData = intent.getIntExtra("Hello", 0);





    public Intent getIntent() {
        return intent;
    }
}
