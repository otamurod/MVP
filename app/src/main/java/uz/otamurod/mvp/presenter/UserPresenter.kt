package uz.otamurod.mvp.presenter

import android.content.Context
import uz.otamurod.mvp.db.AppDatabase
import uz.otamurod.mvp.db.UserEntity

/**
 * Presenter
 */
class UserPresenter(context: Context, private val contractView: ContractView) {
    private val appDatabase = AppDatabase.getInstance(context)
    private val userDao = appDatabase.userDao()

    fun getAllUsers() {
        contractView.showProgressBar()
        contractView.showUsers(userDao.getAllUsers())
        contractView.hideProgressBar()
    }

    fun addUser(name: String, age: Int) {
        val userEntity = UserEntity(name = name, age = age)
        userDao.addUser(userEntity)
        // update view
        getAllUsers()
    }
}