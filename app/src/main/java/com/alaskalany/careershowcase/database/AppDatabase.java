package com.alaskalany.careershowcase.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.alaskalany.careershowcase.AppExecutors;
import com.alaskalany.careershowcase.database.dao.*;
import com.alaskalany.careershowcase.database.entity.ContactEntity;
import com.alaskalany.careershowcase.database.entity.EducationEntity;
import com.alaskalany.careershowcase.database.entity.SkillEntity;
import com.alaskalany.careershowcase.database.entity.WorkEntity;
import com.alaskalany.careershowcase.model.Model;

import java.util.List;

@Database(version = 3, entities = {
        ContactEntity.class, EducationEntity.class, SkillEntity.class, WorkEntity.class
})
public abstract class AppDatabase
        extends RoomDatabase {

    @VisibleForTesting
    public static final String DATABASE_NAME = "app-db";

    private static AppDatabase sInstance;

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {

        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    @NonNull
    private static AppDatabase buildDatabase(final Context context, final AppExecutors executors) {

        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                   .addCallback(new Callback() {

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
                                        insertData(database,
                                                   contactEntities,
                                                   educationEntities,
                                                   skillEntities,
                                                   workEntities);
                                        // notify that the database was created and it's ready to be used
                                        database.setDatabaseCreated();
                                    });
                       }
                   })
                   .fallbackToDestructiveMigration()
                   .build();
    }

    private static void insertData(@NonNull AppDatabase database, List<ContactEntity> contactEntities,
                                   List<EducationEntity> educationEntities, List<SkillEntity> skillEntities,
                                   List<WorkEntity> workEntities) {

        database.runInTransaction(() -> {
            insertAllEntities(contactEntities, database.contactDao());
            insertAllEntities(educationEntities, database.educationDao());
            insertAllEntities(skillEntities, database.skillDao());
            insertAllEntities(workEntities, database.workDao());
        });
    }

    private static <T extends BaseDao, L extends List<? extends Model>> void insertAllEntities(L entities, T pDao) {

        pDao.insertAll(entities);
    }

    private static void addDelay() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
    }

    public abstract WorkDao workDao();

    public abstract SkillDao skillDao();

    public abstract EducationDao educationDao();

    public abstract ContactDao contactDao();

    private void updateDatabaseCreated(@NonNull final Context context) {

        if (context.getDatabasePath(DATABASE_NAME)
                   .exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated() {

        mIsDatabaseCreated.postValue(true);
    }

    public LiveData<Boolean> getDatabaseCreated() {

        return mIsDatabaseCreated;
    }
}
