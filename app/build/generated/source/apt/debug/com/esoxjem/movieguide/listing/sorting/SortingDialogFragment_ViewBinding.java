// Generated code from Butter Knife. Do not modify!
package com.esoxjem.movieguide.listing.sorting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.esoxjem.movieguide.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SortingDialogFragment_ViewBinding implements Unbinder {
  private SortingDialogFragment target;

  @UiThread
  public SortingDialogFragment_ViewBinding(SortingDialogFragment target, View source) {
    this.target = target;

    target.mostPopular = Utils.findRequiredViewAsType(source, R.id.most_popular, "field 'mostPopular'", RadioButton.class);
    target.highestRated = Utils.findRequiredViewAsType(source, R.id.highest_rated, "field 'highestRated'", RadioButton.class);
    target.favorites = Utils.findRequiredViewAsType(source, R.id.favorites, "field 'favorites'", RadioButton.class);
    target.newest = Utils.findRequiredViewAsType(source, R.id.newest, "field 'newest'", RadioButton.class);
    target.sortingOptionsGroup = Utils.findRequiredViewAsType(source, R.id.sorting_group, "field 'sortingOptionsGroup'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SortingDialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mostPopular = null;
    target.highestRated = null;
    target.favorites = null;
    target.newest = null;
    target.sortingOptionsGroup = null;
  }
}
