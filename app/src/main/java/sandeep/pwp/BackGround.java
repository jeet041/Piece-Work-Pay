package sandeep.pwp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
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

import static android.support.v4.content.ContextCompat.startActivity;

public class BackGround extends AsyncTask<String,Void,String> {
    Context ctx;
    AlertDialog at;
    welcome w;
    String data,uname,method;
    BackGround(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        at=new AlertDialog.Builder(ctx).create();

    }

    @Override
    protected String doInBackground(String... params) {
        String reg="http://10.0.2.2/webapp/reg.php";
        String login="http://10.0.2.2/webapp/login.php";
        method=params[0];
        if(method.equals("register")) {
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
                        URLEncoder.encode("st", "UTF-8") + "=" + URLEncoder.encode(st, "UTF-8")+ "&" +
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
          //  Toast.makeText(ctx,w.urladdress,Toast.LENGTH_LONG);
            uname=params[1];
            String pwd=params[2];
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
        else if(method.equals("online"))
        {
            String avail="http://10.0.2.2/webapp/seeker.php";
            uname=params[1];
            String strt=params[2];
            String end=params[3];
            String ct=params[4];
            String skill=params[5];
            String rate=params[6];
            String response="";
            try
            {
               java.net.URL url = new java.net.URL(avail);
                HttpURLConnection htp = (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoOutput(true);
                OutputStream OS = htp.getOutputStream();
                BufferedWriter Bf = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                data=URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8")+"&"+
                        URLEncoder.encode("strt", "UTF-8") + "=" + URLEncoder.encode(strt, "UTF-8")+"&"+
                        URLEncoder.encode("end", "UTF-8") + "=" + URLEncoder.encode(end, "UTF-8")+"&"+
                        URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(ct, "UTF-8")+"&"+
                        URLEncoder.encode("skill", "UTF-8") + "=" + URLEncoder.encode(skill, "UTF-8")+"&"+
                        URLEncoder.encode("rate", "UTF-8") + "=" + URLEncoder.encode(rate, "UTF-8");
                Bf.write(data);
                Bf.flush();
                Bf.close();
                OS.close();
                InputStream is=htp.getInputStream();
                BufferedReader bf=new BufferedReader(new InputStreamReader(is,"iso-8859-1"));

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
            catch(MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return response;
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(!result.matches("unsuccessfull") && method.matches("login"))
        {
            Intent i=new Intent(ctx,seeker_login.class);
            i.putExtra("name",result);
            i.putExtra("username",uname);
            ctx.startActivity(i);
        }
        else if(result.matches("unsuccessfull"))
        {
            Toast.makeText(ctx,"invalid details",Toast.LENGTH_LONG).show();
        }
        else
        {
           Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }
    }

}

