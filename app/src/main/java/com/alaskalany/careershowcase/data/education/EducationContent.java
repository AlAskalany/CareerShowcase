package com.alaskalany.careershowcase.data.education;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.alaskalany.careershowcase.model.Education;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample description for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class EducationContent {

    /**
     * An array of sample (education) items.
     */
    public static final List<Education> ITEMS = new ArrayList<>();
    /**
     * A map of sample (education) items, by ID.
     */
    @SuppressWarnings("WeakerAccess")
    public static final SparseArray<Education> ITEM_MAP = new SparseArray<>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createEducationItem(i));
        }
    }

    private static void addItem(Education item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    @NonNull
    private static Education createEducationItem(int position) {

        Education education = new EducationEntity();
        education.setId(position);
        education.setTitle("EducationEntity " + position);
        education.setDescription(makeDetails(position));
        return education;
    }

    @NonNull
    private static String makeDetails(int position) {

        StringBuilder builder = new StringBuilder();
        builder.append("Details about EducationEntity: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
