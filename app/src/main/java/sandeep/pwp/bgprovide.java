package sandeep.pwp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
public class bgprovide extends AsyncTask<String,Void,String>{
    Context ctx;
    String data,uname,method;
    welcome w;
    bgprovide(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
       method=params[0];
        if(method.equals("register"))
        {
           uname=params[1];
            String pwd=params[2];
            String em=params[3];
            String fn=params[4];
            String mn=params[5];
            String ln=params[6];
            String fthn=params[7];
            String adr=params[8];
            String st=params[9];
            String ct=params[10];
            String ph=params[11];
            String reg="http://10.0.2.2/webapp/prov_reg.php";
            try {

                java.net.URL url = new java.net.URL(reg);
                HttpURLConnection htp = (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoOutput(true);
                OutputStream OS = htp.getOutputStream();
                BufferedWriter Bf = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pwd, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(em, "UTF-8") + "&" +
                        URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(fn, "UTF-8") + "&" +
                        URLEncoder.encode("mname", "UTF-8") + "=" + URLEncoder.encode(mn, "UTF-8") + "&" +
                        URLEncoder.encode("lname", "UTF-8") + "=" + URLEncoder.encode(ln, "UTF-8") + "&" +
                        URLEncoder.encode("fthname", "UTF-8") + "=" + URLEncoder.encode(fthn, "UTF-8") + "&" +
                        URLEncoder.encode("adr", "UTF-8") + "=" + URLEncoder.encode(adr, "UTF-8") + "&" +
                        URLEncoder.encode("ct", "UTF-8") + "=" + URLEncoder.encode(ct, "UTF-8") + "&" +
                        URLEncoder.encode("st", "UTF-8") + "=" + URLEncoder.encode(st, "UTF-8")+"&"+
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(ph, "UTF-8");
                Bf.write(data);
                Bf.flush();
                Bf.close();
                OS.close();
                InputStream is = htp.getInputStream();
                BufferedReader bf=new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bf.readLine())!=null)
                {
                    response+=line;
                }
                bf.close();
                is.close();
                htp.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login"))
        {
            uname=params[1];
            String pwd=params[2];
            String login="http://10.0.2.2/webapp/prov_login.php";
            try {
                java.net.URL url = new java.net.URL(login);
                HttpURLConnection htp = (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoOutput(true);
                OutputStream OS = htp.getOutputStream();
                BufferedWriter Bf = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                data=URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pwd, "UTF-8");
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
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(String aVoid) {
        if(!aVoid.matches("unsuccessfull") && method.matches("login"))
        {
            Intent i=new Intent(ctx,provider_login.class);
            i.putExtra("name",aVoid);
            i.putExtra("username",uname);
            ctx.startActivity(i);
        }
        else if(aVoid.matches("unsuccessfull"))
        {
            Toast.makeText(ctx,"invalid details",Toast.LENGTH_LONG).show();
        }
    }

}
