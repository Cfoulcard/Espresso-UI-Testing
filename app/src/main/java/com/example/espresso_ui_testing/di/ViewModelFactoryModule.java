package com.example.espresso_ui_testing.di;

import androidx.lifecycle.ViewModelProvider;


import com.example.espresso_ui_testing.models.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}