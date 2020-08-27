package com.pocbeagle.bff.Data

data class YearData(
        val text: String
)

//text: A string of the fact text itself.
//number: The floating-point number that the fact pertains to. This may be useful for, eg. a /random request or notfound=floor. For a date fact, this is the 1-indexed day of a leap year (eg. 61 would be March 1st).
//type: String of the category of the returned fact.
//date (sometimes): A day of year associated with some year facts, as a string.
//year (sometimes): A year associated with some date facts, as a string.