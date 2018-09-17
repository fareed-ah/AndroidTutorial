package com.mobile.android.myalbum.ui.album;

import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.network.NetworkManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

@RunWith(MockitoJUnitRunner.class)
public class AlbumPresenterImplTest {

    private AlbumPresenterImpl presenter;

    @Mock
    AlbumContract.View view;

    @Mock
    NetworkManager networkManager;

    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        presenter = new AlbumPresenterImpl(view, networkManager, testScheduler, testScheduler);
    }

    @Test
    public void getAlbums_WhenIsSuccessful_ShouldNotifyView() {
        // Given
        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album(1, "My Album"));

        Single<List<Album>> albums = Single.just(albumList);

        // When
        Mockito.when(networkManager.getAlbums()).thenReturn(albums);
        presenter.getAlbums();
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayAlbums(albumList);
    }

    @Test
    public void getAlbums_WhenUnsuccessful_ShouldNotifyView() {
        // Given
        Throwable error = new Throwable("error");
        Single<List<Album>> albums = Single.error(error);

        // When
        Mockito.when(networkManager.getAlbums()).thenReturn(albums);
        presenter.getAlbums();
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayError("error");
    }
}