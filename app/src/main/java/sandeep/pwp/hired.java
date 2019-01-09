package sandeep.pwp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;

public class hired extends AsyncTask<String,Void,String> {
    Context ctx;
    String uname;
    hired(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
         uname=strings[0];
        String hiredurl="http://10.0.2.2/webapp/hired.php";
        try{
            java.net.URL url=new java.net.URL(hiredurl);
            HttpURLConnection htp = (HttpURLConnection) url.openConnection();
            htp.setRequestMethod("POST");
            OutputStream OS = htp.getOutputStream();
            BufferedWriter Bf = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8");
            Bf.write(data);
            Bf.flush();
            OS.close();
            InputStream is = htp.getInputStream();
            is.close();
            return "success";
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
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
    protected void onPostExecute(String s) {
        Toast.makeText(ctx,uname,Toast.LENGTH_LONG).show();
    }


}
