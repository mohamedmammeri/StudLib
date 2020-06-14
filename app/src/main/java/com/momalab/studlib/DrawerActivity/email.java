package com.momalab.studlib.DrawerActivity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.momalab.studlib.R;

public class email extends AppCompatActivity {
    EditText sujet,text;
    String sujetS,textS;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        sujet=findViewById(R.id.sujet);
        text=findViewById(R.id.text);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               envoyer();
            }
        });

    }
    private void envoyer(){
        sujetS=sujet.getText().toString();
        textS=text.getText().toString();
        String to ="mohamedmammeri96@gmail.com";
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL  , to);
        i.putExtra(Intent.EXTRA_SUBJECT, sujetS);
        i.putExtra(Intent.EXTRA_TEXT   , textS);
        i.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(i, "choose an email client"));
            Toast.makeText(email.this,"Merci :)",Toast.LENGTH_SHORT).show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(email.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
