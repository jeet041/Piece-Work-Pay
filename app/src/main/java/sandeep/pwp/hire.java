package sandeep.pwp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class hire extends AppCompatActivity {
    Intent in;
    String details[];
    TextView nm,ph,rt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);
        in=getIntent();
        String res=in.getStringExtra("data");
        details=res.split("\\s+");
        nm=findViewById(R.id.nm);
        ph=findViewById(R.id.ph);
        rt=findViewById(R.id.rate);
        nm.setText(("Name:   "+details[0]));
        ph.setText(("Phone:  "+details[1]));
        rt.setText(("Rate:   "+details[2]+" rs per hour"));
    }
    public void hired(View v)
    {
        NotificationCompat.Builder notify=(NotificationCompat.Builder) new NotificationCompat.Builder(this,"1")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(details[0]+" HIRED")
                .setContentText("amount payable is rs."+details[2]+" per hour");
        NotificationManager Nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Nm.notify(1,notify.build());
        hired hd=new hired(this);
        hd.execute(details[3]);
    }
}
