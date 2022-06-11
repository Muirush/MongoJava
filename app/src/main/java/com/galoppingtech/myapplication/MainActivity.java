package com.galoppingtech.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.PrivateKey;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;

public class MainActivity extends AppCompatActivity {
 private  String appID = "application-0-zdkra";

 private  Button btn;
 private  EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //
        Realm.init(this);

        App app = new App(new AppConfiguration.Builder(appID).build());

        Button btn = findViewById(R.id.materialButton);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String name = ed1.getText().toString().trim();
                 String pwd  = ed2.getText().toString().trim();

                 if (name.equals("")&& pwd.equals("")){
                     ed1.setError("Username required");
                     ed2.setError("Password required");
                 }
                 else{
                     app.loginAsync(Credentials.anonymous());
                 }



//                 app.login("Simon","Muiruri");

             }
         });
    }

    private void initViews() {
       btn = findViewById(R.id.materialButton);
       ed1 = findViewById(R.id.logUsername);
       ed2 = findViewById(R.id.logPassword);
    }
}