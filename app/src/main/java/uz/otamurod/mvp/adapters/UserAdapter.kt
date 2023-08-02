package uz.otamurod.mvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.otamurod.mvp.databinding.ItemUserBinding
import uz.otamurod.mvp.db.UserEntity

class UserAdapter : ListAdapter<UserEntity, UserAdapter.ViewHolder>(MyDiffUtil()) {

    inner class ViewHolder(val itemUserBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemUserBinding.root) {
        fun onBind(userEntity: UserEntity) {
            itemUserBinding.apply {
                name.text = String.format("Name: %s", userEntity.name)
                age.text = String.format("Age: %d", userEntity.age)
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}