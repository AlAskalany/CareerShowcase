package com.alaskalany.careershowcase.data.skills;

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
public class SkillsContent {

    /**
     * An array of sample (skill) items.
     */
    public static final List<SkillItem> ITEMS = new ArrayList<>();
    /**
     * A map of sample (skill) items, by ID.
     */
    @SuppressWarnings("WeakerAccess")
    public static final Map<String, SkillItem> ITEM_MAP = new HashMap<>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSkillItem(i));
        }
    }

    private static void addItem(SkillItem item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    @NonNull
    private static SkillItem createSkillItem(int position) {

        return new SkillItem(String.valueOf(position), "Item " + position, makeDetails(position));
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
