// Generated by view binder compiler. Do not edit!
package com.infoabout.contactlist.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.infoabout.contactlist.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentUserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton btnAddToFav;

  @NonNull
  public final MaterialButton btnUpdate;

  @NonNull
  public final TextInputEditText etEmail;

  @NonNull
  public final TextInputEditText etName;

  @NonNull
  public final TextInputEditText etPhone;

  @NonNull
  public final LinearLayout linearLayout;

  private FragmentUserBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton btnAddToFav, @NonNull MaterialButton btnUpdate,
      @NonNull TextInputEditText etEmail, @NonNull TextInputEditText etName,
      @NonNull TextInputEditText etPhone, @NonNull LinearLayout linearLayout) {
    this.rootView = rootView;
    this.btnAddToFav = btnAddToFav;
    this.btnUpdate = btnUpdate;
    this.etEmail = etEmail;
    this.etName = etName;
    this.etPhone = etPhone;
    this.linearLayout = linearLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAddToFav;
      FloatingActionButton btnAddToFav = ViewBindings.findChildViewById(rootView, id);
      if (btnAddToFav == null) {
        break missingId;
      }

      id = R.id.btnUpdate;
      MaterialButton btnUpdate = ViewBindings.findChildViewById(rootView, id);
      if (btnUpdate == null) {
        break missingId;
      }

      id = R.id.etEmail;
      TextInputEditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.etName;
      TextInputEditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.etPhone;
      TextInputEditText etPhone = ViewBindings.findChildViewById(rootView, id);
      if (etPhone == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      return new FragmentUserBinding((ConstraintLayout) rootView, btnAddToFav, btnUpdate, etEmail,
          etName, etPhone, linearLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
