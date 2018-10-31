package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.DataRepository;
import com.alaskalany.careershowcase.database.entity.SkillEntity;

public class SkillViewModel
        extends AndroidViewModel {

    private final LiveData<SkillEntity> mObservableSkill;

    private final int mSkillId;

    public ObservableField<SkillEntity> skill = new ObservableField<>();

    public SkillViewModel(@NonNull Application application, DataRepository dataRepository, final int skillId) {

        super(application);
        mSkillId = skillId;
        mObservableSkill = dataRepository.load(skillId);
    }

    public LiveData<SkillEntity> getObservableSkill() {

        return mObservableSkill;
    }

    public void setSkill(SkillEntity skill) {

        this.skill.set(skill);
    }

    /**
     * A creator is used to inject the product ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the product ID can be passed in a public method.
     */
    public static class Factory
            extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int mSkillId;

        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int skillId) {

            mApplication = application;
            mSkillId = skillId;
            mRepository = ((CareerShowcaseApp) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new SkillViewModel(mApplication, mRepository, mSkillId);
        }
    }
}
