##Android Design Project

The purpose of the app is to use model view presenter architecture in order to display JSON data.

The app is divided into fragments each displaying different endpoints of the API. The fragments handle displaying the view and are controlled by a presenter class. This is a good way to make sure classes are independent and have individual responsibilities. Along with fetching data and displaying it the data is also stored in a local database using Room.

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
