package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.repository.DataRepository;

public class SkillViewModel
        extends AndroidViewModel {

    private final LiveData<SkillEntity> observableSkill;

    private final int skillId;

    public ObservableField<SkillEntity> skill = new ObservableField<>();

    public SkillViewModel(@NonNull Application application, DataRepository dataRepository, final int skillId) {

        super(application);
        this.skillId = skillId;
        observableSkill = dataRepository.skillRepository.load(skillId);
    }

    public LiveData<SkillEntity> getObservableSkill() {

        return observableSkill;
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
