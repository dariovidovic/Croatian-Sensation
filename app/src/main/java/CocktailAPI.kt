import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailAPI {
    @GET("/api/json/v1/1/search.php")
    fun getCocktailData(@Query("s")cocktailName:String):Call<CocktailsInfo>

}