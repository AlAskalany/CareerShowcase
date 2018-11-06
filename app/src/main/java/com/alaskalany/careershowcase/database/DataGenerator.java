package com.alaskalany.careershowcase.database;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.alaskalany.careershowcase.entity.ContactEntity;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.entity.WorkEntity;
import org.jetbrains.annotations.Contract;

import java.util.*;

public class DataGenerator {

    @NonNull
    @Contract(pure = true)
    public static List<ContactEntity> generateContacts() {

        return ContactContent.ITEMS;
    }

    @NonNull
    @Contract(pure = true)
    public static List<EducationEntity> generateEducations() {

        return EducationContent.ITEMS;
    }

    @NonNull
    @Contract(pure = true)
    public static List<SkillEntity> generateSkills() {

        return SkillContent.ITEMS;
    }

    @NonNull
    @Contract(pure = true)
    public static List<WorkEntity> generateWorks() {

        return WorkContent.ITEMS;
    }

    /**
     * Helper class for providing sample description for user interfaces created by
     * Android template wizards.
     * <p>
     * TODO: Replace all uses of this class before publishing your app.
     */
    public static class ContactContent {

        /**
         * An array of sample (contact) items.
         */
        public static final List<ContactEntity> ITEMS = new ArrayList<>();

        /**
         * A map of sample (contact) items, by ID.
         */
        @SuppressWarnings("WeakerAccess")
        public static final Map<Integer, ContactEntity> ITEM_MAP = new HashMap<Integer, ContactEntity>();

        private static final int COUNT = 25;

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createContactItem(i));
            }
        }

        private static void addItem(ContactEntity item) {

            ITEMS.add(item);
            ITEM_MAP.put(item.getId(), item);
        }

        @NonNull
        private static ContactEntity createContactItem(int position) {

            return new ContactEntity(position, "Item " + position, makeDetails(position));
        }

        @NonNull
        private static String makeDetails(int position) {

            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ")
                    .append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore contactDetails information here.");
            }
            return builder.toString();
        }
    }

    /**
     * Helper class for providing sample description for user interfaces created by
     * Android template wizards.
     * <p>
     * TODO: Replace all uses of this class before publishing your app.
     */
    public static class EducationContent {

        /**
         * An array of sample (education) items.
         */
        public static final List<EducationEntity> ITEMS = new ArrayList<>();

        /**
         * A map of sample (education) items, by ID.
         */
        @SuppressWarnings("WeakerAccess")
        public static final SparseArray<EducationEntity> ITEM_MAP = new SparseArray<>();

        private static final int COUNT = 25;

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createEducationItem(i));
            }
        }

        private static void addItem(EducationEntity item) {

            ITEMS.add(item);
            ITEM_MAP.put(item.getId(), item);
        }

        @NonNull
        private static EducationEntity createEducationItem(int position) {

            EducationEntity educationEntity = new EducationEntity();
            educationEntity.setId(position);
            educationEntity.setTitle("Education " + position);
            educationEntity.setDescription(makeDetails(position));
            educationEntity.setInstitution("KTH Royal Institute of Technology");
            educationEntity.setLocation("Stockholm, Sweden");
            educationEntity.setDuration("2014-2019");
            return educationEntity;
        }

        @NonNull
        private static String makeDetails(int position) {

            StringBuilder builder = new StringBuilder();
            builder.append("Details about Education: ")
                    .append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore contactDetails information here.");
            }
            return builder.toString();
        }
    }

    /**
     * Helper class for providing sample description for user interfaces created by
     * Android template wizards.
     * <p>
     * TODO: Replace all uses of this class before publishing your app.
     */
    public static class SkillContent {

        /**
         * An array of sample (skill) items.
         */
        public static final List<SkillEntity> ITEMS = new ArrayList<>();

        /**
         * A map of sample (skill) items, by ID.
         */
        @SuppressWarnings("WeakerAccess")
        public static final SparseArray<SkillEntity> ITEM_MAP = new SparseArray<>();

        private static final int COUNT = 25;

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createSkillItem(i));
            }
        }

        private static void addItem(SkillEntity item) {

            ITEMS.add(item);
            ITEM_MAP.put(item.getId(), item);
        }

        @NonNull
        private static SkillEntity createSkillItem(int position) {

            SkillEntity skillEntity = new SkillEntity();
            skillEntity.setId(position);
            skillEntity.setTitle("Skill " + position);
            skillEntity.setLevel(makeLevel());
            return skillEntity;
        }

        private static int makeLevel() {

            return new Random().nextInt(5);
        }
    }

    /**
     * Helper class for providing sample description for user interfaces created by
     * Android template wizards.
     * <p>
     * TODO: Replace all uses of this class before publishing your app.
     */
    public static class WorkContent {

        /**
         * An array of sample (contact) items.
         */
        public static final List<WorkEntity> ITEMS = new ArrayList<>();

        /**
         * A map of sample (contact) items, by ID.
         */
        @SuppressWarnings("WeakerAccess")
        public static final SparseArray<WorkEntity> ITEM_MAP = new SparseArray<>();

        private static final int COUNT = 25;

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createWorkItem(i));
            }
        }

        private static void addItem(WorkEntity item) {

            ITEMS.add(item);
            ITEM_MAP.put(item.getId(), item);
        }

        @NonNull
        private static WorkEntity createWorkItem(int position) {

            WorkEntity workEntity = new WorkEntity();
            workEntity.setId(position);
            workEntity.setTitle("Work " + position);
            workEntity.setDescription(makeDetails(position));
            return workEntity;
        }

        @NonNull
        private static String makeDetails(int position) {

            StringBuilder builder = new StringBuilder();
            builder.append("Details about Work: ")
                    .append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore contactDetails information here.");
            }
            return builder.toString();
        }
    }
}
