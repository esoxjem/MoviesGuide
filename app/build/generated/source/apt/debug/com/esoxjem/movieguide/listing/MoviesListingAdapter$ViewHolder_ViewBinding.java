// Generated code from Butter Knife. Do not modify!
package com.esoxjem.movieguide.listing;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.esoxjem.movieguide.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MoviesListingAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MoviesListingAdapter.ViewHolder target;

  @UiThread
  public MoviesListingAdapter$ViewHolder_ViewBinding(MoviesListingAdapter.ViewHolder target, View source) {
    this.target = target;

    target.poster = Utils.findRequiredViewAsType(source, R.id.movie_poster, "field 'poster'", ImageView.class);
    target.titleBackground = Utils.findRequiredView(source, R.id.title_background, "field 'titleBackground'");
    target.name = Utils.findRequiredViewAsType(source, R.id.movie_name, "field 'name'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MoviesListingAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.poster = null;
    target.titleBackground = null;
    target.name = null;
  }
}
