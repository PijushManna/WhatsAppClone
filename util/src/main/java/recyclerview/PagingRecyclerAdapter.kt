package recyclerview

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter

class PagingRecyclerAdapter(private val viewHolder: BaseViewHolder) : PagingDataAdapter<BaseModel, BaseViewHolder>(BaseRecyclerAdapter.BaseDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return viewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it) }
    }
}