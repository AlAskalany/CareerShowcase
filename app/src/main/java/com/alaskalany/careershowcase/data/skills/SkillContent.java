package com.alaskalany.careershowcase.data.skills;

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
public class SkillContent {

    /**
     * An array of sample (skill) items.
     */
    public static final List<Skill> ITEMS = new ArrayList<>();
    /**
     * A map of sample (skill) items, by ID.
     */
    @SuppressWarnings("WeakerAccess")
    public static final SparseArray<Skill> ITEM_MAP = new SparseArray<>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSkillItem(i));
        }
    }

    private static void addItem(Skill item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    @NonNull
    private static Skill createSkillItem(int position) {

        Skill skill = new Skill();
        skill.setId(position);
        skill.setLabel("Item " + position);
        skill.setDetails(makeDetails(position));
        return skill;
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
