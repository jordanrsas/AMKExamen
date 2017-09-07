package com.amk_community.amkexamen.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.amk_community.amkexamen.MainActivity;
import com.amk_community.amkexamen.R;
import com.amk_community.amkexamen.controllers.BaseActivity;
import com.amk_community.amkexamen.filters.FiltersActivity;
import com.amk_community.amkexamen.utils.Dialogs;
import com.amk_community.amkexamen.utils.ValidateForm;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jordan on 06/09/2017.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.edittext_usuario)
    TextInputEditText usuarioEdit;
    @BindView(R.id.edittext_password)
    TextInputEditText passwordEdit;
    @BindView(R.id.btn_login)
    Button loginButton;

    private String user;
    private String pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        validateFields();
    }

    private void validateFields() {
        getData();
        if (TextUtils.isEmpty(user)) {
            showError("El campo Usuario está vacío, por favor valida tu información");
        } else if (TextUtils.isEmpty(pass)) {
            showError("El campo Contraseña está vacío, por favor valida tu información");
        } else if (user.length() < 8) {
            showError("El campo Usuario debe tener al menos 8 caracteres.");
        } else if (pass.length() < 8) {
            showError("El campo Contraseña debe tener al menos 8 caracteres.");
        } else if (!ValidateForm.isValidPassword(user)) {
            showError("El formato del campo Usuario es incorrecto, por favor valida tu información");
        } else if (!ValidateForm.isValidPassword(pass)) {
            showError("El formato del campo Contraseña es incorrecto, por favor valida tu información");
        } else {
            continueLogin();
        }
    }

    private void getData() {
        user = usuarioEdit.getText().toString().trim();
        pass = passwordEdit.getText().toString().trim();
    }

    private void showError(String errorTxt) {
        //Toast.makeText(this, errorTxt, Toast.LENGTH_SHORT).show();
        Dialogs.createSimpleErrorDialogNoCancel(this, errorTxt);
    }

    private void continueLogin() {
        showProgressLayout("Iniciando sesión");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgresLayout();
                Intent i = new Intent(LoginActivity.this, FiltersActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
