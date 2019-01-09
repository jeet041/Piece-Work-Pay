package sandeep.pwp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;

public class available extends AsyncTask<String,Void,String> {
    Context ctx;
    String data;
    available(Context ctx )
    {
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params) {
        String t1=params[0];
        String t2=params[1];
        String ct=params[2];
        String sk=params[3];
        try {
            String adr="http://10.0.2.2/webapp/avl.php";
            java.net.URL url = new java.net.URL(adr);
            HttpURLConnection htp = (HttpURLConnection) url.openConnection();
            htp.setRequestMethod("POST");
            htp.setDoOutput(true);
            OutputStream OS = htp.getOutputStream();
            BufferedWriter Bf = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            data = URLEncoder.encode("start", "UTF-8") + "=" + URLEncoder.encode(t1, "UTF-8")+"&"+
                    URLEncoder.encode("end", "UTF-8") + "=" + URLEncoder.encode(t2, "UTF-8")+"&"+
                    URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(ct, "UTF-8")+"&"+
                    URLEncoder.encode("skill", "UTF-8") + "=" + URLEncoder.encode(sk, "UTF-8");
            Bf.write(data);
            Bf.flush();
            Bf.close();
            OS.close();
            InputStream is=htp.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
            String response="";
            String line="";
            while((line=bf.readLine())!=null)
            {
                response+=line;
                response+="\n";
            }
            bf.close();
            is.close();
            htp.disconnect();
            return response;
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String aVoid) {
        Toast.makeText(ctx,aVoid,Toast.LENGTH_LONG).show();
        Intent in=new Intent(ctx,itemlist.class);
        in.putExtra("names",aVoid);
        ctx.startActivity(in);
    }
}
