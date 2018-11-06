/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase.ui.skills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.GlideApp;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;
import com.alaskalany.careershowcase.entity.SkillEntity;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SkillEntity}
 *
 * <p>Adapters provide a binding from an app-specific data set to views that are displayed
 * * within a {@link RecyclerView}.</p>
 * TODO: Replace the implementation with code for your data type.
 */
public class SkillAdapter
        extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    /**
     *
     */
    private final SkillOnClickCallback skillOnClickCallback;

    /**
     *
     */
    private List<SkillEntity> skillEntities;

    /**
     * @param skillOnClickCallback Listener to clicks on Skill items
     */
    @SuppressWarnings("WeakerAccess")
    public SkillAdapter(SkillOnClickCallback skillOnClickCallback) {

        this.skillOnClickCallback = skillOnClickCallback;
    }

    /**
     * Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(RecyclerView.ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     *
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(RecyclerView.ViewHolder, int)
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentSkillBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                               R.layout.fragment_skill,
                                                               parent,
                                                               false);
        binding.setSkillOnClickCallback(skillOnClickCallback);
        return new ViewHolder(binding);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link RecyclerView.ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link android.widget.ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link RecyclerView.ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * Override {@link #onBindViewHolder(RecyclerView.ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.binding.setSkill(skillEntities.get(position));

        holder.binding.setSkillOnClickCallback(skillOnClickCallback);
        View rootView = holder.binding.getRoot();
        GlideApp.with(rootView)
                .load(skillEntities.get(position)
                                   .getLogoUrl())
                .into(holder.binding.imageViewSkillLogo);
        holder.binding.executePendingBindings();
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {

        return skillEntities == null ? 0 : skillEntities.size();
    }

    void setSkillList(final List<SkillEntity> skillList) {

        if (skillEntities == null) {
            skillEntities = skillList;
            notifyItemRangeInserted(0, skillList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                /**
                 * Returns the size of the old list.
                 *
                 * @return The size of the old list.
                 */
                @Override
                public int getOldListSize() {

                    return skillEntities.size();
                }

                /**
                 * Returns the size of the new list.
                 *
                 * @return The size of the new list.
                 */
                @Override
                public int getNewListSize() {

                    return skillList.size();
                }

                /**
                 * Called by the DiffUtil to decide whether two object represent the same Item.
                 * <p>
                 * For example, if your items have unique ids, this method should check their id equality.
                 *
                 * @param oldItemPosition The position of the item in the old list
                 * @param newItemPosition The position of the item in the new list
                 * @return True if the two items represent the same object or false if they are different.
                 */
                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return skillEntities.get(oldItemPosition)
                                        .getId() == skillList.get(newItemPosition)
                                                             .getId();
                }

                /**
                 * Called by the DiffUtil when it wants to check whether two items have the same data.
                 * DiffUtil uses this information to detect if the contents of an item has changed.
                 * <p>
                 * DiffUtil uses this method to check equality instead of {@link Object#equals(Object)}
                 * so that you can change its behavior depending on your UI.
                 * For example, if you are using DiffUtil with a
                 * {@link RecyclerView.Adapter RecyclerView.Adapter}, you should
                 * return whether the items' visual representations are the same.
                 * <p>
                 * This method is called only if {@link #areItemsTheSame(int, int)} returns
                 * {@code true} for these items.
                 *
                 * @param oldItemPosition The position of the item in the old list
                 * @param newItemPosition The position of the item in the new list which replaces the
                 *                        oldItem
                 * @return True if the contents of the items are the same or false if they are different.
                 */
                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    SkillEntity newSkill = skillList.get(newItemPosition);
                    SkillEntity oldSkill = skillEntities.get(oldItemPosition);
                    return newSkill.getId() == oldSkill.getId() &&
                           Objects.equals(newSkill.getTitle(), oldSkill.getTitle()) &&
                           newSkill.getLevel() == oldSkill.getLevel();
                }
            });
            skillEntities = skillList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     *
     * <p>{@link RecyclerView.Adapter} implementations should subclass ViewHolder and add fields for caching
     * potentially expensive {@link View#findViewById(int)} results.</p>
     *
     * <p>While {@link RecyclerView.LayoutParams} belong to the {@link RecyclerView.LayoutManager},
     * {@link RecyclerView.ViewHolder ViewHolders} belong to the adapter. Adapters should feel free to use
     * their own custom ViewHolder implementations to store data that makes binding view contents
     * easier. Implementations should assume that individual item views will hold strong references
     * to <code>ViewHolder</code> objects and that <code>RecyclerView</code> instances may hold
     * strong references to extra off-screen item views for caching purposes</p>
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentSkillBinding binding;

        /**
         * @param binding binding for the FragmentSkill layout
         */
        ViewHolder(@NonNull FragmentSkillBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
