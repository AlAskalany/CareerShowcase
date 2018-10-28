package com.alaskalany.careershowcase.data.work;

import android.util.SparseArray;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample description for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class WorkContent {

    /**
     * An array of sample (work) items.
     */
    public static final List<Work> ITEMS = new ArrayList<>();
    /**
     * A map of sample (work) items, by ID.
     */
    @SuppressWarnings("WeakerAccess")
    public static final SparseArray<Work> ITEM_MAP = new SparseArray<>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createWorkItem(i));
        }
    }

    private static void addItem(Work item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    @NonNull
    private static Work createWorkItem(int position) {

        Work work = new Work();
        work.setId(position);
        work.setTitle("Item " + position);
        work.setDescription(makeDetails(position));
        return work;
    }

    @NonNull
    private static String makeDetails(int position) {

        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
