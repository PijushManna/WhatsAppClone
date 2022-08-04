package recyclerview

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class BaseRecyclerAdapter(private val viewHolder: BaseViewHolder) : ListAdapter<BaseModel, BaseViewHolder>(
    BaseDiffUtilCallback()
) {
    class BaseDiffUtilCallback : DiffUtil.ItemCallback<BaseModel>(){
        override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
       return viewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}