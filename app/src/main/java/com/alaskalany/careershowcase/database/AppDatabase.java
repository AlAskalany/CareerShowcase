package com.alaskalany.careershowcase.database;

import android.content.Context;
import android.os.AsyncTask;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.alaskalany.careershowcase.AppExecutors;
import com.alaskalany.careershowcase.database.dao.ContactDao;
import com.alaskalany.careershowcase.database.dao.EducationDao;
import com.alaskalany.careershowcase.database.dao.SkillDao;
import com.alaskalany.careershowcase.database.dao.WorkDao;
import com.alaskalany.careershowcase.entity.ContactEntity;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.entity.WorkEntity;

import java.util.List;

/**
 *
 */
@Database(version = 6, entities = {
        ContactEntity.class, EducationEntity.class, SkillEntity.class, WorkEntity.class
})
public abstract class AppDatabase
        extends RoomDatabase {

    /**
     *
     */
    @VisibleForTesting
    public static final String DATABASE_NAME = "app-db";

    /**
     *
     */
    private static AppDatabase INSTANCE;
    /**
     *
     */
    static RoomDatabase.Callback roomDatabaseCallback = new Callback() {

        /**
         * Called when the database has been opened.
         *
         * @param db The database.
         */
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {

            super.onCreate(db);
            new PopulateDatabaseAsync(INSTANCE).execute();
        }
    };
    /**
     *
     */
    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();

    /**
     * @param context
     * @param executors
     * @return
     */
    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {

        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context.getApplicationContext(), executors);
                    INSTANCE.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @param context
     * @param executors
     * @return
     */
    @NonNull
    private static AppDatabase buildDatabase(final Context context, final AppExecutors executors) {

        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {

                    /**
                     * Called when the database is created for the first time. This is called after all the
                     * tables are created.
                     *
                     * @param db The database.
                     */
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {

                        super.onCreate(db);
                        executors.diskIO()
                                .execute(() -> {
                                    // Add a delay to simulate a long-running operation
                                    addDelay();
                                    // Generate the data for pre-population
                                    AppDatabase database = AppDatabase.getInstance(context, executors);
                                    List<ContactEntity> contactEntities = DataGenerator.generateContacts();
                                    List<EducationEntity> educationEntities = DataGenerator.generateEducations();
                                    List<SkillEntity> skillEntities = DataGenerator.generateSkills();
                                    List<WorkEntity> workEntities = DataGenerator.generateWorks();
                                    database.runInTransaction(() -> {
                                        (database.contactDao()).insertAll((contactEntities));
                                        (database.educationDao()).insertAll((educationEntities));
                                        (database.skillDao()).insertAll((skillEntities));
                                        (database.workDao()).insertAll((workEntities));
                                    });
                                    // notify that the database was created and it's ready to be used
                                    database.setDatabaseCreated();
                                });
                    }
                })
                .addCallback(roomDatabaseCallback)
                .fallbackToDestructiveMigration()
                .build();
    }

    /**
     *
     */
    private static void addDelay() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * @return
     */
    public abstract WorkDao workDao();

    /**
     * @return
     */
    public abstract SkillDao skillDao();

    /**
     * @return
     */
    public abstract EducationDao educationDao();

    /**
     * @return
     */
    public abstract ContactDao contactDao();

    /**
     * @param context
     */
    private void updateDatabaseCreated(@NonNull final Context context) {

        if (context.getDatabasePath(DATABASE_NAME)
                .exists()) {
            setDatabaseCreated();
        }
    }

    /**
     *
     */
    private void setDatabaseCreated() {

        isDatabaseCreated.postValue(true);
    }

    /**
     * @return
     */
    public LiveData<Boolean> getDatabaseCreated() {

        return isDatabaseCreated;
    }

    /**
     *
     */
    private static class PopulateDatabaseAsync
            extends AsyncTask<Void, Void, ViewOutlineProvider> {

        /**
         *
         */
        private final EducationDao educationDao;

        /**
         *
         */
        private final WorkDao workDao;

        /**
         *
         */
        private final SkillDao skillDao;

        /**
         * @param pInstance
         */
        public PopulateDatabaseAsync(AppDatabase pInstance) {

            educationDao = pInstance.educationDao();
            workDao = pInstance.workDao();
            skillDao = pInstance.skillDao();
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param pVoids The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected ViewOutlineProvider doInBackground(Void... pVoids) {

            List<EducationEntity> _educationEntities = DataGenerator.EducationContent.ITEMS;
            educationDao.insertAll(_educationEntities);
            List<WorkEntity> _workEntities = DataGenerator.WorkContent.ITEMS;
            workDao.insertAll(_workEntities);
            List<SkillEntity> _skillEntities = DataGenerator.SkillContent.ITEMS;
            skillDao.insertAll(_skillEntities);
            return null;
        }
    }
}
