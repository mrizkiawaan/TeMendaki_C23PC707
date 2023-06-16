# Machine Learning Path
## ML Model Objective
The idea of creating a TeMendaki machine learning model started with the problem of user confusion to find a mountain that suits their location and skill level. Therefore we created a recommendation system model that recommends mountains that users can climb based on the closest location and the user's level of expertise in climbing.

### **Recommender System**

A recommender system is software or algorithms that analyze user data, preferences, and behavior to provide personalized suggestions for articles and content. These systems are widely used by various online platforms to help users discover new products, movies, music, items, and more.

The main purpose of a recommendation system is to improve the user's experience by providing relevant and customized recommendations based on personal preferences. The system does this by using large amounts of data such as user profiles, past interactions, ratings and reviews to understand user preferences and predict future interests. 

There are two approaches in recommender system, Collaborative filtering and Content-based recommenders. Collaborative filtering is a technique used to filter items that users may like based on reactions of similar users. Search large groups to find a small group of users with similar tastes to a specific user. While content-based recommenders treat recommendation as a user-specific classification problem, learning a user's likes and dislikes classifier based on item characteristics. The system uses keywords to describe items and creates a user profile that indicates what kinds of items the user likes. 

### **Text Vectorization**

Text vectorization for a recommender system refers to the process of converting textual data into numerical representations that can be used as input for recommendation algorithms. Since recommendation systems often analyze user preferences and item attributes, text vectorization plays a crucial role in capturing the semantic meaning and relationships of textual content.

### **Tensorflow Recommender System**

TensorFlow Recommender is an open-source library built on top of TensorFlow, a popular machine learning framework. It provides a set of tools, models, and utilities specifically designed for building recommendation systems. TensorFlow Recommender aims to simplify the development of recommendation algorithms by offering a high-level API and pre-built components that can be easily integrated into recommendation pipelines.

### **Dataset**

Because it is difficult to get a dataset that fits the purpose of the model we created, we decided to create a dataset consisting of [user datasets](https://drive.google.com/file/d/1tBP4xRnYn8e2hxEVOAOeYtZUeMuh_-8t/view?usp=drive_link) and [mountain datasets](https://drive.google.com/file/d/1THCA3HO7L7i2UBMvHB0cdH4E3MdRBnWy/view?usp=drive_link) that we collected from various sources, then we combine the two datasets into one as [follows](https://drive.google.com/file/d/1WUbfBLTNOhBIyImh3-FFGRx-4Vd3kmNm/view?usp=drive_link). For the features contained in our dataset, we took references from the [Movielens dataset on tfds](https://www.tensorflow.org/datasets/catalog/movie_lens#movie_lens100k-ratings)

### **Reference**
[TensorFlow Recommenders: Quickstart](https://www.tensorflow.org/recommenders/examples/quickstart)
