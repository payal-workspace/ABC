package com.example.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SportsModelData
import com.example.presentation.databinding.CarouselItemBinding

class CarouselAdapter : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    private var categories = listOf<SportsModelData>()

    fun submitList(newCategories: List<SportsModelData>) {
        val diffResult = DiffUtil.calculateDiff(CarouselDiffCallback(categories, newCategories))
        categories = newCategories
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categories[position]
        holder.bind(item)
    }

    class ViewHolder(private val binding: CarouselItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SportsModelData) {
            binding.sportsImage.setBackgroundResource(item.sportsCategoryImageUrl)
        }
    }

    class CarouselDiffCallback(
        private val oldList: List<SportsModelData>,
        private val newList: List<SportsModelData>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].sportsCategoryTitle == newList[newItemPosition].sportsCategoryTitle
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    override fun getItemCount(): Int = categories.size
}



