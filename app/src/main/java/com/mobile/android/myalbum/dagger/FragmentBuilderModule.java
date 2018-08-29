package com.mobile.android.myalbum.dagger;

import com.mobile.android.myalbum.ui.album.AlbumFragment;
import com.mobile.android.myalbum.ui.album.dagger.AlbumPresenterModule;
import com.mobile.android.myalbum.ui.photo.PhotoFragment;
import com.mobile.android.myalbum.ui.post.PostFragment;
import com.mobile.android.myalbum.ui.user.UserFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = AlbumPresenterModule.class)
    abstract AlbumFragment injectAlbumFragment();

    @ContributesAndroidInjector
    abstract PhotoFragment injectPhotoFragment();

    @ContributesAndroidInjector
    abstract PostFragment injectPostFragment();

    @ContributesAndroidInjector
    abstract UserFragment injectUserFragment();
}
