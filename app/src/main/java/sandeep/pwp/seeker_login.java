package sandeep.pwp;


import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class seeker_login extends AppCompatActivity {
    TextView tv;
    Intent in;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_login);
        tv=findViewById(R.id.nm);
        in=getIntent();
        tv.setText("welcome "+in.getStringExtra("name"));

    }
    public void onln(View v)
    {
        EditText et1=findViewById(R.id.editText3);
        EditText et2=findViewById(R.id.editText4);
        EditText et3=findViewById(R.id.editText5);
        EditText et4=findViewById(R.id.editText6);
        EditText et5=findViewById(R.id.editText7);
        String strt=et1.getText().toString();
        String end=et2.getText().toString();
        String ct=et3.getText().toString();
        String skill=et4.getText().toString();
        String rate=et5.getText().toString();
        BackGround btg=new BackGround(this);
        btg.execute("online",in.getStringExtra("username"),strt,end,ct,skill,rate);
    }
    public void fragmentOpen(View v)
    {
        Intent i=new Intent(seeker_login.this,BlankFragment.class);
        startActivity(i);
    }
}
