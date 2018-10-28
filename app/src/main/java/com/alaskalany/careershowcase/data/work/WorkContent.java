package com.alaskalany.careershowcase.data.work;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class WorkContent {

    /**
     * An array of sample (work) items.
     */
    public static final List<WorkItem> ITEMS = new ArrayList<>();
    /**
     * A map of sample (work) items, by ID.
     */
    @SuppressWarnings("WeakerAccess")
    public static final Map<String, WorkItem> ITEM_MAP = new HashMap<>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createWorkItem(i));
        }
    }

    private static void addItem(WorkItem item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    @NonNull
    private static WorkItem createWorkItem(int position) {

        return new WorkItem(String.valueOf(position), "Item " + position, makeDetails(position));
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
