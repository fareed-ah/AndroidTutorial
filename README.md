## Android Design Project

The purpose of the app is to use model view presenter architecture as well as use industry standard libraries such as RxJava, Room, and Dagger. This allows for the app to have clean maintainable code. To make sure the app is functioning properly I used the Mockito library to write tests for the logic in presenter classes.

The layout of the app is divided into fragments each displaying different information given by the API. Using MVP architecture the presenter class handles getting data from the model classes and notifies the view (or in this case the fragment) that a change has occurred and the view should be updated. By dividing these tasks between these three different classes ensures that each class is independent and loosely coupled. 

## Installing

Get a copy of Android Studio from:
```
https://developer.android.com/studio/
```
Follow this tutorial to create a working emulator
```
https://developer.android.com/studio/run/managing-avds
```
Or follow this guide to run the app on an Android phone
```
https://developer.android.com/studio/run/device
```
## Built Using
* [RetroFit](http://square.github.io/retrofit/) - Used to make http request
* [RxJava](https://github.com/ReactiveX/RxAndroid) - Used to receive API response as observable.
* [Mockito](http://site.mockito.org/) - Test classes
* [Picasso](http://square.github.io/picasso/) - Used to load images
* [Dagger](http://square.github.io/dagger/) - Dependency Injection
* [ButterKnife](http://jakewharton.github.io/butterknife/) - View binding
