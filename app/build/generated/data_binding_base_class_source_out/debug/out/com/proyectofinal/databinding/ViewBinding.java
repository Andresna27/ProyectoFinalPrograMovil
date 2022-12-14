// Generated by view binder compiler. Do not edit!
package com.proyectofinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBindings;
import com.proyectofinal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ViewBinding implements androidx.viewbinding.ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView dni;

  @NonNull
  public final TextView hora;

  @NonNull
  public final LinearLayout mylayout;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView placa;

  @NonNull
  public final TextView priority;

  @NonNull
  public final TextView telefono;

  @NonNull
  public final TextView title;

  private ViewBinding(@NonNull LinearLayout rootView, @NonNull TextView dni, @NonNull TextView hora,
      @NonNull LinearLayout mylayout, @NonNull TextView name, @NonNull TextView placa,
      @NonNull TextView priority, @NonNull TextView telefono, @NonNull TextView title) {
    this.rootView = rootView;
    this.dni = dni;
    this.hora = hora;
    this.mylayout = mylayout;
    this.name = name;
    this.placa = placa;
    this.priority = priority;
    this.telefono = telefono;
    this.title = title;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dni;
      TextView dni = ViewBindings.findChildViewById(rootView, id);
      if (dni == null) {
        break missingId;
      }

      id = R.id.hora;
      TextView hora = ViewBindings.findChildViewById(rootView, id);
      if (hora == null) {
        break missingId;
      }

      id = R.id.mylayout;
      LinearLayout mylayout = ViewBindings.findChildViewById(rootView, id);
      if (mylayout == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.placa;
      TextView placa = ViewBindings.findChildViewById(rootView, id);
      if (placa == null) {
        break missingId;
      }

      id = R.id.priority;
      TextView priority = ViewBindings.findChildViewById(rootView, id);
      if (priority == null) {
        break missingId;
      }

      id = R.id.telefono;
      TextView telefono = ViewBindings.findChildViewById(rootView, id);
      if (telefono == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new ViewBinding((LinearLayout) rootView, dni, hora, mylayout, name, placa, priority,
          telefono, title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
