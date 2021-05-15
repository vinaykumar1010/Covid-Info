Source Files

Activites 
- MainActivity.java
- NewsActivity.java
...


Data models
- UsefulLink.java


Adapters
- UserfulLinksListAdater

Layouts
- activity layouts contains list view etc. 
- List view cell layouts used by adapter


LOGIC TO FETCH DATA FROM FIREBASE FIRESTORE AND DISPLAY IN A LIST VIEW IN NEWS ACTIVITY.
Step 1 : Create an activity with list view layout. Here in this case we added list view in News activity. 

Step 2 : Create a data model. This depends on what all values  your data will have. For news, UserfulLink is out data model

Step 3: Add firebase integration. For this 
    1. We have added firebase packages in build.gradle files in both root and app folder.
    2. Added code in FireBaseManager.java to connect to firebase firestore and fetch a collection 
    3. Parse firebase data and create an arraylist of type Useful links which we will be using to display in our activity.  

Step 4: Now we need to show this data. To display data in ListView we use Adapter. 
- For news we have UserfulLinksListAdapter. 
- Adapter takes data and view and using this we write logic to display that data in that view. 

 

 