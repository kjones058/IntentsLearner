package com.example.intentslearner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {
    private Button buttonSendMessage;
    private EditText editTextMessage;
    private Button buttonShareMessage;

    public static final String EXTRA_SENT_MESSAGE = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        WireWidgets();
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from edit text
                String message = editTextMessage.getText().toString();
                //create intenet:
                //the arguments are where you are coming from (this)
                //and where you are going (Tagetactivity.class)
                Intent intentSendmessage = new Intent(SendMessageActivity.this, RecieveMessageActivity.class);
                //package text into intent
                intentSendmessage.putExtra("themessage", message);
                //start new activity
                startActivity(intentSendmessage);
            }
        });
        buttonShareMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make intent with desried action
                Intent intentShareMessage = new Intent(Intent.ACTION_SEND);
                //set data type of the stuff we're packaging away
                //can look up that type you need on the internet
                intentShareMessage.setType("text/plain");
                //put the extra with the message
                intentShareMessage.putExtra(EXTRA_SENT_MESSAGE,editTextMessage.getText().toString());
                //launch activity
                startActivity(intentShareMessage);

            }
        });
    }

    private void WireWidgets() {
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        editTextMessage= findViewById(R.id.editText_sendmessage_send);
        buttonShareMessage = findViewById(R.id.button_sendmessage_sharemessage);
    }

}
