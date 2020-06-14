# NewsFeed
This is an app that collects data from an API in a json format and displays it on an android screen.
Libraries Used
Volley- For fetching the json data
Glide - For displaying the image from the API
RecyclerView - To help display the information
CardView - To hold the information

This project consists of four java classes , three xml layout files and some drawable files[to help add some images to the 
screen]
MainActivityclass--- Makes the API call and fetches the data then passes the data to an apdapter view
MyAdapter class ---- An adapter class , the adapter is a link between  the UI and the data source(json data). This help fill the UI component with
data. This class mainly holds the data fetched and sends it to an adapter view , then the data from the adapter is then taken
by a cardview 
NewsFrame - The class thats get the information for the adapter and displays it on a new screen using intents and extras
Recylevi class -- A model class which handles the various proprties of the data from the API and makes it easy for them to be used by the user depending on 
the information the user wants.
The xml files include, activity_main.xml-- shows home page of the newsfeed
,activity_news frame.xml , recycleview2.xml

<img width="423" alt="Screenshot 2020-06-14 at 09 56 29" src="https://user-images.githubusercontent.com/53605763/84592102-8f0fda00-ae32-11ea-8c89-e531edde5e08.png">


<img width="421" alt="Screenshot 2020-06-14 at 09 58 32" src="https://user-images.githubusercontent.com/53605763/84592173-2ecd6800-ae33-11ea-8d66-ad54f937b881.png">

![GIF-2020-06-14-13-02-55](https://user-images.githubusercontent.com/53605763/84594114-8a9dee00-ae3f-11ea-87de-a9da27c1d97d.gif)
A gif of how the newsfeed app operates

