package com.alaskalany.careershowcase.ui.skills;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.skills.Skill;

public class SkillViewHolder
        extends RecyclerView.ViewHolder {

    final View mView;
    final TextView mIdView;
    final TextView mContentView;
    Skill mItem;

    SkillViewHolder(View view) {

        super(view);
        mView = view;
        mIdView = view.findViewById(R.id.textView_skill_title);
        mContentView = view.findViewById(R.id.textView_skill_description);
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + mContentView.getText() + "'";
    }
}
