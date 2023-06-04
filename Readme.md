# TeMendaki_C23PC707
## Team Profile

Team ID : C23-PC707

Team member :
|Student ID|Name|University|Role|
|---|---|---|---|
|A304DSX1037|Mochammad Adhi Buchori|Universitas Pembangunan Nasional Veteran Jakarta|Mobile Development|
|M038DSY0406|Deva Septi Wulandari Utomo|Institut Teknologi Sepuluh Nopember|Machine Learning|
|M169DSY3554|Nadia Dyfa Larasati|Universitas Gadjah Mada|Machine Learning|
|M360DSX2826|Muhammad Mirza Rizkiawan|Universitas Telkom|Machine Learning|
|C181DSX0653|Lee Klein Sinaga|Universitas Indonesia|Cloud Computing|
|C204DSX4898|Muhamad Faiz|Universitas Islam Riau|Cloud Computing|

## Project Title : TeMendaki

## Executive Summary/Abstract:
TeMendaki is a type of open trip platform that enables individuals to join group tours with strangers rather than traveling alone on a hiking trip. TeMendaki provides a range of features to users, including the ability to search for and book open trips, join existing tours, and also articles to educate the newbie hikers before going hiking.

As open trip services increase, the risk of scam also increases. Nowadays, everyone can easily build an open trip service instagram account with a very low price to bait the newbie hikers. This scam could lead to fatal risks. Take a look back at the viral news about the Rinjani Open Trip scam in January 2022. This is not only risking the hikers' lives, but also tarnishing Indonesia tourism image.

TeMendaki plans to tackle this main issue by facilitating the curated local tour guide to organize a proper open trip. End users (especially newbie hikers) could be benefited with the trusted hiking open trip, because TeMendaki already ensured the trip itinerary is well planned and executed properly with a standard operating procedure.

With this concept, both the local tour guide and hikers would be aided. The local tour guide will not spend any additional money to market their services, while the end users (hikers) are provided with various trusted open trip options. Additionally, this open trip allows users to meet new people from different backgrounds and cultures.

# Cloud Computing Path

Creating **RESTful APIs** and deploying to [Google Cloud Platform](https://cloud.google.com) by using [Google App Engine](https://cloud.google.com/appengine) for communication between **Machine Learning Recommendation System Model** and **Mobile Development**. Using [Cloud Function](https://cloud.google.com/functions) and Creating database in [Cloud SQL](https://cloud.google.com/sql).

# RESTful APIs

In making the **RESTful APIs** we use [Javascript] (https://www.w3schools.com/js/) using the [ExpressJs Framework](https://expressjs.com/) and for responses using **JSON** format. For each URL that can be used will be explained below.

## Mountaineering List

In this section there is a list of all climbing destinations that can be filtered by climbing ID, name, height, city, province, image link, description, price, ticket stock, available tickets, duration and rating. Responses from each URL use **JSON** format.

**Base URL :**

> https://backend-dot-temendaki-test.et.r.appspot.com

**Path :**

> /gunung

**Method :**

> 'GET'

- **Show Mountaineering List**
  > https://backend-dot-temendaki-test.et.r.appspot.com/gunung

```json
{
        "id": 1,
        "name": "Pendakian Gunung Arjuno",
        "height": 3339,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Arjuno merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Biasanya gunung ini dicapai dari tiga titik pendakian yang cukup dikenal yaitu dari Lawang, Tretes dan Batu. Nama Arjuno berasal dari salah satu tokoh pewayangan Mahabharata, Arjuna.",
        "price": 647948,
        "stock_ticket": 11,
        "avaibility": "8",
        "duration": "2 Hari 4 Malam",
        "rating": "1,7"
}
```

<br>

- **Show Mountaineering List by id**
  > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/:id
  
  **Required**
  
  > id = [integer]

  **Example request**
  
  > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/8
```json
{
    "id": 8,
    "name": "Pendakian Gunung Kawi",
    "height": 2551,
    "city": "Malang",
    "province": "Jawa Timur",
    "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
    "description": "Gunung kawi memiliki banyak sebutan diantaranya Gunung Putri Tidur, karena jika di pandang dari sisi sebelah timur tepatnya dari arah Kota Malang dan sisi barat dari Kota kesamben, Wlingi Blitar, Gunung Kawi terlihat seperti wanita yang sedang tidur lengkap dengan kepala berada di sebelah selatan sampai dada dan kaki yang menjuntai kearah utara. Gunung ini cukup dikenal karena adanya tempat ziarah Pesarean Gunung Kawi",
    "price": 288123,
    "stock_ticket": 21,
    "avaibility": "4",
    "duration": "3 Hari 3 Malam",
    "rating": "5,4"
}
```

<br>

- **Show Mountaineering List search by name**
  > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/search/name?name={name}
  
   **Required**
   
   > name = [string]

   **Example request**
   
   > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/search/name?name=Pendakian Gunung Bromo

 ```json
 {
    "id": 3,
    "name": "Pendakian Gunung Bromo",
    "height": 2392,
    "city": "Probolinggo",
    "province": "Jawa Timur",
    "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
    "description": "Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru. Bagi penduduk sekitar Gunung Bromo, suku Tengger, Gunung Bromo/Gunung Brahma dipercaya sebagai gunung suci. Setiap setahun sekali masyarakat Tengger mengadakan upacara Yadnya Kasada atau Kasodo. Upacara ini bertempat di sebuah pura yang berada di bawah kaki Gunung Bromo dan dilanjutkan ke puncak Bromo.",
    "price": 415445,
    "stock_ticket": 14,
    "avaibility": "11",
    "duration": "1 Hari 3 Malam",
    "rating": "4,3"
}
```

<br>

- **Show Mountaineering List search by city**
  > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/search/city?city={city}
  
   **Required**
   
   > city = [string]
   
   **Example request**
   
   > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/search/city?city=malang
```json
[
  {
        "id": 1,
        "name": "Pendakian Gunung Arjuno",
        "height": 3339,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Arjuno merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Biasanya gunung ini dicapai dari tiga titik pendakian yang cukup dikenal yaitu dari Lawang, Tretes dan Batu. Nama Arjuno berasal dari salah satu tokoh pewayangan Mahabharata, Arjuna.",
        "price": 647948,
        "stock_ticket": 11,
        "avaibility": "8",
        "duration": "2 Hari 4 Malam",
        "rating": "1,7"
    },
    {
        "id": 8,
        "name": "Pendakian Gunung Kawi",
        "height": 2551,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung kawi memiliki banyak sebutan diantaranya Gunung Putri Tidur, karena jika di pandang dari sisi sebelah timur tepatnya dari arah Kota Malang dan sisi barat dari Kota kesamben, Wlingi Blitar, Gunung Kawi terlihat seperti wanita yang sedang tidur lengkap dengan kepala berada di sebelah selatan sampai dada dan kaki yang menjuntai kearah utara. Gunung ini cukup dikenal karena adanya tempat ziarah Pesarean Gunung Kawi",
        "price": 288123,
        "stock_ticket": 21,
        "avaibility": "4",
        "duration": "3 Hari 3 Malam",
        "rating": "5,4"
    },
    {
        "id": 12,
        "name": "Pendakian Gunung Lambu",
        "height": 2327,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem.",
        "price": 877016,
        "stock_ticket": 8,
        "avaibility": "3",
        "duration": "4 Hari 4 Malam",
        "rating": "5,1"
    }
]
```

<br>

- **Show Mountaineering List search by province**
  > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/search/province?province={province}
  
   **Required**
   
   > province = [string]
   
   **Example request**
   
   > https://backend-dot-temendaki-test.et.r.appspot.com/gunung/search/province?province=jawa timur
```json
[
  {
        "id": 1,
        "name": "Pendakian Gunung Arjuno",
        "height": 3339,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Arjuno merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Biasanya gunung ini dicapai dari tiga titik pendakian yang cukup dikenal yaitu dari Lawang, Tretes dan Batu. Nama Arjuno berasal dari salah satu tokoh pewayangan Mahabharata, Arjuna.",
        "price": 647948,
        "stock_ticket": 11,
        "avaibility": "8",
        "duration": "2 Hari 4 Malam",
        "rating": "1,7"
    },
    {
        "id": 2,
        "name": "Pendakian Gunung Argopuro",
        "height": 3088,
        "city": "Bondowoso",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Argapura merupakan bekas gunung berapi yang kini sudah tidak aktif lagi. Puncak Gunung Argapura adalah titik tertinggi di Pegunungan Iyang. Gunung Argopuro dikenal sebagai salah satu tujuan pendakian dengan trek terpanjang di Pulau Jawa yaitu sepanjang 40 kilometer.",
        "price": 810844,
        "stock_ticket": 16,
        "avaibility": "13",
        "duration": "1 Hari 2 Malam",
        "rating": "5,2"
    },
    {
        "id": 3,
        "name": "Pendakian Gunung Bromo",
        "height": 2392,
        "city": "Probolinggo",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru. Bagi penduduk sekitar Gunung Bromo, suku Tengger, Gunung Bromo/Gunung Brahma dipercaya sebagai gunung suci. Setiap setahun sekali masyarakat Tengger mengadakan upacara Yadnya Kasada atau Kasodo. Upacara ini bertempat di sebuah pura yang berada di bawah kaki Gunung Bromo dan dilanjutkan ke puncak Bromo.",
        "price": 415445,
        "stock_ticket": 14,
        "avaibility": "11",
        "duration": "1 Hari 3 Malam",
        "rating": "4,3"
    },
    {
        "id": 4,
        "name": "Pendakian Gunung Butak",
        "height": 2868,
        "city": "Tulungagung",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Butak adalah gunung stratovolcano yang terletak di perbatasan Kabupaten Malang dan Kabupaten Blitar, Jawa Timur, Indonesia. Nama “Butak” di dalam padanan nama Gunung Butak berarti sabana yang mengalami kekeringan saat musim kemarau tiba.",
        "price": 514791,
        "stock_ticket": 11,
        "avaibility": "6",
        "duration": "2 Hari 1 Malam",
        "rating": "0,5"
    },
    {
        "id": 5,
        "name": "Pendakian Gunung Cemoro Sewu",
        "height": 3339,
        "city": "Lumajang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lokasi basecamp Cemoro Sewu berada di Jl. Raya Sarangan, Sampe, Ngancar, Kec. Plaosan, Kabupaten Magetan. Dalam kondisi normal, waktu tempuh pendakian ke puncak Lawu via Cemoro Sewu sekitar 2-3 hari. Sebagian besar jalurnya terbuat dari batu sehingga relatif aman mendaki di musim apa pun, baik kemarau maupun hujan.",
        "price": 231287,
        "stock_ticket": 31,
        "avaibility": "11",
        "duration": "5 Hari 5 Malam",
        "rating": "2,3"
    },
    {
        "id": 6,
        "name": "Pendakian Gunung Egon",
        "height": 1703,
        "city": "Kediri",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "",
        "price": 303633,
        "stock_ticket": 24,
        "avaibility": "2",
        "duration": "2 Hari 2 Malam",
        "rating": "0,5"
    },
]
```

<br>
