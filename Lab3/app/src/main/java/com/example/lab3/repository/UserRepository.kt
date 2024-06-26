import com.android.volley.NetworkResponse
import com.example.lab3.database.Users

interface UserRepository {

    fun addUser(users: Users):Long

    fun addUserList(users: List<Users>):List<Long>

    fun deleteUser(users: Users)

    fun verifyLoginUser(mobNum:String,password:String): Users

    fun getUserDataDetails(id:Long):Users

    suspend fun getDataFromNetwork(): NetworkResponse

}
