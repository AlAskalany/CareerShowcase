package com.alaskalany.careershowcase.ui.skills;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.dummy.DummyItem;

public class SkillViewHolder
        extends RecyclerView.ViewHolder {

    final View mView;
    final TextView mIdView;
    final TextView mContentView;
    DummyItem mItem;

    SkillViewHolder(View view) {

        super(view);
        mView = view;
        mIdView = view.findViewById(R.id.item_number);
        mContentView = view.findViewById(R.id.content);
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + mContentView.getText() + "'";
    }
}
