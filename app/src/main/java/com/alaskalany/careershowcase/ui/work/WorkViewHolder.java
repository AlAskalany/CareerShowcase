package com.alaskalany.careershowcase.ui.work;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.work.Work;

public class WorkViewHolder
        extends RecyclerView.ViewHolder {

    final View mView;
    final TextView mIdView;
    final TextView mContentView;
    Work mItem;

    WorkViewHolder(View view) {

        super(view);
        mView = view;
        mIdView = view.findViewById(R.id.textView_work_title);
        mContentView = view.findViewById(R.id.textView_education_description);
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + mContentView.getText() + "'";
    }
}
