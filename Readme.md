# Cloud Computing Path

Creating **RESTful APIs** and deploying to [Google Cloud Platform](https://cloud.google.com) by using [Google App Engine](https://cloud.google.com/appengine) for communication between **Machine Learning Recommendation System Model** and **Mobile Development**. Using [Cloud Compute Engine](https://cloud.google.com/compute) and Creating database in [Cloud SQL](https://cloud.google.com/sql). Using Google Cloud Firebase [Cloud Compute Engine](https://firebase.google.com) for the authentication system. 

Region: asia-southeast2
Zone: Jakarta

# RESTful APIs

In making the **RESTful APIs** we use [Javascript](https://www.w3schools.com/js/) using the [ExpressJs Framework](https://expressjs.com/) and for responses using **JSON** format. For each URL that can be used will be explained below.

## Mountaineering List

In this section there is a list of all climbing destinations that can be filtered by climbing ID, name, height, city, province, image link, description, price, ticket stock, available tickets, duration and rating. Responses from each URL use **JSON** format.

**Base URL :**

> https://backend-dot-temendaki-test.et.r.appspot.com

**Path :**

> /pendakian

**Method :**

> 'GET'

- **Show Mountaineering List**
  > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian

```json
[
  {
        "id_climb": 1,
        "climb_name": "Pendakian Gunung Arjuno",
        "height": 3339,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Arjuno merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Biasanya gunung ini dicapai dari tiga titik pendakian yang cukup dikenal yaitu dari Lawang, Tretes dan Batu. Nama Arjuno berasal dari salah satu tokoh pewayangan Mahabharata, Arjuna.",
        "price": 735065,
        "stock_tickets": 8,
        "sold_tickets": "3",
        "duration": "5 Hari 3 Malam",
        "rating": "4,1"
    },
    {
        "id_climb": 2,
        "climb_name": "Pendakian Gunung Argopuro",
        "height": 3088,
        "city": "Bondowoso",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Argapura merupakan bekas gunung berapi yang kini sudah tidak aktif lagi. Puncak Gunung Argapura adalah titik tertinggi di Pegunungan Iyang. Gunung Argopuro dikenal sebagai salah satu tujuan pendakian dengan trek terpanjang di Pulau Jawa yaitu sepanjang 40 kilometer.",
        "price": 486772,
        "stock_tickets": 49,
        "sold_tickets": "29",
        "duration": "5 Hari 3 Malam",
        "rating": "0,3"
    },
    {
        "id_climb": 3,
        "climb_name": "Pendakian Gunung Bromo",
        "height": 2392,
        "city": "Probolinggo",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru. Bagi penduduk sekitar Gunung Bromo, suku Tengger, Gunung Bromo/Gunung Brahma dipercaya sebagai gunung suci. Setiap setahun sekali masyarakat Tengger mengadakan upacara Yadnya Kasada atau Kasodo. Upacara ini bertempat di sebuah pura yang berada di bawah kaki Gunung Bromo dan dilanjutkan ke puncak Bromo.",
        "price": 399585,
        "stock_tickets": 10,
        "sold_tickets": "9",
        "duration": "3 Hari 3 Malam",
        "rating": "5,4"
    },
    {
        "id_climb": 4,
        "climb_name": "Pendakian Gunung Butak",
        "height": 2868,
        "city": "Tulungagung",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Butak adalah gunung stratovolcano yang terletak di perbatasan Kabupaten Malang dan Kabupaten Blitar, Jawa Timur, Indonesia. Nama “Butak” di dalam padanan nama Gunung Butak berarti sabana yang mengalami kekeringan saat musim kemarau tiba.",
        "price": 903640,
        "stock_tickets": 38,
        "sold_tickets": "38",
        "duration": "5 Hari 4 Malam",
        "rating": "0,0"
    },
    {
        "id_climb": 5,
        "climb_name": "Pendakian Gunung Cemoro Sewu",
        "height": 3339,
        "city": "Lumajang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lokasi basecamp Cemoro Sewu berada di Jl. Raya Sarangan, Sampe, Ngancar, Kec. Plaosan, Kabupaten Magetan. Dalam kondisi normal, waktu tempuh pendakian ke puncak Lawu via Cemoro Sewu sekitar 2-3 hari. Sebagian besar jalurnya terbuat dari batu sehingga relatif aman mendaki di musim apa pun, baik kemarau maupun hujan.",
        "price": 307908,
        "stock_tickets": 13,
        "sold_tickets": "4",
        "duration": "2 Hari 5 Malam",
        "rating": "3,0"
    },
    {
        "id_climb": 6,
        "climb_name": "Pendakian Gunung Egon",
        "height": 1703,
        "city": "Kediri",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "",
        "price": 534732,
        "stock_tickets": 48,
        "sold_tickets": "37",
        "duration": "1 Hari 4 Malam",
        "rating": "4,2"
    },
    {
        "id_climb": 7,
        "climb_name": "Pendakian Gunung Ijen",
        "height": 2799,
        "city": "Banyuwangi",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Salah satu fenomena alam yang paling terkenal dari Gunung Ijen adalah blue fire (api biru) di dalam kawah yang terletak di puncak gunung tersebut. Pendakian gunung ini bisa dimulai dari dua tempat, yakni dari Banyuwangi atau dari Bondowoso. Kawah Ijen adalah sebuah danau kawah yang bersifat asam yang berada di puncak Gunung Ijen dengan kedalaman danau 200 meter dan luas kawah mencapai 5.466 Hektar. Danau kawah Ijen dikenal merupakan danau air asam kuat terbesar di dunia. Blue fire hanya dapat dilihat oleh mata manusia saat tidak ada cahaya, karenanya waktu ideal untuk melihatnya adalah jam 2 hingga jam 4 dini hari, karena pendakian Gunung Ijen baru mulai dibuka jam 2 dini hari.",
        "price": 270136,
        "stock_tickets": 18,
        "sold_tickets": "9",
        "duration": "5 Hari 3 Malam",
        "rating": "3,2"
    },
    {
        "id_climb": 8,
        "climb_name": "Pendakian Gunung Kawi",
        "height": 2551,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung kawi memiliki banyak sebutan diantaranya Gunung Putri Tidur, karena jika di pandang dari sisi sebelah timur tepatnya dari arah Kota Malang dan sisi barat dari Kota kesamben, Wlingi Blitar, Gunung Kawi terlihat seperti wanita yang sedang tidur lengkap dengan kepala berada di sebelah selatan sampai dada dan kaki yang menjuntai kearah utara. Gunung ini cukup dikenal karena adanya tempat ziarah Pesarean Gunung Kawi",
        "price": 688131,
        "stock_tickets": 31,
        "sold_tickets": "8",
        "duration": "1 Hari 1 Malam",
        "rating": "0,1"
    },
    {
        "id_climb": 9,
        "climb_name": "Pendakian Gunung Kelud",
        "height": 1731,
        "city": "Kediri",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Kelud telah menjadi objek wisata Kabupaten Kediri dengan atraksi utama adalah kubah lava. Di puncak Gajahmungkur dibangun gardu pandang dengan tangga terbuat dari semen. Pada malam akhir pekan, kubah lava diberi penerangan lampu berwarna-warni. Selain itu, telah disediakan pula jalur panjat tebing di puncak Sumbing, pemandian air panas, serta flying fox.",
        "price": 526984,
        "stock_tickets": 35,
        "sold_tickets": "26",
        "duration": "3 Hari 4 Malam",
        "rating": "1,5"
    },
    {
        "id_climb": 10,
        "climb_name": "Pendakian Gunung Kembang",
        "height": 2120,
        "city": "Lumajang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung yang populer disebut sebagai anak Gunung Sindoro dan termasuk gunung yang tak terlalu tinggi, tetapi masyarakat percaya bahwa gunung ini dapat terus bertambah tinggi. Tak hanya sebagai nama saja, namun gunung Kembang memang benar-benar merupakan gunung yang memiliki banyak spesies bunga. Dikabarkan sedikitnya adalah 100 jenis bunga anggrek yang hidup dan berkembang di sini.",
        "price": 283830,
        "stock_tickets": 40,
        "sold_tickets": "26",
        "duration": "5 Hari 4 Malam",
        "rating": "4,3"
    }
]

```

<br>

- **Show Mountaineering List by id**
  > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/:id
  
  **Required**
  
  > id = [integer]

  **Example request**
  
  > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/8
```json
{
    "id_climb": 8,
    "climb_name": "Pendakian Gunung Kawi",
    "height": 2551,
    "city": "Malang",
    "province": "Jawa Timur",
    "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
    "description": "Gunung kawi memiliki banyak sebutan diantaranya Gunung Putri Tidur, karena jika di pandang dari sisi sebelah timur tepatnya dari arah Kota Malang dan sisi barat dari Kota kesamben, Wlingi Blitar, Gunung Kawi terlihat seperti wanita yang sedang tidur lengkap dengan kepala berada di sebelah selatan sampai dada dan kaki yang menjuntai kearah utara. Gunung ini cukup dikenal karena adanya tempat ziarah Pesarean Gunung Kawi",
    "price": 688131,
    "stock_tickets": 31,
    "sold_tickets": "8",
    "duration": "1 Hari 1 Malam",
    "rating": "0,1"
}
```

<br>

- **Show Mountaineering List search by name**
  > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/search/climb_name?climb_name={climb_name}
  
   **Required**
   
   > name = [string]

   **Example request**
   
   > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/search/climb_name?climb_name=Pendakian Gunung Bromo

 ```json
 {
    "id_climb": 3,
    "climb_name": "Pendakian Gunung Bromo",
    "height": 2392,
    "city": "Probolinggo",
    "province": "Jawa Timur",
    "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
    "description": "Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru. Bagi penduduk sekitar Gunung Bromo, suku Tengger, Gunung Bromo/Gunung Brahma dipercaya sebagai gunung suci. Setiap setahun sekali masyarakat Tengger mengadakan upacara Yadnya Kasada atau Kasodo. Upacara ini bertempat di sebuah pura yang berada di bawah kaki Gunung Bromo dan dilanjutkan ke puncak Bromo.",
    "price": 399585,
    "stock_tickets": 10,
    "sold_tickets": "9",
    "duration": "3 Hari 3 Malam",
    "rating": "5,4"
}
```

<br>

- **Show Mountaineering List search by city**
  > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/search/city?city={city}
  
   **Required**
   
   > city = [string]
   
   **Example request**
   
   > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/search/city?city=malang
```json
[
  {
        "id_climb": 1,
        "climb_name": "Pendakian Gunung Arjuno",
        "height": 3339,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Arjuno merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Biasanya gunung ini dicapai dari tiga titik pendakian yang cukup dikenal yaitu dari Lawang, Tretes dan Batu. Nama Arjuno berasal dari salah satu tokoh pewayangan Mahabharata, Arjuna.",
        "price": 735065,
        "stock_tickets": 8,
        "sold_tickets": "3",
        "duration": "5 Hari 3 Malam",
        "rating": "4,1"
    },
    {
        "id_climb": 8,
        "climb_name": "Pendakian Gunung Kawi",
        "height": 2551,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung kawi memiliki banyak sebutan diantaranya Gunung Putri Tidur, karena jika di pandang dari sisi sebelah timur tepatnya dari arah Kota Malang dan sisi barat dari Kota kesamben, Wlingi Blitar, Gunung Kawi terlihat seperti wanita yang sedang tidur lengkap dengan kepala berada di sebelah selatan sampai dada dan kaki yang menjuntai kearah utara. Gunung ini cukup dikenal karena adanya tempat ziarah Pesarean Gunung Kawi",
        "price": 688131,
        "stock_tickets": 31,
        "sold_tickets": "8",
        "duration": "1 Hari 1 Malam",
        "rating": "0,1"
    },
    {
        "id_climb": 12,
        "climb_name": "Pendakian Gunung Lambu",
        "height": 2327,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem.",
        "price": 456482,
        "stock_tickets": 33,
        "sold_tickets": "14",
        "duration": "2 Hari 5 Malam",
        "rating": "1,2"
    },
    {
        "id_climb": 14,
        "climb_name": "Pendakian Gunung Liman",
        "height": 2253,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Puncak ini merupakan titik tertinggi dari pegunungan yang luas dan kompleks yang paling dikenal sebagai Wilis. Ada tiga puncak utama, masing-masing merupakan yang tertinggi di satu bagian pegunungan: Liman (2.563m – punggungan gunung di sebelah barat), Limas (2.376m atau lebih tinggi – pegunungan timur) dan Wilis (2.182m – puncak gunung). pegunungan selatan) tetapi ada sejumlah besar puncak lainnya dengan penurunan yang cukup besar di antaranya. Wilis adalah nama yang paling terkenal dan Limas adalah yang paling sering didaki (dari Roro Kuning melalui Nganjuk, atau terkadang dari sisi Kediri di Besuki.)",
        "price": 279091,
        "stock_tickets": 40,
        "sold_tickets": "11",
        "duration": "4 Hari 3 Malam",
        "rating": "1,0"
    },
    {
        "id_climb": 15,
        "climb_name": "Pendakian Gunung Mahameru",
        "height": 3676,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Puncak Gunung Semeru dikenal dengan nama Mahameru. Meru berarti gunung dalam mitologi Hindu yang menjadi tempat persemayaman para dewa dan makhluk kedewaan serta menjadi pusat jagat raya. Dari Mahameru, pendaki bisa melihat pemandangan Kota Malang di sebelah barat. Di utara terlihat Gunung Kepolo dan pegunungan Tengger. Sementara sebelah timur terlihat Gunung Argopuro dan garis pantai selatan yan terlihat dari arah selatan Mahamaru. Tak hanya itu. Di Mahameru, ada kepulan asap yang dilontarkan kawah Jongrang Seloko yang masih aktif. ",
        "price": 928760,
        "stock_tickets": 13,
        "sold_tickets": "8",
        "duration": "4 Hari 5 Malam",
        "rating": "5,1"
    },
    {
        "id_climb": 16,
        "climb_name": "Pendakian Gunung Panderman",
        "height": 2045,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Nama Panderman berasal dari asal kata \"Dermo\" dalam bahasa jawa berarti 'sekedar' Seperti umumnya di Jawa, dulunya gunung sering dijadikan tempat bertapa.Begitu juga dengan gunung Panderman. Karena letaknya yang tidak terlalu jauh dari pemukiman dan juga tidak terlalu tinggi dibanding gunung disekitarnya, maka gunung ini hanya 'sekedar' digunakan untuk menyepi sejenak, merenungi diri atau dalam bahasa jawa sadermo mandireng pribadi. Istimewanya Panderman yang pertama jelas faktor lokasi. Mudah dijangkau dari kota Malang apalagi Batu. Bahkan cocok juga buat one day trip",
        "price": 295626,
        "stock_tickets": 50,
        "sold_tickets": "12",
        "duration": "5 Hari 1 Malam",
        "rating": "3,5"
    },
    {
        "id_climb": 19,
        "climb_name": "Pendakian Gunung Semeru",
        "height": 3676,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Semeru merupakan gunung tertinggi di Pulau Jawa, dengan puncaknya Mahameru. Flora yang berada di wilayah Gunung Semeru beraneka ragam jenisnya tetapi banyak didominir oleh pohon cemara, akasia, pinus, dan jenis Jamuju. Sedangkan untuk tumbuhan bawah didominasi oleh kirinyuh, alang-alang, tembelekan, harendong dan edelwiss putih. Edelwis juga banyak ditemukan di lereng-lereng menuju puncak Semeru. Terdapat pula spesies bunga anggrek endemik yang hidup di sekitar Gunung Semeru bagian selatan yakni Anggrek selop. Menurut kepercayaan masyarakat Jawa yang ditulis pada kitab kuno Tantu Pagelaran yang berasal dari abad ke-15, pada dahulu kala Pulau Jawa mengambang di lautan luas, terombang-ambing dan senantiasa berguncang. Para Dewa memutuskan untuk memakukan Pulau Jawa dengan cara memindahkan Gunung Meru di India ke atas Pulau Jawa.",
        "price": 782554,
        "stock_tickets": 19,
        "sold_tickets": "8",
        "duration": "4 Hari 5 Malam",
        "rating": "4,3"
    },
    {
        "id_climb": 20,
        "climb_name": "Pendakian Gunung Welirang",
        "height": 3156,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Welirang bersebelahan dengan Gunung Arjuno, Gunung Kembar I, dan Gunung Kembar II. Puncak Gunung Welirang terletak pada satu punggungan yang sama dengan puncak gunung Arjuno, sehingga kompleks ini sering disebut juga dengan Arjuno-Welirang. \"Welirang\" atau Walirang (nama kunanya) dalam bahasa Jawa berarti belerang. Jalur pendakian dapat dilakukan melalui Desa Claket, Kecamatan Pacet, Mojokerto. Di bagian sekitar puncak hidup tumbuhan endemik yang dinamakan penduduk setempat sebagai manis rejo.",
        "price": 762896,
        "stock_tickets": 33,
        "sold_tickets": "30",
        "duration": "2 Hari 5 Malam",
        "rating": "0,1"
    }
]
```

<br>

- **Show Mountaineering List search by province**
  > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/search/province?province={province}
  
   **Required**
   
   > province = [string]
   
   **Example request**
   
   > https://backend-dot-temendaki-test.et.r.appspot.com/pendakian/search/province?province=jawa timur
```json
[
  {
        "id_climb": 1,
        "climb_name": "Pendakian Gunung Arjuno",
        "height": 3339,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Arjuno merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Biasanya gunung ini dicapai dari tiga titik pendakian yang cukup dikenal yaitu dari Lawang, Tretes dan Batu. Nama Arjuno berasal dari salah satu tokoh pewayangan Mahabharata, Arjuna.",
        "price": 735065,
        "stock_tickets": 8,
        "sold_tickets": "3",
        "duration": "5 Hari 3 Malam",
        "rating": "4,1"
    },
    {
        "id_climb": 2,
        "climb_name": "Pendakian Gunung Argopuro",
        "height": 3088,
        "city": "Bondowoso",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Argapura merupakan bekas gunung berapi yang kini sudah tidak aktif lagi. Puncak Gunung Argapura adalah titik tertinggi di Pegunungan Iyang. Gunung Argopuro dikenal sebagai salah satu tujuan pendakian dengan trek terpanjang di Pulau Jawa yaitu sepanjang 40 kilometer.",
        "price": 486772,
        "stock_tickets": 49,
        "sold_tickets": "29",
        "duration": "5 Hari 3 Malam",
        "rating": "0,3"
    },
    {
        "id_climb": 3,
        "climb_name": "Pendakian Gunung Bromo",
        "height": 2392,
        "city": "Probolinggo",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru. Bagi penduduk sekitar Gunung Bromo, suku Tengger, Gunung Bromo/Gunung Brahma dipercaya sebagai gunung suci. Setiap setahun sekali masyarakat Tengger mengadakan upacara Yadnya Kasada atau Kasodo. Upacara ini bertempat di sebuah pura yang berada di bawah kaki Gunung Bromo dan dilanjutkan ke puncak Bromo.",
        "price": 399585,
        "stock_tickets": 10,
        "sold_tickets": "9",
        "duration": "3 Hari 3 Malam",
        "rating": "5,4"
    },
    {
        "id_climb": 4,
        "climb_name": "Pendakian Gunung Butak",
        "height": 2868,
        "city": "Tulungagung",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Butak adalah gunung stratovolcano yang terletak di perbatasan Kabupaten Malang dan Kabupaten Blitar, Jawa Timur, Indonesia. Nama “Butak” di dalam padanan nama Gunung Butak berarti sabana yang mengalami kekeringan saat musim kemarau tiba.",
        "price": 903640,
        "stock_tickets": 38,
        "sold_tickets": "38",
        "duration": "5 Hari 4 Malam",
        "rating": "0,0"
    },
    {
        "id_climb": 5,
        "climb_name": "Pendakian Gunung Cemoro Sewu",
        "height": 3339,
        "city": "Lumajang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lokasi basecamp Cemoro Sewu berada di Jl. Raya Sarangan, Sampe, Ngancar, Kec. Plaosan, Kabupaten Magetan. Dalam kondisi normal, waktu tempuh pendakian ke puncak Lawu via Cemoro Sewu sekitar 2-3 hari. Sebagian besar jalurnya terbuat dari batu sehingga relatif aman mendaki di musim apa pun, baik kemarau maupun hujan.",
        "price": 307908,
        "stock_tickets": 13,
        "sold_tickets": "4",
        "duration": "2 Hari 5 Malam",
        "rating": "3,0"
    },
    {
        "id_climb": 6,
        "climb_name": "Pendakian Gunung Egon",
        "height": 1703,
        "city": "Kediri",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "",
        "price": 534732,
        "stock_tickets": 48,
        "sold_tickets": "37",
        "duration": "1 Hari 4 Malam",
        "rating": "4,2"
    },
    {
        "id_climb": 7,
        "climb_name": "Pendakian Gunung Ijen",
        "height": 2799,
        "city": "Banyuwangi",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Salah satu fenomena alam yang paling terkenal dari Gunung Ijen adalah blue fire (api biru) di dalam kawah yang terletak di puncak gunung tersebut. Pendakian gunung ini bisa dimulai dari dua tempat, yakni dari Banyuwangi atau dari Bondowoso. Kawah Ijen adalah sebuah danau kawah yang bersifat asam yang berada di puncak Gunung Ijen dengan kedalaman danau 200 meter dan luas kawah mencapai 5.466 Hektar. Danau kawah Ijen dikenal merupakan danau air asam kuat terbesar di dunia. Blue fire hanya dapat dilihat oleh mata manusia saat tidak ada cahaya, karenanya waktu ideal untuk melihatnya adalah jam 2 hingga jam 4 dini hari, karena pendakian Gunung Ijen baru mulai dibuka jam 2 dini hari.",
        "price": 270136,
        "stock_tickets": 18,
        "sold_tickets": "9",
        "duration": "5 Hari 3 Malam",
        "rating": "3,2"
    },
    {
        "id_climb": 8,
        "climb_name": "Pendakian Gunung Kawi",
        "height": 2551,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung kawi memiliki banyak sebutan diantaranya Gunung Putri Tidur, karena jika di pandang dari sisi sebelah timur tepatnya dari arah Kota Malang dan sisi barat dari Kota kesamben, Wlingi Blitar, Gunung Kawi terlihat seperti wanita yang sedang tidur lengkap dengan kepala berada di sebelah selatan sampai dada dan kaki yang menjuntai kearah utara. Gunung ini cukup dikenal karena adanya tempat ziarah Pesarean Gunung Kawi",
        "price": 688131,
        "stock_tickets": 31,
        "sold_tickets": "8",
        "duration": "1 Hari 1 Malam",
        "rating": "0,1"
    },
    {
        "id_climb": 9,
        "climb_name": "Pendakian Gunung Kelud",
        "height": 1731,
        "city": "Kediri",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Kelud telah menjadi objek wisata Kabupaten Kediri dengan atraksi utama adalah kubah lava. Di puncak Gajahmungkur dibangun gardu pandang dengan tangga terbuat dari semen. Pada malam akhir pekan, kubah lava diberi penerangan lampu berwarna-warni. Selain itu, telah disediakan pula jalur panjat tebing di puncak Sumbing, pemandian air panas, serta flying fox.",
        "price": 526984,
        "stock_tickets": 35,
        "sold_tickets": "26",
        "duration": "3 Hari 4 Malam",
        "rating": "1,5"
    },
    {
        "id_climb": 10,
        "climb_name": "Pendakian Gunung Kembang",
        "height": 2120,
        "city": "Lumajang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung yang populer disebut sebagai anak Gunung Sindoro dan termasuk gunung yang tak terlalu tinggi, tetapi masyarakat percaya bahwa gunung ini dapat terus bertambah tinggi. Tak hanya sebagai nama saja, namun gunung Kembang memang benar-benar merupakan gunung yang memiliki banyak spesies bunga. Dikabarkan sedikitnya adalah 100 jenis bunga anggrek yang hidup dan berkembang di sini.",
        "price": 283830,
        "stock_tickets": 40,
        "sold_tickets": "26",
        "duration": "5 Hari 4 Malam",
        "rating": "4,3"
    },
    {
        "id_climb": 11,
        "climb_name": "Pendakian Gunung Kukusan",
        "height": 1815,
        "city": "Lumajang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem.",
        "price": 236429,
        "stock_tickets": 27,
        "sold_tickets": "14",
        "duration": "5 Hari 4 Malam",
        "rating": "3,2"
    },
    {
        "id_climb": 12,
        "climb_name": "Pendakian Gunung Lambu",
        "height": 2327,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem.",
        "price": 456482,
        "stock_tickets": 33,
        "sold_tickets": "14",
        "duration": "2 Hari 5 Malam",
        "rating": "1,2"
    },
    {
        "id_climb": 13,
        "climb_name": "Pendakian Gunung Lawu",
        "height": 3265,
        "city": "Magetan",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Nama Gunung Lawu, yang berarti unggul, oleh masyarakat setempat disebut juga sebagai Wukir Mahendra Giri. Kata tersebut berasal dari bahasa Jawa, dan ketiganya memiliki arti yang sama yaitu gunung; sehingga dapat diartikan sebagai tiga gunung. Hal ini sejalan dengan fakta bahwa Gunung Lawu memang memiliki tiga puncak besar yaitu Hargo Dalem, Hargo Dumiling, dan Hargo Dumilah.",
        "price": 649753,
        "stock_tickets": 1,
        "sold_tickets": "1",
        "duration": "1 Hari 3 Malam",
        "rating": "5,5"
    },
    {
        "id_climb": 14,
        "climb_name": "Pendakian Gunung Liman",
        "height": 2253,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Puncak ini merupakan titik tertinggi dari pegunungan yang luas dan kompleks yang paling dikenal sebagai Wilis. Ada tiga puncak utama, masing-masing merupakan yang tertinggi di satu bagian pegunungan: Liman (2.563m – punggungan gunung di sebelah barat), Limas (2.376m atau lebih tinggi – pegunungan timur) dan Wilis (2.182m – puncak gunung). pegunungan selatan) tetapi ada sejumlah besar puncak lainnya dengan penurunan yang cukup besar di antaranya. Wilis adalah nama yang paling terkenal dan Limas adalah yang paling sering didaki (dari Roro Kuning melalui Nganjuk, atau terkadang dari sisi Kediri di Besuki.)",
        "price": 279091,
        "stock_tickets": 40,
        "sold_tickets": "11",
        "duration": "4 Hari 3 Malam",
        "rating": "1,0"
    },
    {
        "id_climb": 15,
        "climb_name": "Pendakian Gunung Mahameru",
        "height": 3676,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Puncak Gunung Semeru dikenal dengan nama Mahameru. Meru berarti gunung dalam mitologi Hindu yang menjadi tempat persemayaman para dewa dan makhluk kedewaan serta menjadi pusat jagat raya. Dari Mahameru, pendaki bisa melihat pemandangan Kota Malang di sebelah barat. Di utara terlihat Gunung Kepolo dan pegunungan Tengger. Sementara sebelah timur terlihat Gunung Argopuro dan garis pantai selatan yan terlihat dari arah selatan Mahamaru. Tak hanya itu. Di Mahameru, ada kepulan asap yang dilontarkan kawah Jongrang Seloko yang masih aktif. ",
        "price": 928760,
        "stock_tickets": 13,
        "sold_tickets": "8",
        "duration": "4 Hari 5 Malam",
        "rating": "5,1"
    },
    {
        "id_climb": 16,
        "climb_name": "Pendakian Gunung Panderman",
        "height": 2045,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Nama Panderman berasal dari asal kata \"Dermo\" dalam bahasa jawa berarti 'sekedar' Seperti umumnya di Jawa, dulunya gunung sering dijadikan tempat bertapa.Begitu juga dengan gunung Panderman. Karena letaknya yang tidak terlalu jauh dari pemukiman dan juga tidak terlalu tinggi dibanding gunung disekitarnya, maka gunung ini hanya 'sekedar' digunakan untuk menyepi sejenak, merenungi diri atau dalam bahasa jawa sadermo mandireng pribadi. Istimewanya Panderman yang pertama jelas faktor lokasi. Mudah dijangkau dari kota Malang apalagi Batu. Bahkan cocok juga buat one day trip",
        "price": 295626,
        "stock_tickets": 50,
        "sold_tickets": "12",
        "duration": "5 Hari 1 Malam",
        "rating": "3,5"
    },
    {
        "id_climb": 17,
        "climb_name": "Pendakian Gunung Penanggungan",
        "height": 1653,
        "city": "Pasuruan",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Penanggungan merupakan gunung kecil yang berada pada satu kluster dengan Gunung Arjuno dan Gunung Welirang yang jauh lebih besar. Meskipun kecil, gunung ini memiliki keunikan dari sisi kesejarahan, karena di sekujur permukaannya, mulai dari kaki sampai mendekati puncak, dipenuhi banyak situs kepurbakalaan yang dibangun pada periode Hindu-Buddha dalam sejarah Indonesia. Gunung Penanggungan dipandang sebagai gunung keramat, suci, dan merupakan jelmaan Mahameru, gunungnya para dewa.",
        "price": 371458,
        "stock_tickets": 10,
        "sold_tickets": "2",
        "duration": "1 Hari 4 Malam",
        "rating": "1,1"
    },
    {
        "id_climb": 18,
        "climb_name": "Pendakian Gunung Raung",
        "height": 3344,
        "city": "Bondowoso",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Dihitung dari titik tertinggi, Gunung Raung merupakan gunung tertinggi ketiga di Jawa Timur setelah Gunung Semeru dan Gunung Arjuno, serta menjadi yang tertinggi keempat di Pulau Jawa. Kaldera Gunung Raung juga merupakan kaldera kering yang terbesar di Pulau Jawa dan terbesar kedua di Indonesia setelah Gunung Tambora di Nusa Tenggara Barat. Gunung Raung diketahui pertama kali meletus pada tahun 1586 silam. Saat itu, gunung ini meletus hebat dan menyebabkan abu vulkaniknya melanda beberapa daerah, dan banyak korban jiwa. Gunung Raung dikenal memiliki jalur pendakian yang ekstrem. Bahkan, saking ekstremnya ada yang menjuluki jalur pendakian Gunung Raung mirip Jembatan Shiratal Mustaqim.",
        "price": 873909,
        "stock_tickets": 14,
        "sold_tickets": "2",
        "duration": "2 Hari 3 Malam",
        "rating": "2,1"
    },
    {
        "id_climb": 19,
        "climb_name": "Pendakian Gunung Semeru",
        "height": 3676,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Semeru merupakan gunung tertinggi di Pulau Jawa, dengan puncaknya Mahameru. Flora yang berada di wilayah Gunung Semeru beraneka ragam jenisnya tetapi banyak didominir oleh pohon cemara, akasia, pinus, dan jenis Jamuju. Sedangkan untuk tumbuhan bawah didominasi oleh kirinyuh, alang-alang, tembelekan, harendong dan edelwiss putih. Edelwis juga banyak ditemukan di lereng-lereng menuju puncak Semeru. Terdapat pula spesies bunga anggrek endemik yang hidup di sekitar Gunung Semeru bagian selatan yakni Anggrek selop. Menurut kepercayaan masyarakat Jawa yang ditulis pada kitab kuno Tantu Pagelaran yang berasal dari abad ke-15, pada dahulu kala Pulau Jawa mengambang di lautan luas, terombang-ambing dan senantiasa berguncang. Para Dewa memutuskan untuk memakukan Pulau Jawa dengan cara memindahkan Gunung Meru di India ke atas Pulau Jawa.",
        "price": 782554,
        "stock_tickets": 19,
        "sold_tickets": "8",
        "duration": "4 Hari 5 Malam",
        "rating": "4,3"
    },
    {
        "id_climb": 20,
        "climb_name": "Pendakian Gunung Welirang",
        "height": 3156,
        "city": "Malang",
        "province": "Jawa Timur",
        "link_image": "https://storage.googleapis.com/temendaki-test.appspot.com/Gunung.jpg",
        "description": "Gunung Welirang bersebelahan dengan Gunung Arjuno, Gunung Kembar I, dan Gunung Kembar II. Puncak Gunung Welirang terletak pada satu punggungan yang sama dengan puncak gunung Arjuno, sehingga kompleks ini sering disebut juga dengan Arjuno-Welirang. \"Welirang\" atau Walirang (nama kunanya) dalam bahasa Jawa berarti belerang. Jalur pendakian dapat dilakukan melalui Desa Claket, Kecamatan Pacet, Mojokerto. Di bagian sekitar puncak hidup tumbuhan endemik yang dinamakan penduduk setempat sebagai manis rejo.",
        "price": 762896,
        "stock_tickets": 33,
        "sold_tickets": "30",
        "duration": "2 Hari 5 Malam",
        "rating": "0,1"
    }
]
```

<br>

