## Project Overview

The purpose of the app is to use model view presenter architecture as well as use industry standard libraries such as RxJava, Room, and Dagger. This allows for the app to have clean maintainable code. To make sure the app is functioning properly I used the Mockito library to write tests for the logic in the presenter classes.

The layout of the app is divided into fragments each displaying different information given by the API. Using MVP architecture the presenter class handles getting data from the model classes and notifies the view (or in this case the fragment) that a change has occurred and the view should be updated. By dividing these tasks between these three different classes ensures that each class is independent and loosely coupled.

### MVP
MVP architecture is important as it creates a layer of abstraction between the view and the model. Instead of the view communicating directly with the model the presenter will be the middle man and communicate with the model and notify the view of changes. This way the view does not need to know how the model is created or where to get it from it will be provided by the presenter. The view will only be responsible for displaying the data while the presenter fetches and deals with the models.

### Model

The model class represents the JSON data in a Java class. In this app the based on the JSON data being displayed it required a model for users, albums, photos, and posts.

### Presenter

The presenter classes are used to make the calls to fetch and modify(if needed) the models. Once the models and all logic is dealt with this class will notify the view of the changes.

### View

The view handles updating the display to show updates to the models. In the app each fragment is a view class and receives the model data from it's respective presenter class and updates the information in the recycler view that is being displayed to the screen.

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
