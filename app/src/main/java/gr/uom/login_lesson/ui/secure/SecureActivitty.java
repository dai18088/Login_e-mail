package gr.uom.login_lesson.ui.secure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import gr.uom.login_lesson.R;
import gr.uom.login_lesson.ui.login.LoginActivity;

public class SecureActivitty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            Intent i=new Intent(this, LoginActivity.class);
            startActivity(i);
        }else{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_secure_activitty);

            TextView textView=findViewById(R.id.welcomeTxt);

            Intent intent=getIntent();
            if(intent!=null){
                String welcomeText=intent.getStringExtra("displayName");
                textView.setText(welcomeText);
            }


        }



    }
}