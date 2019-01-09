package sandeep.pwp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
public class welcome extends AppCompatActivity {
    public String urladr="hello";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }
    public void seek(View v)
    {
        Intent i= new Intent(welcome.this,seeker_welcome.class);
        startActivity(i);
    }
    public void provide(View v)
    {
        startActivity(new Intent(this,provider_welcome.class));
    }

}
