## Project Overview

The purpose of the app is to demonstrate knowledge of model view presenter architecture as well as the use of industry standard libraries such as RxJava, Room, and Dagger. This allows for the app to have clean maintainable code. To make sure the app is functioning properly I used the Mockito library to write tests for the logic in the presenter classes.

The layout of the app is divided into fragments each displaying different information given by the API. Using MVP architecture the presenter class handles getting data from the model classes and notifies the view (or in this case the fragment) that a change has occurred and the view should be updated. By dividing these tasks between these three different classes ensures that each class is independent and loosely coupled.

#### MVP
MVP architecture is important as it creates a layer of abstraction between the view and the model. Instead of the view communicating directly with the model the presenter will be the middle man and communicate with the model and notify the view of changes. This way the view does not need to know how the model is created or where to get it from it will be provided by the presenter. The view will only be responsible for displaying the data while the presenter fetches and deals with the models.

#### Model

The model class represents the JSON data in a Java class. In this app the based on the JSON data being displayed it required a model for users, albums, photos, and posts.

#### View

The view handles updating the display to show updates to the models. In the app each fragment is a view class and receives the model data from it's respective presenter class and updates the information in the recycler view that is being displayed to the screen.

#### Presenter

The presenter classes are used to make the calls to fetch and modify(if needed) the models. Once the models and all logic is dealt with this class will notify the view of the changes.

#### Contract

The contract between the view and presenter consists of two interfaces that state what methods will be available in both the view and presenter classes. It also enforces that the view contains it's required methods as well as the presenter.

## Libraries

#### RetroFit

RetroFit is used to turn your HTTP API into a Java interface. This way you can call your API requests through Java method calls. In this project we attach the GSON converter to our retrofit instance in order to parse Json data.

#### RxJava

RxJava handles listening to the input stream  and waiting for the data to be received. Typically RetroFit API calls return a response of type Call. Instead we can use RxJava to use an observable to listen for and catch incoming data streams. For the purpose of this app the Single observable was used as it allows you to wait until you receive data once and then stops listening.

#### Dagger

Dagger is a dependency injector library for Android. This allows you to define how to create an instance of a dependency in a separate class and then inject dependencies into any class that requires it. This way classes do not need to know how to create their dependencies they are just provided through injection.

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
* [RetroFit](http://square.github.io/retrofit/)
* [RxJava](https://github.com/ReactiveX/RxAndroid)
* [Mockito](http://site.mockito.org/)
* [Picasso](http://square.github.io/picasso/)
* [Dagger](http://square.github.io/dagger/)
* [ButterKnife](http://jakewharton.github.io/butterknife/)
