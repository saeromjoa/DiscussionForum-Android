package com.example.guest.ilovediscussing.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.guest.ilovediscussing.Constants;
import com.example.guest.ilovediscussing.R;
import com.example.guest.ilovediscussing.models.Post;
import com.example.guest.ilovediscussing.ui.PostActivity;
import com.example.guest.ilovediscussing.ui.PostDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;


public class FirebasePostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;
    private Post mPost;

    public FirebasePostViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindPost(Post post){
        mPost = post;
        TextView postTitleTextView = (TextView) mView.findViewById(R.id.postTitleTextView);
        TextView postPreviewTextView = (TextView) mView.findViewById(R.id.postPreviewTextView);
        TextView postUserTextView = (TextView) mView.findViewById(R.id.userTextView);

        postTitleTextView.setText(post.getTitle());
        postPreviewTextView.setText(post.getContent());
        postUserTextView.setText("Posted by " + post.getUserName());

    }

    @Override
    public void onClick(View view){

        Intent intent = new Intent(mContext, PostDetailActivity.class);
        intent.putExtra("post", Parcels.wrap(mPost));
        mContext.startActivity(intent);



    }

}
