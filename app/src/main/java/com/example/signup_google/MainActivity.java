package com.example.signup_google;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SignInButton signInButton;
    private TextView txt_Name, txt_GivenName, txt_FamilyName, txt_email, txt_Id;
    private ImageView img_Photo;
    private Button btn;
    GoogleSignInClient mGoogleSignInClient;
    String WEB_CLIENT_ID ="899049401541-8gmqogdq6c5e890mn6kk5vt1jv7rufd9.apps.googleusercontent.com";
    private String TAG ="wwwwwwwwwwwwwww";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.sign_in_button);
        txt_Name = findViewById(R.id.txt_Name);
        txt_GivenName = findViewById(R.id.txt_GivenName);
        txt_FamilyName = findViewById(R.id.txt_FamilyName);
        txt_email = findViewById(R.id.txt_email);
        img_Photo = findViewById(R.id.img_Photo);
        txt_Id = findViewById(R.id.txt_Id);
        btn = findViewById(R.id.sign_out_button);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(WEB_CLIENT_ID)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(this);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:{
                signIn();
            }break;
            case R.id.sign_out_button:{
                signOut();
            }break;
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1);
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        task.addOnSuccessListener(v -> {
                            revokeAccess();
                            updateUI(null);
                        });
                        task.addOnFailureListener(v -> Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show());
                    }
                });
    }

    private void revokeAccess() {
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 1) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account){
        if(account == null){
            txt_Name.setText("Name: null");
            txt_GivenName.setText("GivenName: null");
            txt_FamilyName.setText("FamilyName: null");
            txt_email.setText("null");
            txt_Id.setText("null");
            img_Photo.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_sentiment_satisfied_alt_24));
            return;
        }
        txt_Name.setText("Name: " +account.getDisplayName());
        txt_GivenName.setText("GivenName: " +account.getGivenName());
        txt_FamilyName.setText("FamilyName: " +account.getFamilyName());
        txt_email.setText(account.getEmail());
        txt_Id.setText(account.getId());
        Glide.with(MainActivity.this).load(account.getPhotoUrl()).into(img_Photo);
    }
}