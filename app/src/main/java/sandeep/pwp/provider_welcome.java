package sandeep.pwp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class provider_welcome extends AppCompatActivity {
    TextView tvs;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_welcome);
        tvs=findViewById(R.id.tvsign);
        tvs.setTextColor(Color.parseColor("blue"));
        et1=findViewById(R.id.pname);
        et2=findViewById(R.id.ppass);
    }
    public void pvreg(View v)
    {
        startActivity(new Intent(provider_welcome.this,provider_registration.class));
    }
    public void pvlogin(View v)
    {
        bgprovide btg=new bgprovide(this);
        String uname=et1.getText().toString();
        String pass=et2.getText().toString();
        btg.execute("login",uname,pass);
    }
}
