package sandeep.pwp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

public class provider_login extends AppCompatActivity {

    public ArrayList<String> al;
    //String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_login);
        al=new ArrayList <String>();
    }
    public void srchavailable(View v)
    {
        welcome w=new welcome();
        EditText et1=findViewById(R.id.starttime);
        EditText et2=findViewById(R.id.endtime);
        EditText et3=findViewById(R.id.cts);
        EditText et4=findViewById(R.id.skills);
        String t=et1.getText().toString();
        String t1=et2.getText().toString();
        String t2=et3.getText().toString();
        String t3=et4.getText().toString();
       available avg=new available(this);
       avg.execute(t,t1,t2,t3);
    }
}
