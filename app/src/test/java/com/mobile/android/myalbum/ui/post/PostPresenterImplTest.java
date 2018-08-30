package com.mobile.android.myalbum.ui.post;

import com.mobile.android.myalbum.model.post.Post;
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
public class PostPresenterImplTest {

    private PostContract.Presenter presenter;

    @Mock
    NetworkManager networkManager;

    @Mock
    PostContract.View view;

    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        presenter = new PostPresenterImpl(view, networkManager, testScheduler, testScheduler);
    }

    @Test
    public void getPosts_WhenIsSuccessful_NotifyView() {

        // Given
        List<Post> postList = new ArrayList<>();
        Single<List<Post>> single = Single.just(postList);

        // When
        Mockito.when(networkManager.getPosts()).thenReturn(single);
        presenter.getPosts();
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayPosts(postList);
    }

    @Test
    public void getPosts_WhenIsUnsuccessful_NotifyView() {
        // Given
        Throwable error = new Throwable("Could not fetch posts");
        Single<List<Post>> single = Single.error(error);

        // When
        Mockito.when(networkManager.getPosts()).thenReturn(single);
        presenter.getPosts();
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayError(error.getMessage());
    }
}