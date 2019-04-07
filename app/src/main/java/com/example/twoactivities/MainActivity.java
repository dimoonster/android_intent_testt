package com.example.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = (EditText)findViewById(R.id.editText_main);
        mReplyTextView = (TextView)findViewById(R.id.text_message_reply);
        mReplyHeadTextView = (TextView)findViewById(R.id.text_header_reply);
    }

    public void launchSecondActivity(View view) {
        String message = mMessageEditText.getText().toString();

        Log.d(LOG_TAG, "Btn Clicked. Message: "+message);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

        mReplyHeadTextView.setVisibility(View.VISIBLE);
        mReplyTextView.setVisibility(View.VISIBLE);

        mReplyTextView.setText(reply);
    }
}
