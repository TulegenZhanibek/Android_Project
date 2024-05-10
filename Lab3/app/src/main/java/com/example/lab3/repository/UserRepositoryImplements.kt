import com.android.volley.NetworkResponse
import com.example.lab3.database.UserDao
import com.example.lab3.database.Users
import com.example.lab3.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImplements @Inject constructor(
    private  var usersDao: UserDao,
    private var apiService: ApiService

):UserRepository{

    override fun addUser(users:Users): Long {
        return usersDao.insertUser(users)
    }

    override fun addUserList(users:List<Users>): List<Long> {
        return usersDao.insertUserAll(users)
    }

    override fun deleteUser(users: Users) {
        TODO("Not yet implemented")
    }

    override fun verifyLoginUser(email:String, password:String): Users {
        return usersDao.readLoginData(email = email, password = password )
    }

    override fun getUserDataDetails(id:Long): Users {
        return usersDao.getUserDataDetails(id)
    }

    override suspend fun getDataFromNetwork(): NetworkResponse {
        TODO("Not yet implemented")
    }

}