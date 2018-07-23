package com.esoxjem.movieguide.details;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.esoxjem.movieguide.Api;
import com.esoxjem.movieguide.BaseApplication;
import com.esoxjem.movieguide.Constants;
import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.Review;
import com.esoxjem.movieguide.Video;
import com.esoxjem.movieguide.databinding.FragmentMovieDetailsBinding;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MovieDetailsFragment extends Fragment implements MovieDetailsView, View.OnClickListener
{
    @Inject
    MovieDetailsPresenter movieDetailsPresenter;

    CollapsingToolbarLayout collapsingToolbar;

    private Movie movie;
    private FragmentMovieDetailsBinding fragmentMovieDetailsBinding;

    public MovieDetailsFragment()
    {
        // Required empty public constructor
    }

    public static MovieDetailsFragment getInstance(@NonNull Movie movie)
    {
        Bundle args = new Bundle();
        args.putParcelable(Constants.MOVIE, movie);
        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        movieDetailsFragment.setArguments(args);
        return movieDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).createDetailsComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        fragmentMovieDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false);
        View rootView = fragmentMovieDetailsBinding.getRoot();
        collapsingToolbar = fragmentMovieDetailsBinding.collapsingToolbar;
        setToolbar();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null)
        {
            Movie movie = (Movie) getArguments().get(Constants.MOVIE);
            if (movie != null)
            {
                this.movie = movie;
                movieDetailsPresenter.setView(this);
                movieDetailsPresenter.showDetails((movie));
                movieDetailsPresenter.showFavoriteButton(movie);
            }
        }
    }

    private void setToolbar()
    {
        collapsingToolbar.setContentScrimColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        collapsingToolbar.setTitle(getString(R.string.movie_details));
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        collapsingToolbar.setTitleEnabled(true);

        if (fragmentMovieDetailsBinding.toolbar != null)
        {
            ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentMovieDetailsBinding.toolbar);

            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else
        {
            // Don't inflate. Tablet is in landscape mode.
        }
    }

    @Override
    public void showDetails(Movie movie)
    {
        Glide.with(getContext()).load(Api.getBackdropPath(movie.getBackdropPath())).into(fragmentMovieDetailsBinding.moviePoster);
        fragmentMovieDetailsBinding.movieName.setText(movie.getTitle());
        fragmentMovieDetailsBinding.movieYear.setText(String.format(getString(R.string.release_date), movie.getReleaseDate()));
        fragmentMovieDetailsBinding.movieRating.setText(String.format(getString(R.string.rating), String.valueOf(movie.getVoteAverage())));
        fragmentMovieDetailsBinding.movieDescription.setText(movie.getOverview());
        fragmentMovieDetailsBinding.favorite.setOnClickListener(this);
        movieDetailsPresenter.showTrailers(movie);
        movieDetailsPresenter.showReviews(movie);
    }

    @Override
    public void showTrailers(List<Video> trailers)
    {
        if (trailers.isEmpty())
        {
            fragmentMovieDetailsBinding.trailersAndReviews.trailersLabel.setVisibility(View.GONE);
            this.fragmentMovieDetailsBinding.trailersAndReviews.trailers.setVisibility(View.GONE);
            fragmentMovieDetailsBinding.trailersAndReviews.trailersContainer.setVisibility(View.GONE);

        } else
        {
            fragmentMovieDetailsBinding.trailersAndReviews.trailersLabel.setVisibility(View.VISIBLE);
            this.fragmentMovieDetailsBinding.trailersAndReviews.trailers.setVisibility(View.VISIBLE);
            fragmentMovieDetailsBinding.trailersAndReviews.trailersContainer.setVisibility(View.VISIBLE);

            this.fragmentMovieDetailsBinding.trailersAndReviews.trailers.removeAllViews();
            LayoutInflater inflater = getActivity().getLayoutInflater();
            RequestOptions options = new RequestOptions()
                    .placeholder(R.color.colorPrimary)
                    .centerCrop()
                    .override(150, 150);

            for (Video trailer : trailers)
            {
                View thumbContainer = inflater.inflate(R.layout.video, this.fragmentMovieDetailsBinding.trailersAndReviews.trailers, false);
                ImageView thumbView = ButterKnife.findById(thumbContainer, R.id.video_thumb);
                thumbView.setTag(R.id.glide_tag, Video.getUrl(trailer));
                thumbView.requestLayout();
                thumbView.setOnClickListener(this);
                Glide.with(getContext())
                        .load(Video.getThumbnailUrl(trailer))
                        .apply(options)
                        .into(thumbView);
                this.fragmentMovieDetailsBinding.trailersAndReviews.trailers.addView(thumbContainer);
            }
        }
    }

    @Override
    public void showReviews(List<Review> reviews)
    {
        if (reviews.isEmpty())
        {
            this.fragmentMovieDetailsBinding.trailersAndReviews.reviewsLabel.setVisibility(View.GONE);
            fragmentMovieDetailsBinding.trailersAndReviews.reviews.setVisibility(View.GONE);
        } else
        {
            this.fragmentMovieDetailsBinding.trailersAndReviews.reviewsLabel.setVisibility(View.VISIBLE);
            fragmentMovieDetailsBinding.trailersAndReviews.reviews.setVisibility(View.VISIBLE);

            fragmentMovieDetailsBinding.trailersAndReviews.reviews.removeAllViews();
            LayoutInflater inflater = getActivity().getLayoutInflater();
            for (Review review : reviews)
            {
                ViewGroup reviewContainer = (ViewGroup) inflater.inflate(R.layout.review, fragmentMovieDetailsBinding.trailersAndReviews.reviews, false);
                TextView reviewAuthor = ButterKnife.findById(reviewContainer, R.id.review_author);
                TextView reviewContent = ButterKnife.findById(reviewContainer, R.id.review_content);
                reviewAuthor.setText(review.getAuthor());
                reviewContent.setText(review.getContent());
                reviewContent.setOnClickListener(this);
                fragmentMovieDetailsBinding.trailersAndReviews.reviews.addView(reviewContainer);
            }
        }
    }

    @Override
    public void showFavorited()
    {
        fragmentMovieDetailsBinding.favorite.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_favorite_white_24dp));
    }

    @Override
    public void showUnFavorited()
    {
        fragmentMovieDetailsBinding.favorite.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_favorite_border_white_24dp));
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.video_thumb:
                onThumbnailClick(view);

                break;

            case R.id.review_content:
                onReviewClick((TextView) view);
                break;

            case R.id.favorite:
                onFavoriteClick();
                break;

            default:
                break;
        }
    }

    private void onReviewClick(TextView view)
    {
        if (view.getMaxLines() == 5)
        {
            view.setMaxLines(500);
        } else
        {
            view.setMaxLines(5);
        }
    }

    private void onThumbnailClick(View view)
    {
        String videoUrl = (String) view.getTag(R.id.glide_tag);
        Intent playVideoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
        startActivity(playVideoIntent);
    }

    private void onFavoriteClick()
    {
        movieDetailsPresenter.onFavoriteClick(movie);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        movieDetailsPresenter.destroy();
        fragmentMovieDetailsBinding.unbind();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        ((BaseApplication) getActivity().getApplication()).releaseDetailsComponent();
    }
}
