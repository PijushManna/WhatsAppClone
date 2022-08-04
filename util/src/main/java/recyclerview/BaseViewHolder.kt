package recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: BaseModel)
    abstract fun from(parent: ViewGroup): BaseViewHolder
}