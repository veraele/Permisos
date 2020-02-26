package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.ActivityCompat;
        import androidx.core.content.ContextCompat;

        import android.Manifest;
        import android.app.Activity;
        import android.content.pm.PackageManager;
        import android.graphics.Color;
        import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.CursorAdapter;
import android.widget.TextView;
        import android.widget.Toast;

public class PermissionInfo extends AppCompatActivity {
    String[] mProjection;
    Cursor mCursor;
    static final int PERMISSION_CONTACTS_ID = 5;
    TextView tvPermissionState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_info);
        tvPermissionState = findViewById(R.id.tvPermissionState);
        requestPermission(this, Manifest.permission.READ_CONTACTS, "Es necesario para mostrar los contactos", PERMISSION_CONTACTS_ID );
        initViews();
    }

    public void initViews(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED){
            tvPermissionState.setText(getResources().getString(R.string.permissionOK));
            mProjection = new String[]{ ContactsContract.Profile._ID,
                    ContactsContract.Profile.DISPLAY_NAME_PRIMARY };
            mCursor=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,mProjection, null, null, null);
        }else {
            tvPermissionState.setText(getResources().getString(R.string.permissionKO));
            tvPermissionState.setTextColor(Color.RED);
        }
    }

    /**
     * Metodo para solicitar un permiso
     * @param context actividad actual
     * @param permission permiso que se desea solicitar
     * @param just justificacion para el permiso
     * @param id identificador con el se marca la solicitud y se captura el callback de respuesta
     */
    public void requestPermission(Activity context, String permission, String just, int id) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(context, permission)) {
                // Show an expanation to the user *asynchronously*Â  Â
                Toast.makeText(context, just, Toast.LENGTH_LONG).show();
            }
            // request the permission.Â  Â
            ActivityCompat.requestPermissions(context, new String[]{permission}, id);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        initViews();
        //Si se tienen varios casos
//        switch(requestCode){
//            case PERMISSION_CONTACTS_ID: {
//
//                return;
//            }
//        }
    }
}