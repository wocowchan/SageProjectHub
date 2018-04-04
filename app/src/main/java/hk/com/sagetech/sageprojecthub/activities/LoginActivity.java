package hk.com.sagetech.sageprojecthub.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hk.com.sagetech.sageprojecthub.R;
import hk.com.sagetech.sageprojecthub.utils.SharedPreferenceConfig;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferenceConfig preferenceConfig;
    private EditText UserName,UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        UserName = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);

        if(preferenceConfig.readLoginStatus())
        {
            startActivity(new Intent (this,text_log_out.class));
            finish();
        }
    }

    public void userLogIn (View view)
    {
        String user_name = UserName.getText().toString();
        String user_password =UserPassword.getText().toString();

        if(user_name.equals(getResources().getString(R.string.user_name))&& user_password.equals(getResources().getString(R.string.user_password)))
        {
            startActivity(new Intent (this,text_log_out.class));
            preferenceConfig.writeLoginStatus(true);
        }
        else
        {
            Toast.makeText(this,"Login Failed....Try again....", Toast.LENGTH_SHORT).show();
            UserName.setText("");
            UserPassword.setText("");
        }
    }
}