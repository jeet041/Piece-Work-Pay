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

public class provider_registration extends AppCompatActivity {

    DatePicker dp;
    TextView dob;
    EditText username,email,passwd,fname,mname,lname,fthname,phone,addr,state,city;
    String uname,em,pwd,fn,mn,ln,fthn,adr,st,ct,ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_registration);
        TextView tv=findViewById(R.id.signin1);
        tv.setTextColor(Color.parseColor("blue"));
        dp=findViewById(R.id.dtpick1);
        dob=findViewById(R.id.dob1);
        fname=findViewById(R.id.fname1);
        mname=findViewById(R.id.mname1);
        lname=findViewById(R.id.lname1);
        fthname=findViewById(R.id.fthname1);
        phone=findViewById(R.id.phone1);
        addr=findViewById(R.id.addr1);
        state=findViewById(R.id.state1);
        city=findViewById(R.id.city1);
        username=findViewById(R.id.unname1);
        passwd=findViewById(R.id.pwd1);
        email=findViewById(R.id.email1);
    }
    public void login1(View v)
    {
        Intent i =new Intent(provider_registration.this,provider_welcome.class);
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
        if(pwd.length()<6)
        {
            passwd.setError("password should be atleast 8 digits");
            b=false;
        }
        return b;
    }
    public void register1(View v)
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
            bgprovide btg =new bgprovide(this);
            btg.execute("register",uname,pwd,em,fn,mn,ln,fthn,adr,st,ct,ph);
            finish();
        }
    }
}
