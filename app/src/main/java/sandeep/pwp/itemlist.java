package sandeep.pwp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class itemlist extends AppCompatActivity {
    Intent in;
    LinearLayout linearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);
       in=getIntent();
        String names=in.getStringExtra("names");
        String lines[]=names.split("\\r?\\n");
        int len=lines.length;
        for(int i=0;i<len;i++) {
            final TextView t = new TextView(this);
            final String details[]=lines[i].split("\\s+");
            String res=details[0]+"  "+details[1]+" "+details[3];
            t.setText(res);
            t.setTextSize(20);
            t.setClickable(true);

            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1=new Intent(itemlist.this,hire.class);
                    i1.putExtra("data",t.getText()+" "+details[2]);
                    startActivity(i1);
                }
            });
            linearlayout = findViewById(R.id.linearlayout);
            linearlayout.addView(t);
        }
    }

}
