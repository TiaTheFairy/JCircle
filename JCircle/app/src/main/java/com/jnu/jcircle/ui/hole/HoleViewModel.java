package com.jnu.jcircle.ui.hole;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HoleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HoleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tree hole fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}