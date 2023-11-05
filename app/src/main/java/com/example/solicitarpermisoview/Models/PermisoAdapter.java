package com.example.solicitarpermisoview.Models;
import static androidx.core.content.ContextCompat.startActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.solicitarpermisoview.R;
import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.ViewHolder> {
    List<Permiso> infoPermisos;

    public PermisoAdapter(List<Permiso> infoPermisos){
        this.infoPermisos = infoPermisos;
    }


    @NonNull
    @Override
    public PermisoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_permiso_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.ViewHolder holder, int position) {
        Permiso permiso = infoPermisos.get(position);
        holder.setData(permiso);
    }

    @Override
    public int getItemCount() {
        return infoPermisos.size();
    }

    private static final int REQUEST_CALL_PHONE = 123;
    private static final int REQUEST_CAMERA = 321;
    private static final int REQUEST_MESSAGE = 231;

    TextView name;
    Switch check;
    int REQUEST_CODE = 2871;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            check = itemView.findViewById(R.id.check);

            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        switch (position) {
                            case 0:
                                solicitarMensajes();
                                break;
                            case 1:
                                solicitarCamara();
                                break;
                            case 2:
                                solicitarLlamada();
                                break;
                        }
                    }
                }
            });
        }

        public void setData(Permiso permiso) {
            name.setText(permiso.getPermiso());
        }


        public void solicitarMensajes() {
            if (ContextCompat.checkSelfPermission(itemView.getContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(), new String[]{Manifest.permission.SEND_SMS}, REQUEST_MESSAGE);
            } else {
                mandarMensaje();
            }
        }

        private void mandarMensaje() {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:6242647089"));
            itemView.getContext().startActivity(intent);
        }

        public void solicitarLlamada() {
            if (ContextCompat.checkSelfPermission(itemView.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
            } else {
                realizarLLamada();
            }
        }

        private void realizarLLamada() {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:624-264-70-89"));
            itemView.getContext().startActivity(intent);
        }

        public void solicitarCamara() {
            if (ContextCompat.checkSelfPermission(itemView.getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(), new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
            } else {
                tomarFoto();
            }
        }

        private void tomarFoto() {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            itemView.getContext().startActivity(intent);
        }
    }


}






