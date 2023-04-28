# Assignment
This project is a SpringBoot Java server that integrates the Twitter API and exposes RESTful APIs for searching tweets and getting tweets of a selected user.

To achieve this, the project uses the Twitter4j library, which is a Java wrapper around the Twitter API. It allows us to easily interact with the Twitter API from our Java application.

The project implements two RESTful APIs:

search-tweets: This API allows the user to search for tweets containing a specific keyword. The user provides the keyword as a query parameter, and the server returns a JSON response containing the matching tweets. This API uses the Twitter.search() method to search for tweets containing the specified keyword.

get-tweets: This API allows the user to retrieve the recent tweets of a specific Twitter user. The user provides the Twitter screen name of the user as a query parameter, and the server returns a JSON response containing the recent tweets of that user. This API uses the Twitter.getUserTimeline() method to retrieve the recent tweets of the specified user.

The project also implements header-based authentication, which requires the client to provide a random client id and secret in the request header. This ensures that only authorized clients can access the APIs.

To set up the project, we first created a new SpringBoot project and added the necessary dependencies to the pom.xml file. We then created a Twitter Developer account and obtained the necessary API credentials (consumer key and secret, and access token and secret). We used these credentials to configure the Twitter4j library in our application.

We also created a SecurityConfig class that configures header-based authentication, and a TwitterController class that implements the RESTful APIs. The TwitterController class uses the TwitterConfig class to obtain the Twitter API credentials, and the Twitter4j library to interact with the Twitter API.

Overall, this project provides a simple way to integrate the Twitter API with a Java application, and to expose RESTful APIs for searching and retrieving tweets.
