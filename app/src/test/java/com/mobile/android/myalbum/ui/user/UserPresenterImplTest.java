package com.mobile.android.myalbum.ui.user;

import com.mobile.android.myalbum.database.UserEntity;
import com.mobile.android.myalbum.database.UserRepository;
import com.mobile.android.myalbum.model.user.User;
import com.mobile.android.myalbum.network.NetworkManager;

import junit.framework.TestCase;

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

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserPresenterImplTest {

    private UserPresenterImpl userPresenter;

    @Mock
    UserContract.View view;

    @Mock
    NetworkManager networkManager;

    @Mock
    UserRepository userRepository;

    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        userPresenter = new UserPresenterImpl(view, testScheduler, testScheduler, userRepository);
    }

    @Test
    public void getUsers_WhenIsSuccessful_NotifyView() {
        // Given
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(new User()));

        Single<List<UserEntity>> single = Single.just(users);

        // When
        Mockito.when(userRepository.getUsers()).thenReturn(single);
        userPresenter.getUsers();
        testScheduler.triggerActions();

        // Then
        Mockito.verify(view).displayUsers(users);
    }

    @Test
    public void getUsers_WhenIsUnsuccessful_NotifyView(){
        //Given
        Throwable error = new Throwable("Error could not get users");
        Single<List<UserEntity>> single = Single.error(error);

        //When
        Mockito.when(userRepository.getUsers()).thenReturn(single);
        userPresenter.getUsers();
        testScheduler.triggerActions();

        //Then
        Mockito.verify(view).displayError(error.getMessage());
    }
}