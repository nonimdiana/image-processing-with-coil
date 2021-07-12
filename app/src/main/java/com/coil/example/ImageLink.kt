package com.coil.example

class ImageLinks {
    private val links = arrayListOf<String>(
        "https://images.freeimages.com/images/large-previews/825/linked-hands-1308777.jpg",
        "https://images.unsplash.com/photo-1541443131876-44b03de101c5?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=mathieu-renier-4WBvCqeMaDE-unsplash.jpg",
        "https://images.unsplash.com/photo-1549399542-7e3f8b79c341?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=roberto-nickson-zu95jkyrGtw-unsplash.jpg",
        "https://www.cnet.com/a/img/XtH050ErlMIQxKn_HYUx2plJnDc=/940x528/2020/12/17/c9a829c8-69d6-4299-b2d0-cf9624aa7556/2021-acura-tlx-a-spec-65.jpg",
        "https://cdn.jdpower.com/JDPA_2021%20Acura%20TLX%20Advance%20Red%20Front%20View.jpg",
        "https://s3-us-east-2.amazonaws.com/matter-blog/2020/09/People_Person_Cover_Image.png",
        "https://images.fandango.com/ImageRenderer/0/0/redesign/static/img/default_poster.png/0/images/masterrepository/other/ant_man_ver5.jpg"
    )

    fun randomLink(): String {
        return links.random()
    }
}