package com.jnu.jcircle.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jnu.jcircle.R;

public class eula extends AppCompatActivity {

    private ImageView eula_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);

        eula_return = findViewById(R.id.eula_return);

        eula_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eula.this.finish();
            }
        });

    }
}