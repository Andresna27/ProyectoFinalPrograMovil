// Generated by view binder compiler. Do not edit!
package com.proyectofinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.proyectofinal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBienvenidaBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final EditText etClave;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView34;

  @NonNull
  public final TextView textView35;

  @NonNull
  public final TextView textView45;

  @NonNull
  public final TextView textView8;

  private ActivityBienvenidaBinding(@NonNull ScrollView rootView, @NonNull Button btnLogin,
      @NonNull EditText etClave, @NonNull EditText etEmail, @NonNull LinearLayout linearLayout2,
      @NonNull TextView textView, @NonNull TextView textView12, @NonNull TextView textView13,
      @NonNull TextView textView15, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull TextView textView34, @NonNull TextView textView35, @NonNull TextView textView45,
      @NonNull TextView textView8) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.etClave = etClave;
    this.etEmail = etEmail;
    this.linearLayout2 = linearLayout2;
    this.textView = textView;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView15 = textView15;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView34 = textView34;
    this.textView35 = textView35;
    this.textView45 = textView45;
    this.textView8 = textView8;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBienvenidaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBienvenidaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bienvenida, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBienvenidaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_Login;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.et_clave;
      EditText etClave = ViewBindings.findChildViewById(rootView, id);
      if (etClave == null) {
        break missingId;
      }

      id = R.id.et_email;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView34;
      TextView textView34 = ViewBindings.findChildViewById(rootView, id);
      if (textView34 == null) {
        break missingId;
      }

      id = R.id.textView35;
      TextView textView35 = ViewBindings.findChildViewById(rootView, id);
      if (textView35 == null) {
        break missingId;
      }

      id = R.id.textView45;
      TextView textView45 = ViewBindings.findChildViewById(rootView, id);
      if (textView45 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      return new ActivityBienvenidaBinding((ScrollView) rootView, btnLogin, etClave, etEmail,
          linearLayout2, textView, textView12, textView13, textView15, textView2, textView3,
          textView34, textView35, textView45, textView8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}