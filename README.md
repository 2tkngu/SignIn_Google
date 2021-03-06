<h1 id="number0">Table of Contents</h1>
<ul>
    <li><a href="#number1">Get your backend server's OAuth 2.0 client ID</a></li>
    <li><a href="#number2">Code on Android Studio</a></li>
    <li><a href="#number3">Package name</a></li>
    <li><a href="#number4">Take SHA-1</a></li>
</ul>

<h1 id="number1"><a href="#number0">Get your backend server's OAuth 2.0 client ID</a></h1>
<p>Network: https://console.cloud.google.com/apis/credentials</p>
<img src="https://user-images.githubusercontent.com/83626285/138579304-708097af-eef3-403a-bf62-f7ffd25fc88d.png"/>
<h3>Step 1: Select project avaiable or new project<h3>
<img src="https://user-images.githubusercontent.com/83626285/138579332-576bd31a-4fee-4429-abed-e67202fb5902.png"/>
<h3><b>If create new project</b></h3>
<img src="https://user-images.githubusercontent.com/83626285/138579547-bd531c14-00e7-4d90-bba9-f1cb41053ab1.png"/>
<h3>Step 2: After select project</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579374-8271edcb-af59-446b-aabf-f3d62353d25d.png"/>
<img src="https://user-images.githubusercontent.com/83626285/138579393-2d4f19c1-8b14-4b2f-8d6e-5708550683ca.png"/>
<h3>Step 3:Fill request information</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579450-c33f1a3f-5c7b-4738-974d-2325001a7f78.png"/>
<img src="https://user-images.githubusercontent.com/83626285/138579726-8c2f1529-13ea-41a7-ad31-cc5d5a22b56b.png"/>
<h3S>Step 4: Scroll to bottom and press "SAVE AND CONTINUE"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579765-ae5151fe-19d5-4e6a-a1bd-5dc35375845e.png"/>
<h3>Step 5: Scroll to bottom and press "SAVE AND CONTINUE"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579781-d8417d4e-c60e-4f53-99c1-9f8267d4952e.png"/>
<h3>Step 6: Scroll to bottom and press "BACK TO DASHBOARD"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579799-73d53385-c695-4091-a1f2-94b99e6ae1a0.png"/>
<h3>Step 7: At line left press "Credentials"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579823-e5901ec6-962c-4993-a84c-2f223c6d3cfd.png"/>
<h3>Step 8: Press "CREATE CREDENTAILS"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579838-9414f446-6a8c-4909-9b6a-1340e229e1b8.png"/>
<h3>Step 9: Select "Oauth client ID"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138593926-00ae3296-f25d-43b0-a774-d60b0569ce21.png"/>
<h3>Step 10: Select "Android"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138593968-d5767c7c-5752-4bfe-a415-d03f97d54133.png"/>
<h3>Step 11: Fill request information and press "CREATE"</h3>
<p><a href="#number4">Take SHA-1<a></p>
<p><a href="#number3">Package name<a></p>
<img src="https://user-images.githubusercontent.com/83626285/138594022-e8b48d70-f9b4-4c4d-a7b9-9a5a016de116.png"/>
<h3 id="number1_13">Step 13: Press "DOWNLOAD JSON"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138594689-43e70060-6a9d-499f-8241-a0d915bc65c4.png"/>
<h3>Step 14: Press "CREATE CREDENTAILS"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138579838-9414f446-6a8c-4909-9b6a-1340e229e1b8.png"/>
<h3>Step 15: Select "Oauth client ID"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138593926-00ae3296-f25d-43b0-a774-d60b0569ce21.png"/>
<h3>Step 16: Select "Web application"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138594919-4d75f82b-f6c9-4d18-ba0a-82ee36e4cb72.png"/>
<h3>Step 17: Scroll to bottom and press "CONTINUE"</h3>
<img src="https://user-images.githubusercontent.com/83626285/138594976-63abdca6-5e1d-451f-b453-5d7482aa66b8.png"/>
<h3>Step 18: Copy ID of Web</h3>
<img src="https://user-images.githubusercontent.com/83626285/138595025-8bc572bb-14c4-498d-80d4-9cb56e2b03ac.png"/>

<h1 id="number2"><a href="#number0">Code on Android Studio</a></h1>
<img src="https://user-images.githubusercontent.com/83626285/138595215-931e368c-e442-448c-959f-f70c93e14f56.png"/>
<h3><a href="#number1_13">Paste the json file by downloading step 13 to src</a></h3>
<img src="https://user-images.githubusercontent.com/83626285/138595403-41cc0a68-31b0-4e97-b513-d322f20fbc75.png"/>
<h3>AndroidManifest.xml</h3>
<img src="https://user-images.githubusercontent.com/83626285/138596058-7e2794c2-9395-42ca-8732-6df35c174468.png"/>

<h3>Library</h3>
<pre>
<code>
    implementation 'com.google.android.gms:play-services-auth:19.2.0'  //google
    implementation 'com.github.bumptech.glide:glide:4.10.0'            //image
</code>
</pre>
<h3>Code MainActivity.cs</h3>
<pre>
<code>
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
    String WEB_CLIENT_ID ="899049401541-8gmqogdq6c5e890mn6kk5vt1jv7rufd9.apps.googleusercontent.com";  //take at step 18
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
</code>
</pre>
    
<h1 id="number3"><a href="#number0">Package name</a></h1>
<img src="https://user-images.githubusercontent.com/83626285/138594646-3a28ad10-2fc9-45c6-bf32-5d8827b4b612.png"/>

<h1 id="number4"><a href="#number0">Take SHA-1</a></h1>
<img src="https://user-images.githubusercontent.com/83626285/138594290-17b2a11e-1d42-4c2c-81e3-4dd6cc2db321.png"/>
<img src="https://user-images.githubusercontent.com/83626285/138594396-40aae450-d8f6-4a3b-b60e-1c28b4b675fd.png"/>
<img src="https://user-images.githubusercontent.com/83626285/138594480-b994080b-59ff-41c1-9803-900feab393a5.png"/>
