package com.alaskalany.careershowcase.ui.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.GlideApp;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentContactBinding;
import com.alaskalany.careershowcase.entity.ContactEntity;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ContactEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class ContactAdapter
        extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    /**
     *
     */
    protected final ContactOnClickCallback contactOnClickCallback;

    /**
     *
     */
    protected List<ContactEntity> contactEntities;

    /**
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public ContactAdapter(ContactOnClickCallback callback) {

        this.contactOnClickCallback = callback;
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentContactBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.fragment_contact,
                parent,
                false);
        binding.setContactOnClickCallback(contactOnClickCallback);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.binding.setContact(contactEntities.get(position));

        holder.binding.setContactOnClickCallback(contactOnClickCallback);
        View rootView = holder.binding.getRoot();
        GlideApp.with(rootView).load(contactEntities.get(position).getLogoUrl()).into(holder.binding.imageViewContactLogo);
        holder.binding.executePendingBindings();
    }

    public void setContactList(final List<ContactEntity> contactList) {

        if (contactEntities == null) {
            contactEntities = contactList;
            notifyItemRangeInserted(0, contactList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return contactEntities.size();
                }

                @Override
                public int getNewListSize() {

                    return contactList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return contactEntities.get(oldItemPosition).getId() == contactList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    ContactEntity newContact = contactList.get(newItemPosition);
                    ContactEntity oldContact = contactEntities.get(oldItemPosition);
                    boolean isIdEqual = newContact.getId() == oldContact.getId();
                    boolean isDescriptionEqual =
                            Objects.equals(newContact.getDescription(), oldContact.getDescription());
                    boolean isTitleEqual = Objects.equals(newContact.getTitle(), oldContact.getTitle());
                    return isIdEqual && isDescriptionEqual && isTitleEqual;
                }
            });
            contactEntities = contactList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return contactEntities == null ? 0 : contactEntities.size();
    }

    /**
     *
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentContactBinding binding;

        /**
         * @param binding
         */
        public ViewHolder(FragmentContactBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
