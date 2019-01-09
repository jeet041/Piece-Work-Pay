package sandeep.pwp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class seeker_registration extends AppCompatActivity {

    DatePicker dp;
    TextView dob;
    EditText username,email,passwd,fname,mname,lname,fthname,phone,addr,state,city;
    String uname,em,pwd,fn,mn,ln,fthn,adr,st,ct,ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_registration);
        TextView tv=findViewById(R.id.signin);
        tv.setTextColor(Color.parseColor("blue"));
        dp=findViewById(R.id.dtpick);
        dob=findViewById(R.id.dob);
        fname=findViewById(R.id.fname);
        mname=findViewById(R.id.mname);
        lname=findViewById(R.id.lname);
        fthname=findViewById(R.id.fthname);
        phone=findViewById(R.id.phone);
        addr=findViewById(R.id.addr);
        state=findViewById(R.id.state);
        city=findViewById(R.id.city);
        username=findViewById(R.id.unname);
        passwd=findViewById(R.id.pwd);
        email=findViewById(R.id.email);
    }
    public void login(View v)
    {
        finish();
        Intent i =new Intent(seeker_registration.this,seeker_welcome.class);
        startActivity(i);
    }
    public void datepick(View v)
    {
        dp.setVisibility(v.VISIBLE);
    }
    public void dateselect(View v)
    {
        String day=""+dp.getDayOfMonth();
        String month="/"+dp.getMonth();
        String year="/"+dp.getYear();
        day=day+month+year;
        dob.setText(day);
        dp.setVisibility(v.GONE);
    }
    protected boolean validate()
    {
        boolean b=true;
        if(uname.isEmpty())
        {
            username.setError("please choose a username");
            b=false;
        }
        if(ph.isEmpty() || ph.length()!=10)
        {
            phone.setError("enter a valid mobile number");
            b=false;
        }
        if(pwd.isEmpty())
        {
            passwd.setError("please select a password");
            b=false;
        }
        if(em.isEmpty())
        {
            email.setError("enter an email");
            b=false;
        }
        if(fn.isEmpty())
        {
            fname.setError("enter first name");
            b=false;
        }
        if(ln.isEmpty())
        {
            lname.setError("enter last name");
            b=false;
        }
        if(fthn.isEmpty())
        {
            fthname.setError("enter father's name");
            b=false;
        }
        if(adr.isEmpty())
        {
            addr.setError("enter valid address");
            b=false;
        }
        if(st.isEmpty())
        {
            state.setError("enter state");
            b=false;
        }
        if(ct.isEmpty())
        {
            city.setError("enter city");
            b=false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches())
        {
            email.setError("enter valid address");
            b=false;
        }
        if(pwd.length()<8)
        {
            passwd.setError("password should be atleast 8 digits");
            b=false;
        }
        return b;
    }
    public void register(View v)
    {
        uname = username.getText().toString().trim();
        pwd = passwd.getText().toString().trim();
        em = email.getText().toString().trim();
        fn=fname.getText().toString().trim();
        mn=mname.getText().toString().trim();
        ln=lname.getText().toString().trim();
        fthn=fthname.getText().toString().trim();
        adr=addr.getText().toString().trim();
        st=state.getText().toString().trim();
        ct=city.getText().toString().trim();
        ph=phone.getText().toString();
        if(validate())
        {
            BackGround btg =new BackGround(this);
            btg.execute("register",uname,pwd,em,fn,mn,ln,fthn,adr,st,ct,ph);
            finish();
        }
    }
}
