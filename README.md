# Assignment

Some description regarding this assignement 

# 1. The JSON reply we are getting from API can be Checked from below link
[JSON Response from API](https://my-json-server.typicode.com/prashsb/data/db)

This dummy API is created with the help of  [my-json-server](https://my-json-server.typicode.com) this web site.

This API is called using [Retrofit library](https://square.github.io/retrofit/)

# So, What is Retrofit?
Retrofit is type-safe HTTP client for Android and Java by Square, Inc. It is an open source library which simplifies HTTP communication by turning remote APIs into declarative, type-safe interfaces. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. It automatically serializes the JSON response using a POJO which must be defined in advanced for the JSON Structure.

# Let's dive into the code now

You can see from the project structure the architecture used is MVP.

In Model Directory there are 3 Pojos 
1. [state_data](https://github.com/prashsb/Assignment/blob/master/app/src/main/java/com/winjit/assignement/model/state_data.java) where you will find the details of states fetched from server.
which contains state name, latitude, longitude, total applicants from that state, and applicants details.
2. [applicants_data](https://github.com/prashsb/Assignment/blob/master/app/src/main/java/com/winjit/assignement/model/applicants_data.java) where you will get all the detaisl of applicants like name, address, etc.
3 [applicants_data](https://github.com/prashsb/Assignment/blob/master/app/src/main/java/com/winjit/assignement/model/Rest_model.java) this pojo is used as serializer to the data from server


# Setting Up the Retrofit Interface
In Api directory Retrofit interface and end points are given to fetch the data

[applicants_data](https://github.com/prashsb/Assignment/blob/master/app/src/main/java/com/winjit/assignement/MainInterfaces.java) This This interface consists the three inner interfaces named presenter, View, Model.

presenter: This interface callbacks will be called when the view is destroyed onDestroy() and requesting the data from the server requestDataFromServer() for the first time when the activity is created.

View: The interface callback will be called when the user need to show/hide the progressbar showPregress()/hidePregress() , set data to the GoogleMap setDataToMap(…) and lastly to show the error if the network response is failed onResponseFailure(…).

Model: Intractors are built for fetching the data from the database, webservices or any other data source. This interface callback has one inner interface named onFinishedListener{..} which will be called when the webservices response in finished or the response is failure onFinished(…) and onFailure(…). And it also has another callback named getMainData(onFinishListener …) that has the onFinishListener interface as a constructor.

# DataListModel.java
This class implements the MainAcontract.GetNoticeIntractor Interface which includes the overridden methoid getMainData(). This class is responsible to get data using the rest apis using retrofit library and pass data through onFinishedListener callback.

# DataPresenter.java
This class is responsible to act as the middle man between View and Model. It retrieves data from the Model and returns it formatted to the View and it also decides what happens when you interact with the View.
This call implements the MainInterfaces.Model.OnFinishedListener, and MainInterfaces.Presenter interface which includes their overridden methods as well. And the constructor includes the two params named MainInterfaces.View and MainInterfaces.Model.
When the onDestroy method is called from the main activity, this class listen the onDestroy() callback and make the mainview to null. And When the data is fetched/received from the webservices callback in  onFinish(…) and onFailure(…) callback is called.

# MainActivity.java
This FragmentActivity contain a reference to the presenter. The only thing that the view do is to call a method from the Presenter every time there is an interface action.
In this class we implement MainInterfaces.View interface that includes its overridden methods. When the onCreate method is called and we use the presenter object to request data from the server. All the logical task are done by the MainPresenter class and pass the result to DataPresenter class and the result came through callback in MainActivity.java update the ui view.

In This Activity we have used Google map to show the number of applicants per state on map for that google map fragment is used which loads map asynchronously.

We will load the map in setDataToMap() method because, to show applicants on map we need some data therefore we are waiting to load the data.

Here to heighlight Indian states on Google map we used kml layer function of Google Map SDK. After Data get loaded we add the marker on map to respected with latitude and longitude available in data.

(Heat map is not used here because, there is no click event on heat map and another thing is I was running out of time.) When we click on marker we can see the details of applicants from that state.

