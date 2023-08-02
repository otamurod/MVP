package uz.otamurod.mvp.presenter

import uz.otamurod.mvp.db.UserEntity

interface ContractView {
    fun showProgressBar()

    fun hideProgressBar()

    fun showUsers(usersList: List<UserEntity>)
}