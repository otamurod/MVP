package uz.otamurod.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import uz.otamurod.mvp.adapters.UserAdapter
import uz.otamurod.mvp.databinding.ActivityMainBinding
import uz.otamurod.mvp.db.UserEntity
import uz.otamurod.mvp.presenter.ContractView
import uz.otamurod.mvp.presenter.UserPresenter

/**
 * MVP - Model View Presenter
 * Model = AppDatabase
 * View = RecyclerView in activity_main.xml
 */

class MainActivity : AppCompatActivity(), ContractView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userPresenter: UserPresenter
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter()
        binding.rv.adapter = userAdapter

        userPresenter = UserPresenter(this, this)
        userPresenter.getAllUsers()

        binding.apply {
            saveBtn.setOnClickListener {
                val name = nameEt.text.toString()
                val age = ageEt.text.toString().toInt()

                userPresenter.addUser(name, age)
                nameEt.text.clear()
                ageEt.text.clear()
            }
        }
    }

    override fun showProgressBar() {
        binding.apply {
            rv.isVisible = false
            progressBar.isVisible = true
        }
    }

    override fun hideProgressBar() {
        binding.apply {
            rv.isVisible = true
            progressBar.isVisible = false
        }
    }

    override fun showUsers(usersList: List<UserEntity>) {
        userAdapter.submitList(usersList)
    }
}