package com.example.user1.puntowifi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    Connection con;
    Button btnLogin;
    TextView txtUsr;
    TextView txtPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        txtUsr=(TextView)findViewById(R.id.txtUsr);
        txtPsw=(TextView)findViewById(R.id.txtPsw);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckLogin checkLogin = new CheckLogin();
                checkLogin.execute("");
            }
        });
    }

    public class CheckLogin extends AsyncTask<String,String,String>
    {
        private ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute()
        {
           /* progressDialog.setMessage("Downloading your data...");
            progressDialog.show();*/

        }

        @Override
        protected void onPostExecute(String r)
        {
            Toast.makeText(LoginActivity.this, r, Toast.LENGTH_SHORT).show();
            if(isSuccess)
            {
                //Toast.makeText(IniciarSesionActivity.this , "Login Successfull" , Toast.LENGTH_LONG).show();
                //finish();
            }
        }
        @Override
        protected String doInBackground(String... params)
        {
            String usernam = txtUsr.getText().toString();
            String passwordd = txtPsw.getText().toString();
            if(usernam.trim().equals("")|| passwordd.trim().equals(""))
                z = "Please enter Username and Password";
            else
            {
                try
                {
                    con = conexionDB();       // Connect to database
                    if (con == null)
                    {
                        z = "Check Your Internet Access!";
                    }
                    else
                    {
                        // Change below query according to your own database.
                        String query = "select * from dbo.Usuarios where IdUsuario= '" + usernam.toString() + "' and Contrasena= '"+ passwordd.toString() +"'  ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if(rs.next())
                        {
                            z = "Inicio de sesión satisfactorio";
                            isSuccess=true;
                            con.close();
                            Intent intent =new Intent(LoginActivity.this,CalcularPuntosActivity.class);
                            intent.putExtra("id",txtUsr.getText().toString());
                            startActivity(intent);
                        }
                        else
                        {
                            z = "Datos incorrectos";
                            isSuccess = false;
                        }
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = ex.getMessage();
                }
            }
            return z;
        }
    }

    public Connection conexionDB(){
        Connection conexion = null;
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://CENBUC;port=1433;databaseName=Puntos WiFi;user=CENBUC\Sebas;password=venalau2018!;");
        }

        catch(Exception ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

}
