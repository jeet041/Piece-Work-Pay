package sandeep.pwp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class seeker_welcome extends AppCompatActivity {
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_welcome);
        TextView tv=(TextView)findViewById(R.id.textView2);
        tv.setTextColor(Color.parseColor("blue"));
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
    }
    public void login(View v)
    {
        BackGround btg=new BackGround(this);
        String uname=et1.getText().toString();
        String pass=et2.getText().toString();
        btg.execute("login",uname,pass);
    }
    public void regredir(View v)
    {
        Intent i=new Intent(seeker_welcome.this,seeker_registration.class);
        startActivity(i);
    }
}
