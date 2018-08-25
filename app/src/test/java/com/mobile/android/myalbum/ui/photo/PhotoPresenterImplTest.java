package com.mobile.android.myalbum.ui.photo;

import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.network.NetworkManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PhotoPresenterImplTest {

    private PhotoPresenterImpl photoPresenter;

    @Mock
    PhotoContract.View view;

    @Mock
    NetworkManager networkManager;

    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        photoPresenter = new PhotoPresenterImpl(view, networkManager, testScheduler, testScheduler);
    }

    @Test
    public void getPhotos_WhenIsSuccessful_ShouldNotifyView() {

        // Given
        List<Photo> photos = new ArrayList<Photo>();
        photos.add(new Photo(1, "https://exampleurl.com", "https://thumbnailurl.com", "PhotoTitle"));
        Single<List<Photo>> single = Single.just(photos);

        // When
        Mockito.when(networkManager.getPhotos(1)).thenReturn(single);
        photoPresenter.getPhotos(1);
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayPhotos(photos);
    }

    @Test
    public void getPhotos_WhenIsUnsuccessful_ShouldNotifyView(){

        // Given
        Throwable error = new Throwable("Could not get photos.");
        Single<List<Photo>> single = Single.error(error);

        // When
        Mockito.when(networkManager.getPhotos(1)).thenReturn(single);
        photoPresenter.getPhotos(1);
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayError(error.getMessage());

    }
}